package com.bancario.transacaoBanco.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "conta")

public class ContaBancariaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(length = 10, nullable = false)
    private String agencia;

    @Column(length = 30, nullable = false)
    private String numeroConta;

    @Column(length = 50, nullable = false)
    private String nomeDoUsuario;

    @Column(length = 10)
    private String tipoDeServico;

    @Column(length = 10)
    private BigDecimal valorAtualDaConta;

    @Column(length = 10)
    private BigDecimal valorFornecido;

    @Column(length = 10)
    private BigDecimal valorFinal;

}
