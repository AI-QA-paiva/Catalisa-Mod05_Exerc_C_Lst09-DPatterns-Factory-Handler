package com.bancario.transacaoBanco.repository;

import com.bancario.transacaoBanco.model.ContaBancariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel, Long> {
}
