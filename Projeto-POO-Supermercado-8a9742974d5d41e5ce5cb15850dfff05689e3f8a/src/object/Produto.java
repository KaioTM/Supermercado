package object;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KaioT
 */
public class Produto implements Serializable {
    private String idProduto;
    private String nomeProduto;
    private float preço;

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Produto(String idProduto, String nomeProduto, float preço) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.preço = preço;
    }
}
