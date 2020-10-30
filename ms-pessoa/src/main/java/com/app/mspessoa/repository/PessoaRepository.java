package com.app.mspessoa.repository;

import com.app.mspessoa.domain.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    public boolean existsByCpf(String cpf);
}
