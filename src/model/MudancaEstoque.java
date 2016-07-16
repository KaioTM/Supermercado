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

    public MudancaEstoque(String idMudanca, String data, Item itemAntigo, Item itemAtualizado, Usuario responsavel,String observacao) {
        this.idMudanca = idMudanca;
        this.data = data;
        this.itemAntigo = itemAntigo;
        this.itemAtualizado = itemAtualizado;
        this.responsavel = responsavel;
        this.observacao = observacao;
    }
    
    public MudancaEstoque(String idMudanca, String data, Item itemAntigo, Usuario responsavel,String observacao) {
        this.idMudanca = idMudanca;
        this.data = data;
        this.itemAntigo = itemAntigo;
        this.responsavel = responsavel;
        this.observacao = observacao;
    }
    private String idMudanca;
    private String data;
    private Item itemAntigo;
    private Item itemAtualizado;
    private Usuario responsavel;
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
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
