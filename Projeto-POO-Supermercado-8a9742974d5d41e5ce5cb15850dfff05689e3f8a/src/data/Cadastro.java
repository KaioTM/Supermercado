/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import object.Usuario;
import object.Gerente;


/**
 *
 * @author kaio.teixeira
 */
public class Cadastro {
    public static Map<String,Usuario> cadastro = new HashMap<String,Usuario>();
    public static Map<String,Gerente> cadastroGerente = new HashMap<String,Gerente>();
     
    public static void insereUsuario(String nome,String username,String senha){
        Usuario cadastroCriado = new Usuario(nome,username,senha);
        cadastro.put(username, cadastroCriado);
        
    }
    
    public static void insereGerente(String nome,String username,String senha){
        Gerente cadastroG = new Gerente(nome,username,senha);
        cadastroGerente.put(username, cadastroG);
        
    }
    
    public static boolean validaUsername(String username) {
      
        return cadastro.containsKey(username);
        
}
    
      public static boolean validaSenha(String username, String senha) {
        Usuario teste;
        teste = cadastro.get(username);
        return teste.getSenha().equals(senha);
         
          
          
      
        
        
      }
      
       public static boolean validaUsernameGerente(String username) {
      
        return cadastroGerente.containsKey(username);
        
}
    
      public static boolean validaSenhaGerente(String username, String senha) {
        Usuario teste;
        teste = cadastroGerente.get(username);
        return teste.getSenha().equals(senha);
         
          
          
      
        
        
      }
}
          


