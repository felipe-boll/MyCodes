package ex.LP2.CadastroDePets;

import java.util.ArrayList;

public class Tutor {
    private String nome;
    private String cpf;
    private String email;
    private ArrayList<Pet> pets = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();
    
    public Tutor(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
    
    public void removePet(Pet pet) {
        this.pets.remove(pet);
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void removeServico(Servico servico) {
        this.servicos.remove(servico);
    }

}
