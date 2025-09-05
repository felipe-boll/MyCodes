package ex.LP2.GerenciamentoDeCurso;

public class Turma {
  private String nome;
  private Curso curso;
  private Academico[] academicos;

  public Turma() {

  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Academico[] getAcademicos() {
    return academicos;
  }

  public void setAcademicos(Academico[] academicos) {
    this.academicos = academicos;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }
}
