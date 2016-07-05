/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author kaio.teixeira
 */
public class Usuario {
    private String nome;
    private String username;
    private String senha;

    
// contrutor
    public Usuario(String nome, String usuario, String senha){
       this.nome = nome;
       this.username = usuario;
       this.senha = senha;     
    }
     
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean acessaEstoque (){
        
        return false;
          
    }

}
