
package trabalho_final;

public class Produto {
    private String Nome;
    private int id;
    private double preco;
    private int qtd_estoque;
    private boolean mostruario;

    public Produto(String Nome, int id, double preco, int qtd_estoque, boolean mostruario) {
        this.Nome = Nome;
        this.id = id;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
        this.mostruario = mostruario;
    }

    public String getNome() {
        return Nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public boolean isMostruario() {
        return mostruario;
    }
    
}
