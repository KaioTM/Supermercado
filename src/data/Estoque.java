package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import object.Item;
import object.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KaioT
 */
public class Estoque {
    //String localEstoque = "/dados/dados/estoque.ser";
    public static ArrayList<Item> estoque = new ArrayList();
    
    public static void insereProduto(String id,String nome,Float preço,int quantidadeInserida){
        Produto produtoCriado = new Produto(id,nome,preço);
        Item itemCriado = new Item(produtoCriado,quantidadeInserida);
        boolean itemAtualizado = false;
        if (estoque.isEmpty()){
            if (estoque.add(itemCriado) == true){
               JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
               itemAtualizado = true;
                
            }else{
               JOptionPane.showMessageDialog(null,"Não Foi possível cadastrar o produto"); 
            }        
        }else{
            
            for (int i=0;i<estoque.size();i++){           
                if (estoque.get(i).getProduto().getIdProduto().equalsIgnoreCase(id)){
                    itemAtualizado = estoque.get(i).setQuantidade(estoque.get(i).getQuantidade()+quantidadeInserida);
                    JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso");
                    break;          
                }       
            }
            if (itemAtualizado == false){
                estoque.add(itemCriado); 
                JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
            }
                        
                     
        }         
            
            
    }
        
    
    // Falta tratar quando o produto não é encontrado
    public static String consultaProduto (String idProduto){
        int i;      
            for (i=0;i<Estoque.estoque.size();i++){
                if (estoque.get(i).getProduto().getIdProduto().equalsIgnoreCase(idProduto)){            
                    return ("ID: "+estoque.get(i).getProduto().getIdProduto()+
                            "\nNome do produto: "+estoque.get(i).getProduto().getNomeProduto()+
                            "\nPreço: R$"+estoque.get(i).getProduto().getPreço()+
                            "\nQuantidade: "+estoque.get(i).getQuantidade());
//                    System.out.print("ID: "+estoque.get(i).getProduto().getIdProduto()+
//                            "\nNome do produto: "+estoque.get(i).getProduto().getNomeProduto()+
//                            "\nPreço: R$"+estoque.get(i).getProduto().getPreço()+
//                            "\nQuantidade: "+estoque.get(i).getQuantidade());
                    //System.out.println(estoque.get(i).getProduto().getIdProduto());
                    //System.out.print("Nome do produto: ");
                    //System.out.println(estoque.get(i).getProduto().getNomeProduto());
                    //System.out.print("Preço: R$");
                    //System.out.println(estoque.get(i).getProduto().getPreço());
                    //System.out.print("Quantidade: ");
                    //System.out.println(estoque.get(i).getQuantidade());
                    
                }else{   
                }
            }
            return ("Produto não encontrado.");
    }
    
    public static void retiraProduto(String nomeProduto,int quantidadeSolicitada){
        int i; 
        
        if (estoque.isEmpty()){
            JOptionPane.showMessageDialog(null,"O estoque está vazio");
        }else{
            for (i=0;i<Estoque.estoque.size();i++){
                if (estoque.get(i).getProduto().getNomeProduto().equalsIgnoreCase(nomeProduto)){
                    if(estoque.get(i).getQuantidade() == quantidadeSolicitada){
                       estoque.remove(estoque.get(i)); 
                    }else{
                        estoque.get(i).setQuantidade(estoque.get(i).getQuantidade() - quantidadeSolicitada);
                    }
                        
                    JOptionPane.showMessageDialog(null,"Retirado com Sucesso");
                }else{
                    JOptionPane.showMessageDialog(null,"Produto não encontrado");
                }
            }
        }
                    
    }
    
     public static void carregaEstoque(){
        
        try
      {
         FileInputStream fileIn = new FileInputStream("C:\\Users\\KaioT\\Documents\\GitHub\\Supermercado\\dados\\dados\\estoque.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         Estoque.estoque = (ArrayList) in.readObject();
         in.close();
         fileIn.close();
         System.out.println("Estoque Carregado");
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("ArrayList not found");
         c.printStackTrace();
         return;
      }

    }
     
     public static void salvaEstoque (){
            
        try{
                 FileOutputStream fileOut = new FileOutputStream("C:\\Users\\KaioT\\Documents\\GitHub\\Supermercado\\dados\\dados\\estoque.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut);  
                 out.writeObject(Estoque.estoque);
                 out.close();
                 fileOut.close();
                 System.out.printf("Serialized data is saved in C:\\Users\\KaioT\\Documents\\GitHub\\Supermercado\\dados\\dados\\estoque.ser");
               }catch(IOException i){
                  i.printStackTrace();
                }
    }
  
//    public static String consultaEstoque (){
//        Estoque.estoque.
//    }
}