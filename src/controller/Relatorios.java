/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import model.MudancaEstoque;

/**
 *
 * @author kaio.teixeira
 */
public class Relatorios {

    private Map<String, MudancaEstoque> mudancaEstoque = new HashMap<>();

    public Map<String, MudancaEstoque> getMudancaEstoque() {
        return mudancaEstoque;
    }

    public void setMudancaEstoque(Map<String, MudancaEstoque> mudancaEstoque) {
        this.mudancaEstoque = mudancaEstoque;
    }

}
