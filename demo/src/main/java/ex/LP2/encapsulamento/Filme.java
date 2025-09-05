package ex.LP2.encapsulamento;

public class Filme {
    private String titulo;
    private String categoria;
    private String classificacaoEtaria;
    private String resumo;
    // atributo de associação
    private Diretor diretor;
    private Estudio estudio;

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo.toUpperCase();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(String classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Filme() {
    }

}
