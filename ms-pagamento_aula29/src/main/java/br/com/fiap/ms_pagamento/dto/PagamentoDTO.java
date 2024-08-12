package br.com.fiap.ms_pagamento.dto;


import br.com.fiap.ms_pagamento.model.Pagamento;
import br.com.fiap.ms_pagamento.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoDTO {


    private Long id;
    @NotNull(message = "Campo Obrigatorio")
    @Positive(message = "Ete campo deve ser positivo")
    private BigDecimal valor;
    @Size(max=100,message ="Maximo de 100 caracteres")
    private String nome; // ome no cartão
    @Size(max=19,message ="Maximo de 19 caracteres")
    private String numeroDoCartao; // XXXX XXXX XXXX XXXX
    @Size(max=5, min = 5,message ="Maximo de 19 caracteres")
    private String validade; // validade do cartão - MM/AA
    @Size(max=3, min = 3,message ="Maximo de 19 caracteres")
    private String codigoDeSeguranca; // código de segurança - XXX
    @Enumerated(value = EnumType.STRING)
    private Status status;  // Status do pagamento
    @NotNull(message = "Campo Obrigatorio")
    private Long pedidoId;  // Id do pedido
    @NotNull(message = "Campo Obrigatorio")
    private Long formaDePagamentoId;


    public PagamentoDTO(Pagamento entity){
        id = entity.getId();
        valor = entity.getValor();
        nome = entity.getNome();
        numeroDoCartao = entity.getNumeroDoCartao();
        validade = entity.getValidade();
        codigoDeSeguranca = entity.getCodigoDeSeguranca();
        status = entity.getStatus();
        pedidoId = entity.getPedidoId();
        formaDePagamentoId = entity.getFormaDePagamentoId();

    }



}
