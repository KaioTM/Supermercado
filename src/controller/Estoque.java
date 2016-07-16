package controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import model.Item;
import model.Produto;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import model.MudancaEstoque;

/**
 *
 * @author KaioT
 */
public class Estoque implements Serializable {

    private Map<String, Item> itens = new HashMap<>();

    //Getters e Setters
    public Map<String, Item> getItens() {
        return itens;
    }

    public void setItens(Map<String, Item> itens) {
        this.itens = itens;
    }
    //Getters e Setters

//    public static Object getKeyFromValue(Map hm, Object value) {
//        for (Object o : hm.keySet()) {
//          if (hm.get(o).equals(value)) {
//            return o;
//          }
//    }
//    return null;
//  }
    //Método Responsável por inserir um produto no estoque
    public void insereProduto(String id, String nome, Float preço, int quantidadeInserida) {
        Produto produtoCriado = new Produto(id, nome, preço);
        Item itemCriado = new Item(produtoCriado, quantidadeInserida);

        if (itens.isEmpty()) {
            itens.put(id, itemCriado);
            identificaInclusaoDoItem(itemCriado, "Item incluído no estoque");
            JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso");
//               itemAtualizado = true;    
        } else if (itens.containsKey(id)) {
            JOptionPane.showMessageDialog(null, "ID de produto já cadastrado");
        } else {
            itens.put(id, itemCriado);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso");
//                    itens.get(id).setQuantidade(itens.get(id).getQuantidade()+quantidadeInserida);
//                    JOptionPane.showMessageDialog(null,"Produto atualizado com sucesso");
        }
//            if (itemAtualizado == false){
//                itens.put(id, itemCriado); 
//                JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso");
//            }

    }

    public void alteraProduto(String IdProduto, String nome) {

    }
    
    public void alteraProduto(String IdProduto, Float preco) {

    }

    public void alteraProduto(String IdProduto, int Quantidade) {
        int itematual = itens.get(IdProduto).getQuantidade();
        itens.get(IdProduto).setQuantidade(itematual + Quantidade);
    }

 

    //Método Responsável por formatar o campo Preço
    public String formatarFloat(float numero) {
        String retorno = "";
        DecimalFormat formatter = new DecimalFormat("#.00");
        try {
            retorno = formatter.format(numero);
        } catch (Exception ex) {
            System.err.println("Erro ao formatar numero: " + ex);
        }
        return retorno;
    }

    //Método responsável por consultar um produto pelo ID    
    public String consultaProduto(String idProduto) {
        if (itens.containsKey(idProduto)) {
            return ("ID: " + itens.get(idProduto).getProduto().getIdProduto()
                    + "\nNome do produto: " + itens.get(idProduto).getProduto().getNomeProduto()
                    + "\nPreço (Unidade): R$" + formatarFloat(itens.get(idProduto).getProduto().getPreco())
                    + "\nQt.Disponível: " + itens.get(idProduto).getQuantidade());
        }
        return ("Produto não encontrado.");
    }
    
    public String consultaProdutonNoLeitor(String idProduto) {
        if (itens.containsKey(idProduto)) {
            return ("ID: " + itens.get(idProduto).getProduto().getIdProduto()
                    + "\nNome do produto: " + itens.get(idProduto).getProduto().getNomeProduto()
                    + "\nPreço (Unidade): R$" + formatarFloat(itens.get(idProduto).getProduto().getPreco()));
        }
        return ("Produto não encontrado.");
    }
    
       // Método responsável por listar todos os itens disponíveis no Estoque no momento
    public void listaTodosItens(JTextArea displayArea) {
        displayArea.setText("");
        for (String key : itens.keySet()) {
            displayArea.append("ID: " + itens.get(key).getProduto().getIdProduto()
                    + "\nNome do produto: " + itens.get(key).getProduto().getNomeProduto()
                    + "\nPreço (Unidade): R$" + formatarFloat(itens.get(key).getProduto().getPreco())
                    + "\nQt.Disponível: " + itens.get(key).getQuantidade()
                    + "\n_______________\n\n");
        }
    }

    //Método responsável por retirar um produto pelo ID
    public void retiraProduto(String id, int quantidadeSolicitada) {
        if (itens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O estoque está vazio");
        } else if (itens.containsKey(id)) {
            if (itens.get(id).getQuantidade() == quantidadeSolicitada) {
                identificaRemocaoDoItem(Supermercado.getInstancia().getEstoque().getItens().get(id), "Produto deletado do estoque");
                itens.remove(id);
                JOptionPane.showMessageDialog(null, "Produto removido do Estoque");
            } else if (quantidadeSolicitada < itens.get(id).getQuantidade()) {
                Item itemOriginal = new Item();
                itemOriginal = itens.get(id);
                itens.get(id).setQuantidade(itens.get(id).getQuantidade() - quantidadeSolicitada);
                identificaMudancaNoItem(itemOriginal, itens.get(id), "Item modificado");
//                JOptionPane.showMessageDialog(null, "Quantidade retirada com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade Inválida!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }

 

    public void identificaMudancaNoItem(Item itemAntigo, Item itemAtualizado, String observacao) {
        AtomicInteger idMudanca = new AtomicInteger(0);
        boolean mudancaRegistrada = false;
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());

        do {
            if (Supermercado.getInstancia().getRelatorios().getMudancaEstoque().containsKey(String.valueOf(idMudanca))) {
                idMudanca.incrementAndGet();
            } else {
                MudancaEstoque mudanca = new MudancaEstoque(String.valueOf(idMudanca), timeStamp, itemAntigo, itemAtualizado, Supermercado.getInstancia().getCadastro().getUsuarioLogado(), observacao);
                Supermercado.getInstancia().getRelatorios().getMudancaEstoque().put(String.valueOf(idMudanca), mudanca);
                mudancaRegistrada = true;
            }
        } while (mudancaRegistrada != true);

    }

    public void identificaRemocaoDoItem(Item itemAntigo, String observacao) {
        AtomicInteger idMudanca = new AtomicInteger(0);
        boolean mudancaRegistrada = false;
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());

        do {
            if (Supermercado.getInstancia().getRelatorios().getMudancaEstoque().containsKey(String.valueOf(idMudanca))) {
                idMudanca.incrementAndGet();
            } else {
                MudancaEstoque exclusao = new MudancaEstoque(String.valueOf(idMudanca), timeStamp, itemAntigo, null, Supermercado.getInstancia().getCadastro().getUsuarioLogado(), observacao);
                Supermercado.getInstancia().getRelatorios().getMudancaEstoque().put(String.valueOf(idMudanca), exclusao);
                mudancaRegistrada = true;
            }
        } while (mudancaRegistrada != true);

    }

    public void identificaInclusaoDoItem(Item itemIncluido, String observacao) {
        AtomicInteger idMudanca = new AtomicInteger(0);
        boolean mudancaRegistrada = false;
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());

        do {
            if (Supermercado.getInstancia().getRelatorios().getMudancaEstoque().containsKey(String.valueOf(idMudanca))) {
                idMudanca.incrementAndGet();
            } else {
                MudancaEstoque inclusao = new MudancaEstoque(String.valueOf(idMudanca), timeStamp, null, itemIncluido, Supermercado.getInstancia().getCadastro().getUsuarioLogado(), observacao);
                Supermercado.getInstancia().getRelatorios().getMudancaEstoque().put(String.valueOf(idMudanca), inclusao);
                mudancaRegistrada = true;
            }
        } while (mudancaRegistrada != true);

    }

}
