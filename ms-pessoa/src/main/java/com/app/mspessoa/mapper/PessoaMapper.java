package com.app.mspessoa.mapper;

import com.app.mspessoa.domain.PessoaEntity;
import com.app.mspessoa.domain.dto.ListarPessoaDto;
import com.app.mspessoa.domain.dto.ManterPessoaDto;
import com.app.mspessoa.domain.dto.RecuperarPessoaDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaMapper{
    private PessoaMapper(){}

    public static List<ListarPessoaDto> paraLista(List<PessoaEntity> pessoas){
        List<ListarPessoaDto> pessoasDto = new ArrayList<>();
        pessoasDto.addAll(pessoas.stream().map(pessoaEntity -> {
            ListarPessoaDto p = new ListarPessoaDto();
            p.setCpf(pessoaEntity.getCpf());
            p.setDataNascimento(pessoaEntity.getDataNascimento());
            p.setId(pessoaEntity.getId());
            p.setNome(pessoaEntity.getNome());
            return p;
        }).collect(Collectors.toList()));

        return pessoasDto;
    }

    public static PessoaEntity paraCadastro(ManterPessoaDto pessoa){
        PessoaEntity novaPessoa = new PessoaEntity();
        novaPessoa.setCpf(pessoa.getCpf());
        novaPessoa.setDataNascimento(pessoa.getDataNascimento());
        novaPessoa.setNome(pessoa.getNome());
        return  novaPessoa;
    }

    public static RecuperarPessoaDto paraRecuperar(PessoaEntity pessoa){
        RecuperarPessoaDto novaPessoa = new RecuperarPessoaDto();
        novaPessoa.setCpf(pessoa.getCpf());
        novaPessoa.setDataNascimento(pessoa.getDataNascimento());
        novaPessoa.setNome(pessoa.getNome());
        return  novaPessoa;
    }

    public static void paraAtualizar(PessoaEntity novaPessoa,ManterPessoaDto pessoa){
        novaPessoa.setCpf(pessoa.getCpf());
        novaPessoa.setDataNascimento(pessoa.getDataNascimento());
        novaPessoa.setNome(pessoa.getNome());
    }


}