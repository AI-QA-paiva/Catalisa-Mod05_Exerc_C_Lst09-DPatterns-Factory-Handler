package com.bancario.transacaoBanco.model.transacao;

import org.springframework.stereotype.Component;

@Component
public class TipoDeEntradaFactory {

    public CalcularValorNaConta calcularValorNaConta(String tipoDeServico){
        if(tipoDeServico.equalsIgnoreCase("deposito")){
            return new CalculadoraValorDeposito();
        }else if(tipoDeServico.equalsIgnoreCase("saque")){
            return new CalculadoraValorSaque();
        }else {
            return null;
        }
    }
}
