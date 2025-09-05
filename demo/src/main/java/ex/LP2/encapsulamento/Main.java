package encapsulamento;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setTitulo("Formula 1");
        filme.setCategoria("ação");
        filme.setClassificacaoEtaria("12 anos");
        filme.setResumo("Filme trata do retorno ...");
        // filme.setDiretor(new Diretor("Joseph Kosinski"));
        Diretor diretor = new Diretor("Joseph Kosinski");
        filme.setDiretor(diretor);
        diretor.setFilme(filme);
        filme.setEstudio(new Estudio("Warner Bros"));

        filme.getDiretor().getNome();

    }

}
