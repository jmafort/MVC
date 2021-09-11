package trabalho_final;

public class Gerente extends Funcionario{
    
    private float salario;
    private static double taxa_lucro = 0.05;
    
    public Gerente(float salario_base, int matricula, String nome, String CPF, String RG, String endereco, String telefone) {
        super(salario_base, matricula, nome, CPF, RG, endereco, telefone);
        this.salario = salario_base;
    }
    
    
}
