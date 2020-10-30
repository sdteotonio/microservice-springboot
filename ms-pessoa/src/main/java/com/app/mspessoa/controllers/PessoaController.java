package com.app.mspessoa.controllers;

import com.app.mspessoa.domain.dto.ListarPessoaDto;
import com.app.mspessoa.domain.dto.ManterPessoaDto;
import com.app.mspessoa.domain.dto.RecuperarPessoaDto;
import com.app.mspessoa.domain.dto.RetornoPadraoDto;
import com.app.mspessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping()
    ResponseEntity<List<ListarPessoaDto>> listar(){
        return ResponseEntity.ok(this.pessoaService.listar());
    }

    @PostMapping()
    ResponseEntity<RetornoPadraoDto> adicionar(@Valid @RequestBody ManterPessoaDto pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pessoaService.adicionar(pessoa));
    }

    @PutMapping("{id}")
    ResponseEntity<RetornoPadraoDto> atualizar(@PathVariable  Integer id,@Valid @RequestBody ManterPessoaDto pessoa){
        return ResponseEntity.ok(this.pessoaService.atualizar(id,pessoa));
    }

    @GetMapping("{id}")
    ResponseEntity<RecuperarPessoaDto> recuperar(@PathVariable  Integer id){
        return ResponseEntity.ok(this.pessoaService.recuperar(id));
    }

    @DeleteMapping("{id}")
    ResponseEntity<RetornoPadraoDto> remover(@PathVariable Integer id){
        return ResponseEntity.ok(this.pessoaService.remover(id));
    }

}
