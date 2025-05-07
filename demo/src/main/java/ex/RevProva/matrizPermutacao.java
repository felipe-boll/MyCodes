package ex.RevProva;

import java.util.Scanner;

public class matrizPermutacao {

    public static Scanner tecladoScanner = new Scanner(System.in);

    public static int[][] lerMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = tecladoScanner.nextInt();
            }
        }
        return matriz;
    }

    public static int lerNumLinha() {
        int linha = 0;

        do {
            linha = tecladoScanner.nextInt();
        } while (linha < 0 || linha > 5);

        return linha;
    }

    public static int lerNumColuna() {
        int coluna = 0;

        do {
            coluna = tecladoScanner.nextInt();
        } while (coluna < 0 || coluna > 10);

        return coluna;
    }

    public static boolean verificarLinha(int[][] matriz, boolean permuta){
        int cont = 0;
        permuta = true;

        for (int i = 0; i < matriz.length; i++) {
            cont = 0;
            for(int j = 0; j < matriz[0].length; j++){
                if (matriz[i][j] == 1) {
                    cont++;
                }
            }
            if (cont != 1) {
                permuta = false;
                break;
            }
        }

        return permuta;
    }    
    
    public static boolean verificarColuna(int[][] matriz, boolean permuta){
        int cont = 0;
        permuta = true;

        for (int i = 0; i < matriz.length; i++) {
            cont = 0;
            for(int j = 0; j < matriz[0].length; j++){
                if (matriz[j][i] == 1) {
                    cont++;
                }
            }
            if (cont != 1) {
                permuta = false;
                break;
            }
        }

        return permuta;
    } 

    public static boolean verificarPermutacao(int[][] matriz){
        boolean permuta = true;
        
        permuta = verificarColuna(matriz, permuta);
        
        if (permuta == true) {
            permuta = verificarLinha(matriz, permuta);
        }
        

        return permuta;
    }

    public static void imprimirMensagem(boolean permuta){
        if (permuta == true) {
            System.out.println("Esta matriz é permutada");
        } else{
            System.out.println("Essa matriz não é permutada");
        }
    }
    public static void main(String[] args) {
        int linhas = lerNumLinha();
        int colunas = lerNumColuna();

        int[][] matriz = new int[linhas][colunas];

        matriz = lerMatriz(matriz);

        // problema: se os 1 estao em uma unica coluna, ele nao considera e joga como permutado, não consegui arrumar isso a templo
        boolean permuta = verificarPermutacao(matriz);

        imprimirMensagem(permuta);
    }
}
