/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import model.Usuario;
import model.Gerente;


/**
 *
 * @author kaio.teixeira
 */
public class Cadastro implements Serializable {
    public Map<String,Usuario> cadastro = new HashMap<String,Usuario>();
    //public static Map<String,Gerente> cadastroGerente = new HashMap<String,Gerente>();
    private static Usuario usuarioLogado;
    
    public void insereUsuario(String nome,String username,String senha){
        Usuario cadastroCriado = new Usuario(nome,username,senha);
        Supermercado.getInstancia().getCadastro().cadastro.put(username, cadastroCriado);
        
    }
    
    public void insereGerente(String nome,String username,String senha){
        Gerente cadastroG = new Gerente(nome,username,senha);
        Supermercado.getInstancia().getCadastro().cadastro.put(username, cadastroG);
        
    }
    
    public static boolean validaUsername(String username) {
      
        return Supermercado.getInstancia().getCadastro().cadastro.containsKey(username);
        
}
      public static boolean validaSenha(String username, String senha) {
        Usuario usuario = Supermercado.getInstancia().getCadastro().cadastro.get(username);
        if (usuario.getSenha().equals(senha)){
            usuarioLogado = usuario;
            return true;
        }
        return false;
      }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

}
          


