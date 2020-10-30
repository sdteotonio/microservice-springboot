package com.app.mspessoa.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity()
@Table(name = "pessoa")
public class PessoaEntity {

    @SequenceGenerator(name = "pessoa_sequence", allocationSize = 1, sequenceName = "pessoa_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_sequence")
    @Id()
    private Integer id;

    @Column(length = 250)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
