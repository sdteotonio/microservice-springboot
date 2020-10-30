package com.app.mspessoa.domain.dto;

import com.app.mspessoa.util.SerializadorData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ManterPessoaDto {
    @NotNull()
    @Size(max = 250)
    private String nome;

    @NotBlank()
    @Size(min = 11,max = 11)
    private String cpf;

    @JsonSerialize(using = SerializadorData.class)
    private LocalDate dataNascimento;

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
