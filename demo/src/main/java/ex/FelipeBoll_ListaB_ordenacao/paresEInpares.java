package ex.FelipeBoll_ListaB_ordenacao;

import java.util.Scanner;

public class paresEInpares {
    
    public static Scanner tecladoScanner = new Scanner(System.in);

    public static int[] imparesEParesOrdenados(int[] paresEImpares){
        int tamanho = paresEImpares.length;


        for (int i = 0; i < tamanho; i++) {
            int valor = tecladoScanner.nextInt();
        }


    }
    
    public static void main(String[] args) {
        int qntTeste = tecladoScanner.nextInt();
        int[] paresEImpares = new int[qntTeste];

        for (int i = 0; i < qntTeste; i++) {
            paresEImpares[i] = tecladoScanner.nextInt();
        }

        paresEImpares = imparesEParesOrdenados(paresEImpares);
    }
}
