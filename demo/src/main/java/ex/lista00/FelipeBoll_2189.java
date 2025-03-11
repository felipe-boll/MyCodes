package ex.lista00;

import java.util.Scanner;

public class FelipeBoll_2189 {

  public static Scanner tecladoScanner = new Scanner(System.in);

  public static void descobrirVencedor(int[] sequenciaDeEntrada, int contadorDeTestes) {

    for (int i = 1; i <= sequenciaDeEntrada.length; i++) {
      if (sequenciaDeEntrada[i - 1] == i) {
        System.out.printf("Teste %d\n%d\n\n", contadorDeTestes, i);
      }
    }

  }

  public static void main(String[] args) {
    int contadorDeTestes = 0;

    while (true) {
      int quantPessoas = tecladoScanner.nextInt();

      if (quantPessoas == 0) {
        break;
      }

      contadorDeTestes++;
      int[] sequenciaDeEntrada = new int[quantPessoas];

      for (int i = 0; i < sequenciaDeEntrada.length; i++) {
        sequenciaDeEntrada[i] = tecladoScanner.nextInt();
      }

      descobrirVencedor(sequenciaDeEntrada, contadorDeTestes);

    }

  }
}
