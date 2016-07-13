/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.RealizarPagamento;

/**
 *
 * @author kaio.teixeira
 */
public class PagamentoCartao implements RealizarPagamento{
    private float pagamentoPendente;
    
    @Override
    public boolean Pagamento(float valorPendente, float valorRecebido) {
        boolean pagamentoEfetuado = false;
        if (valorPendente > valorRecebido){
            this.setPagamentoPendente(valorPendente);
        }else{
            if (ValidaCartao()){
                pagamentoEfetuado = true;
                this.setPagamentoPendente(valorPendente-valorRecebido);
            }else{
               this.setPagamentoPendente(valorPendente-valorRecebido); 
            }  
        }
        return pagamentoEfetuado;
        
    }
    //Implementar Variável aleatória para criar a impressão que o cartão não foi aprovado
    private boolean ValidaCartao (){
        boolean cartaoValido = true;
        
        
        return cartaoValido;
    }
    
    //Cartão não implementa Troco
    public void Troco(float valorPendente, float valorRecebido) {
    }

    public float getPagamentoPendente() {
        return pagamentoPendente;
    }

    public void setPagamentoPendente(float pagamentoPendente) {
        this.pagamentoPendente = pagamentoPendente;
    }
}
