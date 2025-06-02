package ex.FelipeBoll_ListaB_ordenacao;

import java.util.Scanner;

public class saltosOrnamentais {

  public static Scanner tecladoScanner = new Scanner(System.in);

  public static double[] prencherNotas(double[] notas) {
    for (int i = 0; i < notas.length; i++) {
      notas[i] = tecladoScanner.nextDouble();
    }

    return notas;
  }

  public static void trocar(double[] notas, int i) {
    double ajuda = notas[i];
    notas[i] = notas[i + 1];
    notas[i + 1] = ajuda;
  }

  public static double[] ordenarNotas(double[] notas) {
    double[] notasOrdenada = new double[notas.length];
    boolean troca = true;
    int tamanho = notas.length - 1;

    while (troca) {
      troca = false;

      for (int i = 0; i < tamanho; i++) {
        if (i == tamanho) {
        } else {
          if (notas[i] > notas[i + 1]) {
            trocar(notas, i);
            troca = true;
          }
        }
      }
    }

    for (int i = 0; i < notasOrdenada.length; i++) {
      notasOrdenada[i] = notas[i];
    }

    return notasOrdenada;

  }

  public static double calcularNotas(double[] notas, double grauDif) {
    double mediaNotas = 0;

    for (int i = 1; i < notas.length - 1; i++) {
      mediaNotas += notas[i];
    }

    mediaNotas *= grauDif;

    return mediaNotas;
  }

  public static void mensagem(String nome, double mediaNotas) {
    System.out.printf("%s %.2f\n", nome, mediaNotas);
  }

  public static void main(String[] args) {
    int numComp = tecladoScanner.nextInt();

    for (int i = 0; i < numComp; i++) {
      String nome = tecladoScanner.next();
      double grauDif = tecladoScanner.nextDouble();
      double[] notas = new double[7];

      notas = prencherNotas(notas);

      notas = ordenarNotas(notas);

      double notaFinal = calcularNotas(notas, grauDif);

      mensagem(nome, notaFinal);

    }

  }
}
