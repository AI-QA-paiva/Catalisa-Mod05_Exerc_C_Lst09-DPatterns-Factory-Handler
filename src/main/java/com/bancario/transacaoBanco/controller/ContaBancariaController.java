package com.bancario.transacaoBanco.controller;

import com.bancario.transacaoBanco.model.ContaBancariaModel;
import com.bancario.transacaoBanco.model.transacao.TipoDeEntradaFactory;
import com.bancario.transacaoBanco.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping (path = "/conta")
    public ResponseEntity<List<ContaBancariaModel>> exibirTodasAsContas(){
        List<ContaBancariaModel> listaContas = contaBancariaService.exibirTodasAsContas();
        return ResponseEntity.ok(listaContas); //contaBancariaService.exibirTodasAsContas();
    }

    @GetMapping (path = "/conta/{id}")
    public ResponseEntity<Optional<ContaBancariaModel>> exibirContaBancariaEspecifica (@PathVariable Long id){
        return ResponseEntity.ok(contaBancariaService.exibirContaEspecifica(id));
    }

    @PostMapping (path = "/conta")
    public ResponseEntity<ContaBancariaModel> cadastrarContaBancaria(@RequestBody ContaBancariaModel contaBancariaModel, TipoDeEntradaFactory tipoDeEntradaFactory){
        ContaBancariaModel contas = contaBancariaService.cadastrarNovaConta(contaBancariaModel, tipoDeEntradaFactory);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/conta/{id}")
    public void deletarContaBancaria(@PathVariable Long id){
        contaBancariaService.delecaoDeUmaConta(id);
    }

}
