package ex.LP2.encapsulamento;

public class Diretor {
    private String nome;
    private String paisOrigem;
    // atributo de associação
    private Filme filme;

    public Diretor() {
    }

    public Diretor(String nome) {
        this.nome = nome;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

}
