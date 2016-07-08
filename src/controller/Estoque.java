package controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import model.Item;
import model.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author KaioT
 */
public class Estoque implements Serializable {
    private Map<String,Item> itens = new HashMap<String, Item>();

    
    public static Object getKeyFromValue(Map hm, Object value) {
    for (Object o : hm.keySet()) {
      if (hm.get(o).equals(value)) {
        return o;
      }
    }
    return null;
  }
    //Método Responsável por inserir um produto no estoque
    public void insereProduto(String id,String nome,Float preço,int quantidadeInserida){
        Produto produtoCriado = new Produto(id,nome,preço);
        Item itemCriado = new Item(produtoCriado,quantidadeInserida);

        if (itens.isEmpty()){
               itens.put(id, itemCriado);
               JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
//               itemAtualizado = true;    
        }else{ 
                if (itens.containsKey(id)){
                    JOptionPane.showMessageDialog(null,"ID de produto já cadastrado");
                }else{
                    itens.put(id, itemCriado);
                    JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
//                    itens.get(id).setQuantidade(itens.get(id).getQuantidade()+quantidadeInserida);
//                    JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso");
                }
            }
//            if (itemAtualizado == false){
//                itens.put(id, itemCriado); 
//                JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
//            }
                        
                     
        }         
    //
            public void alteraProduto(String IdProduto,String Nome){
                
                
            }
            public void alteraProduto(String IdProduto,Float Preco){
                
            }
            public void alteraProduto(String IdProduto,int Quantidade){
                
            }
    
    //Método Responsável por formatar o campo Preço
        public String formatarFloat(float numero){
            String retorno = "";
            DecimalFormat formatter = new DecimalFormat("#.00");
            try{
              retorno = formatter.format(numero);
            }catch(Exception ex){
              System.err.println("Erro ao formatar numero: " + ex);
            }
            return retorno;
        }
    

    public String consultaProduto (String idProduto){ 
            if (itens.containsKey(idProduto)){
                return ("ID: "+itens.get(idProduto).getProduto().getIdProduto()+
                        "\nNome do produto: "+itens.get(idProduto).getProduto().getNomeProduto()+
                        "\nPreço (Unidade): R$"+formatarFloat(itens.get(idProduto).getProduto().getPreço())+
                        "\nQuantidade: "+itens.get(idProduto).getQuantidade());
            }
            return ("Produto não encontrado.");
    }
    
//    public void retiraProduto(String nomeProduto,int quantidadeSolicitada){
//        int i; 
//        int idProduto =
//        if (itens.isEmpty()){
//            JOptionPane.showMessageDialog(null,"O estoque está vazio");
//        }else{
//                if (itens.containsValue(nomeProduto)){
//                    if(itens.get(i).getQuantidade() == quantidadeSolicitada){
//                       itens.remove(itens.get(i)); 
//                    }else{
//                        itens.get(i).setQuantidade(itens.get(i).getQuantidade() - quantidadeSolicitada);
//                    }
//                        
//                    JOptionPane.showMessageDialog(null,"Retirado com Sucesso");
//                }else{
//                    JOptionPane.showMessageDialog(null,"Produto não encontrado");
//                }
//            }       
//    }
    public void listaTodosItens(JTextArea displayArea){
        displayArea.setText("");
        for ( String key : itens.keySet() ) {
            displayArea.append("ID: "+itens.get(key).getProduto().getIdProduto()+
                        "\nNome do produto: "+itens.get(key).getProduto().getNomeProduto()+
                        "\nPreço (Unidade): R$"+itens.get(key).getProduto().getPreço()+
                        "\nQuantidade: "+itens.get(key).getQuantidade()+
                    "\n_______________\n\n");
                //System.out.println( key );
}{
                
            }
        }

    public Map<String,Item> getItens() {
        return itens;
    }

    public void setItens(Map<String,Item> itens) {
        this.itens = itens;
    }
}