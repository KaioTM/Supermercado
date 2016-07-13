/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import model.RealizarPagamento;

/**
 *
 * @author kaio.teixeira
 */
public class PagamentoDinheiro implements RealizarPagamento {
    private float pagamentoPendente = 0;
    private float troco = 0;
    
    @Override
    public boolean Pagamento(float valorPendente, float valorRecebido) {
        boolean pagamentoEfetuado = false;
        if (valorRecebido>= valorPendente){
            Troco(valorPendente,valorRecebido);
            pagamentoEfetuado = true;
        }else{
            this.setPagamentoPendente(valorPendente-valorRecebido);
        }
        return pagamentoEfetuado;
    }

    @Override
    public void Troco(float valorPendente, float valorRecebido) {
        float trocoTotal = valorRecebido - valorPendente;
        int moedas1 = (int)trocoTotal / 1;
        int moedas100 = moedas1 / 100;
        int moedas50 = moedas1 / 50;
        int moedas25 = moedas1 / 25;
        int moedas10 = moedas1 / 10;
        int moedas5 = moedas1 / 5;
        this.setTroco(trocoTotal);
//        
//        moedas1 -= 100 * moedas100;
//        moedas1 -= 50 * moedas50;
//        moedas1 -= 25 * moedas25;
//        moedas1 -= 10 * moedas10;
//        moedas1 -= 5 * moedas5;
//        
//        System.out.println("Moedas de 1 real: " + moedas100);
//        System.out.println("Moedas de 50 centavos: " + moedas50);
//        System.out.println("Moedas de 25 centavos: " + moedas25);
//        System.out.println("Moedas de 10 centavos: " + moedas10);
//        System.out.println("Moedas de 5 centavos: " + moedas5);
//        System.out.println("Moedas de 1 centavo: " + moedas1); 
    }

    public float getPagamentoPendente() {
        return pagamentoPendente;
    }

    public void setPagamentoPendente(float pagamentoPendente) {
        this.pagamentoPendente = pagamentoPendente;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }
    
}
