package com.app.mspessoa.services.impl;


import com.app.mspessoa.constants.MensagemEnum;
import com.app.mspessoa.domain.PessoaEntity;
import com.app.mspessoa.domain.dto.ListarPessoaDto;
import com.app.mspessoa.domain.dto.ManterPessoaDto;
import com.app.mspessoa.domain.dto.RecuperarPessoaDto;
import com.app.mspessoa.domain.dto.RetornoPadraoDto;
import com.app.mspessoa.exceptions.ArtefatoNaoEncontradoException;
import com.app.mspessoa.exceptions.NegocioException;
import com.app.mspessoa.mapper.PessoaMapper;
import com.app.mspessoa.repository.PessoaRepository;
import com.app.mspessoa.services.PessoaService;
import com.app.mspessoa.util.MensagemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaMapper pessoaMapper;

    @Override
    public List<ListarPessoaDto> listar() {
        List<PessoaEntity> pessoas = this.pessoaRepository.findAll();
        return PessoaMapper.paraLista(pessoas);
    }

    @Override
    public RetornoPadraoDto adicionar(ManterPessoaDto pessoa) {
        this.validarCpfExistente(pessoa);
        PessoaEntity novaPessoa = this.pessoaRepository.save(PessoaMapper.paraCadastro(pessoa));
        return new RetornoPadraoDto(MensagemEnum.PESSOA_CADASTRADA, novaPessoa);
    }

    @Override
    public RecuperarPessoaDto recuperar(Integer id) {
        PessoaEntity pessoa = this.pessoaRepository
                .findById(id)
                .orElseThrow(() -> new ArtefatoNaoEncontradoException(MensagemUtil.getMessage(MensagemEnum.PESSOA_NAO_EXISTE)));
        return PessoaMapper.paraRecuperar(pessoa);
    }

    @Override
    public RetornoPadraoDto atualizar(Integer id, ManterPessoaDto pessoa) {
        if(!this.pessoaExiste(id)){
            throw new ArtefatoNaoEncontradoException(MensagemUtil.getMessage(MensagemEnum.PESSOA_NAO_EXISTE));
        }
        PessoaEntity pessoaEntity = this.pessoaRepository.getOne(id);
        PessoaMapper.paraAtualizar(pessoaEntity,pessoa);
        this.pessoaRepository.save(pessoaEntity);

        RecuperarPessoaDto recuperarPessoaDto = PessoaMapper.paraRecuperar(pessoaEntity);
        return new RetornoPadraoDto(MensagemEnum.PESSOA_ATUALIZADA, recuperarPessoaDto);
    }

    @Override
    public RetornoPadraoDto remover(Integer id) {
        if(!this.pessoaExiste(id)){
            throw new ArtefatoNaoEncontradoException(MensagemUtil.getMessage(MensagemEnum.PESSOA_NAO_EXISTE));
        }
        this.pessoaRepository.deleteById(id);
        return new RetornoPadraoDto(MensagemEnum.PESSOA_REMOVIDA);
    }

    private boolean pessoaExiste(Integer id){
        return this.pessoaRepository.existsById(id);
    }

    private void validarCpfExistente(ManterPessoaDto pessoa) {
        if(this.pessoaRepository.existsByCpf(pessoa.getCpf())){
            throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.CPF_JA_EXISTE));
        }
    }
}
