package ex.LP2.CadastroDePets;

import java.util.List;

public class Tutor {
    private String nome;
    private String cpf;
    private String email;
    private List<Pet> pets;
    private List<Servico> servicos;
    
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
    public List<Pet> getPets() {
        return pets;
    }
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    public List<Servico> getServicos() {
        return servicos;
    }
    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
