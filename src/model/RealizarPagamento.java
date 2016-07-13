/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kaio.teixeira
 */
public interface RealizarPagamento {
    abstract public boolean Pagamento(float valorPendente,float valorRecebido);
    abstract public void Troco(float valorPendente,float valorRecebido);
   
  
}
