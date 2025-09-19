package ex.LP2.CadastroDePets;

import java.util.ArrayList;

public class Pet {
    private String nome;
    private String raca;
    private String sexo;
    private String idade;
    private ArrayList<String> alergia = new ArrayList<>();
    private double peso;
    private Tutor tutor;
    private ArrayList<Servico> servico = new ArrayList<>();
    private Situacao situacao;


    public Pet(){
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.tutor = tutor;
        this.situacao = situacao.EM_ESPERA;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public ArrayList<String> getAlergia() {
        return alergia;
    }

    public void setAlergia(ArrayList<String> alergia) {
        this.alergia = alergia;
    }

    public void addAlergia(String alergia) {
        this.alergia.add(alergia);
    }

    public void removeAlergia(String alergia) {
        this.alergia.remove(alergia);
    }

    public ArrayList<Servico> getServico() {
        return servico;
    }

    public void setServico(ArrayList<Servico> servico) {
        this.servico = servico;
    }

    public void addServico(Servico servico) {
        this.servico.add(servico);
    }
    
    public void removeServico(Servico servico) {
        this.servico.remove(servico);
    }
}
