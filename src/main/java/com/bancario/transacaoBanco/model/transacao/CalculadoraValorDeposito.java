package com.bancario.transacaoBanco.model.transacao;

import com.bancario.transacaoBanco.model.ContaBancariaModel;

import java.math.BigDecimal;

public class CalculadoraValorDeposito implements CalcularValorNaConta{
    @Override
    public BigDecimal calcular(ContaBancariaModel contaBancariaModel) {
       // BigDecimal deposito = contaBancariaModel.getValorFornecido();
        return contaBancariaModel.getValorAtualDaConta().add(contaBancariaModel.getValorFornecido());
    }
}
