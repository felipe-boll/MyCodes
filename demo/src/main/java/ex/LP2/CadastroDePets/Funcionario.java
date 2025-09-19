package ex.LP2.CadastroDePets;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cpf, String email, String telefone, int idade, String endereco, String cargo, double salario) {
        super(nome, cpf, email, telefone, idade, endereco);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
