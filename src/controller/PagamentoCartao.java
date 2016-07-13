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
    
    public boolean Pagamento(float valorPendente, float valorRecebido) {
        boolean pagamentoEfetuado = false;
        if (valorPendente > valorRecebido){
            this.setPagamentoPendente(valorPendente);
        }else{
            if (ValidaCartao()){
                pagamentoEfetuado = true;
                this.setPagamentoPendente(valorPendente-valorRecebido);
            }  
        }
        return pagamentoEfetuado;
        
    }
    private boolean ValidaCartao (){
        boolean cartaoValido = false;
        
        
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
