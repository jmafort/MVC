/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_final;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    
    private List<Venda> vendas = new ArrayList<Venda>();

    public Cliente(String nome, String CPF, String endereco, String telefone) {
        super(nome, CPF, endereco, telefone);
    }
    
    public Venda getVenda(int id){
        Venda venda = null;
        for(Venda v : this.vendas){
            if(v.getId() == id){
                venda = v;
            }
        }
        return venda;
    }

    public void atualizaVenda(Venda venda, int index){
        this.vendas.add(index, venda);
    }

    public void addVenda(Venda venda) {
        vendas.add(venda);
    }
    
    public List<Venda> getVendas() {
        return vendas;
    }

    @Override
    public String toString() {
        return "Cliente{" +  this.getNome() + '}';
    }
    
}
