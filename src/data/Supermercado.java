/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kaio.teixeira
 */
public class Supermercado implements Serializable {
    private Estoque estoque;
    private Cadastro cadastro;

//Singleton
    private static Supermercado instancia = null;
    public static synchronized Supermercado getInstancia(){
        if (instancia == null){
            instancia = new Supermercado();
        }
        return instancia;
    }
    private Supermercado(){
        estoque = new Estoque();
        cadastro = new Cadastro();
    }
    //Singleton

    public Estoque getEstoque() {
        return estoque;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }
    
     public void carregaSupermercado(){
        
        try
      {
         FileInputStream fileIn = new FileInputStream("C:\\Users\\kaio.teixeira\\Documents\\GitHub\\Supermercado\\dados\\dados\\supermercado.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         estoque = (Estoque) in.readObject();
         cadastro = (Cadastro) in.readObject();
         in.close();
         fileIn.close();
         System.out.println("Sistema Carregado");
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("not found");
         c.printStackTrace();
         return;
      }

    }
     
     public void salvaSupermercado (){
            
        try{
                 FileOutputStream fileOut = new FileOutputStream("C:\\Users\\kaio.teixeira\\Documents\\GitHub\\Supermercado\\dados\\dados\\supermercado.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut);  
                 out.writeObject(estoque);
                 out.writeObject(cadastro);
                 out.close();
                 fileOut.close();
                 System.out.printf("Serialized data is saved in C:\\Users\\kaio.teixeira\\Documents\\GitHub\\Supermercado\\dados\\dados\\supermercado.ser");
               }catch(IOException i){
                  i.printStackTrace();
                }
    }
    
    
    
}
