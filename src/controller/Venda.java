/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author lfigueiredo
 */
public class Venda {

    private int idVenda;
    private String data;
    private ArrayList<Item> itensVenda;
    private Usuario caixa;

    //Construtor
    public Venda(int idVenda, String data, Usuario caixa) {
        this.idVenda = idVenda;
        this.data = data;
        itensVenda = new ArrayList<>();
        this.caixa = caixa;
    }

//Getters e Setters
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int IdVenda) {
        idVenda = IdVenda;
    }

    public Venda() {
        this.itensVenda = new ArrayList<>();

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Item> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<Item> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Usuario getCaixa() {
        return caixa;
    }

    public void setCaixa(Usuario caixa) {
        this.caixa = caixa;
    }
    //Getters e Setters

    public boolean registraItem(String id, int quantidadeSolicitada) {
        boolean vendaRegistrada = false;
        Produto produtoSolicitado = Supermercado.getInstancia().getEstoque().getItens().get(id).getProduto();
        Item itemSolicitado = new Item(produtoSolicitado, quantidadeSolicitada);

        if (Supermercado.getInstancia().getEstoque().getItens().containsKey(id)) {
            if (Supermercado.getInstancia().getEstoque().getItens().get(id).getQuantidade() < quantidadeSolicitada) {
                JOptionPane.showMessageDialog(null, "Quantidade não disponível");
            } else if (Supermercado.getInstancia().getEstoque().getItens().get(id).getQuantidade() == quantidadeSolicitada) {
                this.itensVenda.add(itemSolicitado);
                Supermercado.getInstancia().getEstoque().retiraProduto(id, quantidadeSolicitada);
                vendaRegistrada = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
        return vendaRegistrada;
    }

    public boolean removeItem(String id, int quantidadeSolicitada) {
        boolean itemRemovido = false;
        Produto produtoSolicitado = this.itensVenda.get(idVenda).getProduto();
        Item itemSolicitado = new Item(produtoSolicitado, quantidadeSolicitada);

        if (Supermercado.getInstancia().getEstoque().getItens().containsKey(id)) {
            if (Supermercado.getInstancia().getEstoque().getItens().get(id).getQuantidade() < quantidadeSolicitada) {
                JOptionPane.showMessageDialog(null, "Quantidade não disponível");
            } else if (Supermercado.getInstancia().getEstoque().getItens().get(id).getQuantidade() == quantidadeSolicitada) {
                this.itensVenda.add(itemSolicitado);
                Supermercado.getInstancia().getEstoque().retiraProduto(id, quantidadeSolicitada);
                itemRemovido = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }

        return itemRemovido;
    }

    public float calculaValorTotal() {
        float calculoTotal = 0;

        for (int i = 0; i < this.getItensVenda().size(); i++) {
            float valorTotalItem = (this.getItensVenda().get(i).getQuantidade() * this.getItensVenda().get(i).getProduto().getPreco());
            calculoTotal += valorTotalItem;
        }
        return calculoTotal;
    }

}
