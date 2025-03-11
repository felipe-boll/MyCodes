package ex.lista00;

import java.util.Scanner;

public class FelipeBoll_1743 {

  public static Scanner tecladoScanner = new Scanner(System.in);

  public static int[] preencherVetorInt(int[] vetorInt) {
    for (int i = 0; i < vetorInt.length; i++) {
      vetorInt[i] = tecladoScanner.nextInt();
    }

    return vetorInt;
  }

  public static char descobrirCompatibilidade(int[] primeiroConector, int[] segundoConector) {
    char resultado = ' ';
    boolean primeiraVez = true;

    for (int i = 0; i < primeiroConector.length; i++) {
      if (primeiroConector[i] != segundoConector[i] && primeiraVez == true) {
        resultado = 'Y';
      } else {
        resultado = 'N';
        primeiraVez = false;
      }
    }

    return resultado;
  }

  public static void main(String[] args) {
    // Entrada
    int[] primeiroConector = new int[5];
    int[] segundoConector = new int[5];

    // Processamento
    primeiroConector = preencherVetorInt(primeiroConector);
    segundoConector = preencherVetorInt(segundoConector);

    char resultado = descobrirCompatibilidade(primeiroConector, segundoConector);

    // Saida
    System.out.println(resultado);

  }
}
