/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kaio.teixeira
 */
public class MudancaEstoque {

    public MudancaEstoque(String idMudanca, String data, Item itemAntigo, Item itemAtualizado, Usuario Responsavel,String observacao) {
        this.idMudanca = idMudanca;
        this.data = data;
        this.itemAntigo = itemAntigo;
        this.itemAtualizado = itemAtualizado;
        this.Responsavel = Responsavel;
        this.observacao = observacao;
    }
    
    public MudancaEstoque(String idMudanca, String data, Item itemAntigo, Usuario Responsavel,String observacao) {
        this.idMudanca = idMudanca;
        this.data = data;
        this.itemAntigo = itemAntigo;
        this.Responsavel = Responsavel;
        this.observacao = observacao;
    }
    private String idMudanca;
    private String data;
    private Item itemAntigo;
    private Item itemAtualizado;
    private Usuario Responsavel;
    private String observacao;
    
    
    public String getIdMudanca() {
        return idMudanca;
    }

    public void setIdMudanca(String idMudanca) {
        this.idMudanca = idMudanca;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Item getItemAntigo() {
        return itemAntigo;
    }

    public void setItemAntigo(Item itemAntigo) {
        this.itemAntigo = itemAntigo;
    }

    public Item getItemAtualizado() {
        return itemAtualizado;
    }

    public void setItemAtualizado(Item itemAtualizado) {
        this.itemAtualizado = itemAtualizado;
    }

    public Usuario getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(Usuario Responsavel) {
        this.Responsavel = Responsavel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
