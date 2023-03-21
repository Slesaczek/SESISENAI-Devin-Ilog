import { Link, useNavigate } from "react-router-dom";
import "./NotFound.css";

function NotFoundPage() {
  const navigate = useNavigate();

  const handleGoToHome = () => {
    // redirecionamento com JavaScript nativo
    // window.location.href = "/";
    // redirecionamento com navigate de react-router-dom
    navigate("/");
  };

  return (
    <main className="ContactPageContainer">
      <h2>Página não encontrada</h2>
      <p>
        Volte para a página inicial clicando <Link to="/">aqui</Link>.
      </p>
      <button onClick={handleGoToHome}>Ir para página inicial</button>
    </main>
  );
}

export default NotFoundPage;
