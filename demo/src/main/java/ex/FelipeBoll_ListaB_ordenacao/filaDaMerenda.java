package ex.FelipeBoll_ListaB_ordenacao;

import java.util.Scanner;

public class filaDaMerenda {

  public static Scanner tecladoScanner = new Scanner(System.in);

  public static void trocar(int[] notasOrdenadas, int i) {
    int ajuda = notasOrdenadas[i];
    notasOrdenadas[i] = notasOrdenadas[i - 1];
    notasOrdenadas[i - 1] = ajuda;
  }

  public static int ordenarNotas(int[] notas) {
    int tamanho = notas.length - 1;
    int contAlunosNaoTrocados = 0;
    int[] notasOrdenadas = new int[notas.length];
    boolean troca = true;

    for (int i = 0; i < notas.length; i++) {
      notasOrdenadas[i] = notas[i];
    }

    while (troca) {
      troca = false;

      for (int i = tamanho; i > 0; i--) {
        if (i == 0) {
        } else {
          if (notasOrdenadas[i] > notasOrdenadas[i - 1]) {
            trocar(notasOrdenadas, i);
            troca = true;
          }
        }
      }
    }

    for (int i = 0; i < notasOrdenadas.length; i++) {
      if (notas[i] == notasOrdenadas[i]) {
        contAlunosNaoTrocados++;
      }
    }

    return contAlunosNaoTrocados;
  }

  public static void main(String[] args) {
    int quntTeste = tecladoScanner.nextInt();

    for (int i = 0; i < quntTeste; i++) {
      int numAlunos = tecladoScanner.nextInt();
      int[] notas = new int[numAlunos];

      for (int j = 0; j < numAlunos; j++) {
        notas[j] = tecladoScanner.nextInt();
      }

      int contAlunosNaoTrocados = ordenarNotas(notas);

      System.out.println(contAlunosNaoTrocados);

    }
  }
}
