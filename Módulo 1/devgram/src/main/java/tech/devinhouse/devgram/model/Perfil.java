package tech.devinhouse.devgram.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERFIS")
public class Perfil {

        @Id
        private String nome;

        private String biografia;

        private LocalDate dataNascimento;

        private String profissao;

        private LocalDateTime dataCriacao;

        private LocalDateTime dataAtualizacao;

}

