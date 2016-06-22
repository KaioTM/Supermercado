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
import java.util.ArrayList;

/**
 *
 * @author KaioT
 */
public class Programa {
     
    public static void salvaPrograma (){
            
        try{
                 FileOutputStream fileOut = new FileOutputStream("C:\\Users\\KaioT\\Desktop\\dados\\estoque.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut);
                 out.writeObject(Estoque.estoque);
                 out.close();
                 fileOut.close();
                 System.out.printf("Serialized data is saved in C:\\Users\\KaioT\\Desktop\\dados\\estoque.ser");
               }catch(IOException i){
                  i.printStackTrace();
                }
    }
    
    public static void carregaPrograma (){
      Estoque.carregaEstoque();

    }
}
