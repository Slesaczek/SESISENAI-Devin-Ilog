package com.tech.devinhouse.labschool;

import com.tech.devinhouse.labschool.model.*;
import com.tech.devinhouse.labschool.service.AlunoService;
import com.tech.devinhouse.labschool.service.PedagogoService;
import com.tech.devinhouse.labschool.service.ProfessorService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.time.LocalDate;

@SpringBootApplication
public class LabschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabschoolApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    CommandLineRunner run(AlunoService alunoService, ProfessorService professorService, PedagogoService pedagogoService) {
        return args -> {
            if (alunoService.consultar().isEmpty()) {
                alunoService.salvar(new Aluno(null,
                        "Bart Simpson",
                        "11-11111-1212",
                        LocalDate.of(2014, 10, 29),
                        118397500731l,
                        SituacaoMatriculaAluno.IRREGULAR,
                        3.5,
                        0));
                alunoService.salvar(new Aluno(null,
                        "Lisa Simpson",
                        "11-22222-2222",
                        LocalDate.of(2012, 10, 29),
                        17158947076l,
                        SituacaoMatriculaAluno.ATIVO,
                        10.0,
                        0));
                alunoService.salvar(new Aluno(null,
                        "Meggie Simpson",
                        "12-20002-2200",
                        LocalDate.of(2019, 10, 29),
                        63701210020l,
                        SituacaoMatriculaAluno.ATIVO,
                        9.0,
                        0));
                alunoService.salvar(new Aluno(null,
                        "Milhouse Van Houten",
                        "11-33333-2222",
                        LocalDate.of(2014, 10, 29),
                        30119137062l,
                        SituacaoMatriculaAluno.ATIVO,
                        8.0,
                        0));
                alunoService.salvar(new Aluno(null,
                        "Nelson Muntz",
                        "11-44333-4444",
                        LocalDate.of(2007, 10, 29),
                        95704094015l,
                        SituacaoMatriculaAluno.INATIVO,
                        2.0,
                        0));


            }
            if (professorService.consultar().isEmpty()) {

                professorService.salvar(new Professor(null,
                        "Walter White",
                        "14-22998-1882",
                        LocalDate.of(1982, 10, 30),
                        40539019011l,
                        EstadoProfessor.ATIVO,
                        ExperienciaProfessor.FULL_STACK,
                        FormacaoProfessor.MESTRADO));

                professorService.salvar(new Professor(null,
                        "Jesse Pinkman",
                        "44-11111-1992",
                        LocalDate.of(1997, 10, 30),
                        96107295097l,
                        EstadoProfessor.ATIVO,
                        ExperienciaProfessor.BACK_END,
                        FormacaoProfessor.GRADUACAO_INCOMPLETA));

                professorService.salvar(new Professor(null,
                        "Hank Schrader",
                        "44-11111-1002",
                        LocalDate.of(1984, 10, 30),
                        70685977005l,
                        EstadoProfessor.ATIVO,
                        ExperienciaProfessor.FULL_STACK,
                        FormacaoProfessor.MESTRADO));

                professorService.salvar(new Professor(null,
                        "Gustavo Fring",
                        "44-11001-1002",
                        LocalDate.of(1977, 10, 30),
                        57408927085l,
                        EstadoProfessor.INATIVO,
                        ExperienciaProfessor.FRONT_END,
                        FormacaoProfessor.GRADUACAO_COMPLETA));

                professorService.salvar(new Professor(null,
                        "Saul Goodman",
                        "44-11998-1882",
                        LocalDate.of(1980, 10, 30),
                        86940162062l,
                        EstadoProfessor.ATIVO,
                        ExperienciaProfessor.FULL_STACK,
                        FormacaoProfessor.MESTRADO));

                if (pedagogoService.consultar().isEmpty()) {
                    pedagogoService.salvar(new Pedagogo(null,
                            "John Snow",
                            "11-67333-4454",
                            LocalDate.of(2000, 10, 30),
                            62316840086l,
                            0));

                    pedagogoService.salvar(new Pedagogo(null,
                            "Sansa Stark",
                            "22-22333-4454",
                            LocalDate.of(2004, 10, 30),
                            49850253053l,
                            0));

                    pedagogoService.salvar(new Pedagogo(null,
                            "Tyrion Lannister",
                            "33-77333-4454",
                            LocalDate.of(1990, 10, 30),
                            39125106015l,
                            0));

                    pedagogoService.salvar(new Pedagogo(null,
                            "Sandor Clegane",
                            "11-33333-2222",
                            LocalDate.of(1995, 10, 30),
                            89089606009l,
                            0));
                }


            }


        };
    }



}
