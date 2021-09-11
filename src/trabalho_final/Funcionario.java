/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_final;

public class Funcionario extends Pessoa{
    private double salario_base;

    public Funcionario(double salario_base, String nome, String CPF, String endereco, String telefone) {
        super(nome, CPF, endereco, telefone);
        this.salario_base = salario_base;
    }

    public double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(double salario_base) {
        this.salario_base = salario_base;
    }
    
}
