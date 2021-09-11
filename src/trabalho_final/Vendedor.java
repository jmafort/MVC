
package trabalho_final;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario{
    private double salario;
    private List<Venda> vendas = new ArrayList<Venda>();
    private final double comissao;

    public Vendedor(double salario_base, String nome, String CPF, String endereco, String telefone) {
        super(salario_base, nome, CPF, endereco, telefone);
        this.salario = salario_base;
        this.comissao = 0.05;
    }
    

    public double getComissao(){
        return this.comissao;
    }

    public double getSalario() {
        return salario;
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
    
    public List<Venda> getVendas() {
        return vendas;
    }

    public void addVenda(Venda venda) {
        vendas.add(venda);
    }
    
}
