package ex.lista00;

import java.util.Scanner;

public class FelipeBoll_2582 {

  public static Scanner tecladoScanner = new Scanner(System.in);

  public static String desbobrirQualMusicaTocar(int soma, String musica) {
    switch (soma) {
      case 0:
        musica = "PROXYCITY";
        break;
      case 1:
        musica = "P.Y.N.G.";
        break;
      case 2:
        musica = "DNSUEY!";
        break;
      case 3:
        musica = "SERVERS";
        break;
      case 4:
        musica = "HOST!";
        break;
      case 5:
        musica = "CRIPTONIZE";
        break;
      case 6:
        musica = "OFFLINE DAY";
        break;
      case 7:
        musica = "SALT";
        break;
      case 8:
        musica = "ANSWER!";
        break;
      case 9:
        musica = "RAR?";
        break;
      case 10:
        musica = "WIFI ANTENNAS";
        break;
    }

    return musica;
  }

  public static void main(String[] args) {
    int quantTest = tecladoScanner.nextInt();
    String musica = " ";

    for (int i = 0; i < quantTest; i++) {
      int primeiraEnt = tecladoScanner.nextInt();
      int segundaEnt = tecladoScanner.nextInt();
      musica = " ";

      int soma = primeiraEnt + segundaEnt;

      musica = desbobrirQualMusicaTocar(soma, musica);

      System.out.println(musica);

    }
  }
}