package com.bancario.transacaoBanco.service;

import com.bancario.transacaoBanco.model.ContaBancariaModel;
import com.bancario.transacaoBanco.model.transacao.CalcularValorNaConta;
import com.bancario.transacaoBanco.model.transacao.TipoDeEntradaFactory;
import com.bancario.transacaoBanco.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private TipoDeEntradaFactory tipoDeEntradaFactory;

    public List<ContaBancariaModel> exibirTodasAsContas(){
        return contaBancariaRepository.findAll();
    }

    public Optional<ContaBancariaModel> exibirContaEspecifica(Long id){
        return contaBancariaRepository.findById(id);
    }

    public ContaBancariaModel cadastrarNovaConta(ContaBancariaModel contaBancariaModel, TipoDeEntradaFactory tipoDeEntradaFactory){
        contaBancariaModel.getAgencia();
        contaBancariaModel.getNumeroConta();
        contaBancariaModel.getNomeDoUsuario();
        contaBancariaModel.getTipoDeServico();
        contaBancariaModel.getValorAtualDaConta();
        contaBancariaModel.getValorFornecido();
        contaBancariaModel.setValorFinal(tipoDeEntradaFactory.calcularValorNaConta(contaBancariaModel.getTipoDeServico()).calcular(contaBancariaModel));

        return contaBancariaRepository.save(contaBancariaModel);
    }

    public void delecaoDeUmaConta (Long id){
        contaBancariaRepository.deleteById(id);
    }

    public ContaBancariaModel movimentacaoBancaria(ContaBancariaModel contaBancariaModel) {
        CalcularValorNaConta calcularValorNaConta = tipoDeEntradaFactory.calcularValorNaConta(contaBancariaModel.getTipoDeServico());
        contaBancariaModel.setValorAtualDaConta(calcularValorNaConta.calcular(contaBancariaModel));
        return contaBancariaRepository.save(contaBancariaModel);
    }
//
////        BigDecimal calculoMoney = tipoDeEntradaFactory.calcularValorNaConta(contaBancariaModel.getTipoDeServico()).calcular(contaBancariaModel);
////        //contaBancariaModel.setValorAtualDaConta(calcularValorNaConta.calcular(contaBancariaModel));
////        return contaBancariaRepository.save(contaBancariaModel);
//    }
}
