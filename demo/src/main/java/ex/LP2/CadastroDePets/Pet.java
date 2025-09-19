package ex.LP2.CadastroDePets;

import java.util.List;

public class Pet {
    private String nome;
    private String raca;
    private List<String> alergia;
    private double peso;
    private Tutor tutor;
    private List<Servico> servico;

    public Pet(){
    }

    public enum Situacao{
        EM_ESPERA, JA_ATENDIDO 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public List<String> getAlergia() {
        return alergia;
    }

    public void setAlergia(List<String> alergia) {
        this.alergia = alergia;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
    }
}
