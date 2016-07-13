/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author visitante
 */
public class Gerente extends Usuario{


    public  Gerente(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }

    /**
     *
     * @return
     */
    public boolean acessoGerente(){
        return true;
          
    }
}
