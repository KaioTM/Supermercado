package data;

import java.io.Serializable;
import object.Item;
import object.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author KaioT
 */
public class Estoque implements Serializable {
    private List<Item> itens = new ArrayList();

    public void insereProduto(String id,String nome,Float preço,int quantidadeInserida){
        Produto produtoCriado = new Produto(id,nome,preço);
        Item itemCriado = new Item(produtoCriado,quantidadeInserida);
        boolean itemAtualizado = false;
        if (itens.isEmpty()){
            if (itens.add(itemCriado) == true){
               JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
               itemAtualizado = true;
                
            }else{
               JOptionPane.showMessageDialog(null,"Não Foi possível cadastrar o produto"); 
            }        
        }else{
            
            for (int i=0;i<itens.size();i++){           
                if (itens.get(i).getProduto().getIdProduto().equalsIgnoreCase(id)){
                    itemAtualizado = itens.get(i).setQuantidade(itens.get(i).getQuantidade()+quantidadeInserida);
                    JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso");
                    break;          
                }       
            }
            if (itemAtualizado == false){
                itens.add(itemCriado); 
                JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
            }
                        
                     
        }         
            
            
    }
        
    
    // Falta tratar quando o produto não é encontrado
    public String consultaProduto (String idProduto){
        int i;      
            for (i=0;i<itens.size();i++){
                if (itens.get(i).getProduto().getIdProduto().equalsIgnoreCase(idProduto)){            
                    return ("ID: "+itens.get(i).getProduto().getIdProduto()+
                            "\nNome do produto: "+itens.get(i).getProduto().getNomeProduto()+
                            "\nPreço: R$"+itens.get(i).getProduto().getPreço()+
                            "\nQuantidade: "+itens.get(i).getQuantidade());
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
    
    public void retiraProduto(String nomeProduto,int quantidadeSolicitada){
        int i; 
        
        if (itens.isEmpty()){
            JOptionPane.showMessageDialog(null,"O estoque está vazio");
        }else{
            for (i=0;i<itens.size();i++){
                if (itens.get(i).getProduto().getNomeProduto().equalsIgnoreCase(nomeProduto)){
                    if(itens.get(i).getQuantidade() == quantidadeSolicitada){
                       itens.remove(itens.get(i)); 
                    }else{
                        itens.get(i).setQuantidade(itens.get(i).getQuantidade() - quantidadeSolicitada);
                    }
                        
                    JOptionPane.showMessageDialog(null,"Retirado com Sucesso");
                }else{
                    JOptionPane.showMessageDialog(null,"Produto não encontrado");
                }
            }
        }
                    
    }
    
    
  
//    public static String consultaEstoque (){
//        Estoque.estoque.
//    }

    public List<Item> getEstoque() {
        return itens;
    }

    public void setEstoque(List<Item> estoque) {
        this.itens = estoque;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}