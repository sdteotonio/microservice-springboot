package com.app.mspessoa.services;

import com.app.mspessoa.domain.dto.ListarPessoaDto;
import com.app.mspessoa.domain.dto.ManterPessoaDto;
import com.app.mspessoa.domain.dto.RecuperarPessoaDto;
import com.app.mspessoa.domain.dto.RetornoPadraoDto;

import java.util.List;

public interface PessoaService {
    /**
     * Listar todas as pessoas cadastradas no sistema
     * @return Uma lista de pessoas preenchida ou uma lista vazia caso não exista dados.
     */
    List<ListarPessoaDto> listar();

    /**
     * Adicionar uma pessoa ao sistema de acordo os requisitos necessários
     * @param pessoa Pessoa para cadastro
     * @return Uma pessoa cadastrada com o seu respectivo ID de identificação
     */
    RetornoPadraoDto adicionar(ManterPessoaDto pessoa);

    /**
     * Recuperar uma pessoa a partir do identificador (ID)
     * @param id Valor do identificador da pessoa em inteiro
     * @return Caso exista, uma pessoa preenchida. Caso contrário, vazio.
     */
    RecuperarPessoaDto recuperar(Integer id);

    /**
     * Atualizar dados de uma pessoa existente no sistema.
     * @param id Valor do identificador da pessoa em inteiro
     * @param pessoa Dados para atualizaçaõ da pessoa identifacada com o Id informado.
     * @return Uma pessoa atualiazada.
     */
    RetornoPadraoDto atualizar(Integer id, ManterPessoaDto pessoa);

    /**
     * Remover uma pessoa do sistema
     * @param id Valor do identificador da pessoa em inteiro
     * @return
     */
    RetornoPadraoDto remover(Integer id);
}
