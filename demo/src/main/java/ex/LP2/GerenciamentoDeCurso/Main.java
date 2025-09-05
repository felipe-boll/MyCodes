package ex.LP2.GerenciamentoDeCurso;

public class Main {
  public static void main(String[] args) {
    Curso curso = new Curso();
    curso.setNome("Tecnico em Informatica");
    curso.setDuracao(12);
    curso.setMensalidade(200);

    Disciplina disciplina1 = new Disciplina();
    disciplina1.setNome("Linguagem de Programação");
    Disciplina disciplina2 = new Disciplina();
    disciplina2.setNome("Banco de Dados");

    Disciplina[] disciplinas = { disciplina1, disciplina2 };
    curso.setDisciplinas(disciplinas);

    Professor professor1 = new Professor();
    professor1.setNome("Roberta");
    professor1.setDisciplina(disciplina1);

    Professor professor2 = new Professor();
    professor2.setNome("Herbert");
    professor2.setDisciplina(disciplina2);

    Academico academico1 = new Academico();
    academico1.setNome("Felipe Chaves Boll");
    academico1.setIdade(16);

    Academico academico2 = new Academico();
    academico2.setNome("Murilo Ferreira");
    academico2.setIdade(15);

    Turma turma = new Turma();
    turma.setNome("2° de Informatica");

    Academico[] academicos = { academico1, academico2 };
    turma.setAcademicos(academicos);

    academico1.setTurma(turma);
    academico2.setTurma(turma);

    Turma[] turmasProfessor = { turma };
    professor1.setTurmas(turmasProfessor);
    professor2.setTurmas(turmasProfessor);

    Turma[] turmasCurso = { turma };
    curso.setTurmas(turmasCurso);

  }
}
