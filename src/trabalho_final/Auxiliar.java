package trabalho_final;

public class Auxiliar extends Funcionario{
    private int qtd_produtos_cadastrados;
    
    public Auxiliar(float salario_base, int matricula, String nome, String CPF, String RG, String endereco, String telefone) {
        super(salario_base, matricula, nome, CPF, RG, endereco, telefone);
        this.qtd_produtos_cadastrados = 0;
    }

    public int getQtd_produtos_cadastrados() {
        return qtd_produtos_cadastrados;
    }

    public void setQtd_produtos_cadastrados(int qtd_produtos_cadastrados) {
        this.qtd_produtos_cadastrados = qtd_produtos_cadastrados;
    }
    
    
    
}
