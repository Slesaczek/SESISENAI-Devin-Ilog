package tech.devinhouse.copadomundo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.devinhouse.copadomundo.exception.RegistroExistenteException;
import tech.devinhouse.copadomundo.model.Usuario;
import tech.devinhouse.copadomundo.repository.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    private String segredo = "LKSDHFLKADHFA894375864T8427KDSJHFDLKJGJA"; // chave de assinatura

    public Usuario criar(Usuario usuario) {
        boolean existente = repo.existsUsuarioByEmail(usuario.getEmail()); //true ou false
        if (existente)
            throw new RegistroExistenteException("Usuario", usuario.getEmail());
        String senhaCodificada = encoder.encode(usuario.getSenha());
        usuario.setSenha( senhaCodificada );
        usuario = repo.save(usuario);
        return usuario;
    }

    public List<Usuario> consultar() {
        return repo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = repo.findByEmail(email);
        if (usuarioOpt.isEmpty())
            throw new UsernameNotFoundException("Usuário não encontrado!");
        Usuario usuario = usuarioOpt.get();
        return usuario;
    }

    /**
     * Gera um token JWT para o usuario.
     * @param usuario
     * @return String token JWT gerado
     */
    public String generateToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(segredo.getBytes());
        String accessToken = JWT.create()
                .withSubject(usuario.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 6000))  // expires in 10 min
                .withIssuer("Copa Do Mundo-API")
                .withClaim("roles", usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return accessToken;
    }

    /**
     * Extrai token do cabeçalho (header) Authorization.
     * @param authorizationHeader
     * @return String token JWT
     */
    public String getTokenFrom(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
            throw new IllegalArgumentException("Invalid Headers");
        String token = authorizationHeader.substring("Bearer ".length());
//        String token = authorizationHeader.split(" ")[1];
        return token;
    }

    /**
     * Decodifica o token JWT e retorna um objeto que representa os dados constantes no token.
     * @param token
     * @return Token decodificado
     */
    public DecodedJWT getDecodedTokenFrom(String token) {
        Algorithm algorithm = Algorithm.HMAC256(segredo.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }
}
