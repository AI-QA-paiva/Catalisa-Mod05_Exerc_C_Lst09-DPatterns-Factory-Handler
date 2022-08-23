package com.bancario.transacaoBanco.model.transacao;

import com.bancario.transacaoBanco.model.ContaBancariaModel;

import java.math.BigDecimal;

public class CalculadoraValorSaque implements CalcularValorNaConta {

    @Override
    public BigDecimal calcular(ContaBancariaModel contaBancariaModel) {
        //BigDecimal saque = contaBancariaModel.getValorFornecido();
        return contaBancariaModel.getValorAtualDaConta().subtract(contaBancariaModel.getValorFornecido());
    }
}
