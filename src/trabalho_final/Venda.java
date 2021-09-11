/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_final;
import java.util.ArrayList;
import java.util.List;


public class Venda {
    private int id;
    private String date;
    private double total;
    private List<Produto> produtos = new ArrayList<Produto>();

    public Venda(int id, String date) {
        this.id = id;
        this.date = date;
        this.total = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        for(Produto p : produtos){
            this.total = this.total + p.getPreco();
        }
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProdutos(Produto produto) {
       this.produtos.add(produto);
    }
    
    
}
