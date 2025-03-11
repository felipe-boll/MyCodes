package ex.lista00;

import java.util.Scanner;

public class FelipeBoll_1963 {

  public static Scanner tecladoScanner = new Scanner(System.in);

  public static double descobrirDiferencaPorc(double diferenca, double valorAntigo) {
    double diferencaPorc = 0;

    diferencaPorc = (diferenca / valorAntigo) * 100;

    return diferencaPorc;
  }

  public static void main(String[] args) {
    double valorAntigo = tecladoScanner.nextDouble();
    double valorAtual = tecladoScanner.nextDouble();

    double diferenca = valorAtual - valorAntigo;

    double diferencaPorc = descobrirDiferencaPorc(diferenca, valorAntigo);

    System.out.printf("%.2f%%\n", diferencaPorc);

  }
}
