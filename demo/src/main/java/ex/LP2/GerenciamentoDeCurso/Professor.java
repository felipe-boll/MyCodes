package ex.LP2.GerenciamentoDeCurso;

public class Professor {
  private String nome;
  // considerando que um professor só aplica uma disciplina
  private Disciplina disciplina;
  private Turma[] turmas;

  public Professor() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Disciplina getDisciplina() {
    return disciplina;
  }

  public void setDisciplina(Disciplina disciplina) {
    this.disciplina = disciplina;
  }

  public Turma[] getTurmas() {
    return turmas;
  }

  public void setTurmas(Turma[] turmas) {
    this.turmas = turmas;
  }

}
