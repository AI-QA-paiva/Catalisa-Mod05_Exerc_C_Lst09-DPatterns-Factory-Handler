package com.bancario.transacaoBanco.model.transacao;

import com.bancario.transacaoBanco.model.ContaBancariaModel;

import java.math.BigDecimal;

public interface CalcularValorNaConta {
    BigDecimal calcular(ContaBancariaModel contaBancariaModel);
}
