package com.bancario.transacaoBanco.controller;

import com.bancario.transacaoBanco.model.ContaBancariaModel;
import com.bancario.transacaoBanco.model.transacao.TipoDeEntradaFactory;
import com.bancario.transacaoBanco.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping (path = "/conta")
    public List<ContaBancariaModel> exibirTodasAsContas(){
        return contaBancariaService.exibirTodasAsContas();
    }

    @GetMapping (path = "/conta/{id}")
    public Optional<ContaBancariaModel> exibirContaBancariaEspecifica (@PathVariable Long id){
        return contaBancariaService.exibirContaEspecifica(id);
    }

    @PostMapping (path = "/conta")
    public ContaBancariaModel cadastrarContaBancaria(@RequestBody ContaBancariaModel contaBancariaModel, TipoDeEntradaFactory tipoDeEntradaFactory){
        return contaBancariaService.cadastrarNovaConta(contaBancariaModel, tipoDeEntradaFactory);
    }

    @DeleteMapping (path = "/conta/{id}")
    public void deletarContaBancaria(@PathVariable Long id){
        contaBancariaService.delecaoDeUmaConta(id);
    }

}
