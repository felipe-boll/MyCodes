package ex.FelipeBoll_ListaB_ordenacao;

import java.util.Scanner;

public class paresEInpares {

    public static Scanner tecladoScanner = new Scanner(System.in);

    public static void trocar(int[] paresEImpares, int i) {
        int ajuda = paresEImpares[i];
        paresEImpares[i] = paresEImpares[i + 1];
        paresEImpares[i + 1] = ajuda;
    }

    public static int[] imparesEParesOrdenados(int[] paresEImpares) {
        int tamanho = paresEImpares.length - 1;
        int[] paresEImparesOrdenados = new int[paresEImpares.length];
        boolean troca = true;

        while (troca) {
            troca = false;

            for (int i = 0; i < tamanho; i++) {
                if (i == tamanho) {
                } else {
                    if (paresEImpares[i] > paresEImpares[i + 1]) {
                        trocar(paresEImpares, i);
                        troca = true;
                    }
                }
            }
        }

        for (int i = 0; i < paresEImpares.length; i++) {
            paresEImparesOrdenados[i] = paresEImpares[i];
        }

        return paresEImparesOrdenados;
    }

    public static void imprimirPares(int[] paresEImpares) {
        for (int i = 0; i < paresEImpares.length; i++) {
            if (paresEImpares[i] % 2 == 0) {
                System.out.println(paresEImpares[i]);
            }
        }
    }

    public static void imprimirImpares(int[] paresEImpares) {
        for (int i = paresEImpares.length - 1; i > 0; i--) {
            if (paresEImpares[i] % 2 != 0) {
                System.out.println(paresEImpares[i]);
            }
        }
    }

    public static void main(String[] args) {
        int qntTeste = tecladoScanner.nextInt();
        int[] paresEImpares = new int[qntTeste];

        for (int i = 0; i < qntTeste; i++) {
            paresEImpares[i] = tecladoScanner.nextInt();
        }

        paresEImpares = imparesEParesOrdenados(paresEImpares);

        imprimirPares(paresEImpares);
        imprimirImpares(paresEImpares);
        System.out.println();
    }
}
