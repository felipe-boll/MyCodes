package ex.TreinoRec;

import java.util.Scanner;

public class acimaDiagoalSecundaria {
    
    public static Scanner tecladoScanner = new Scanner(System.in);

    static void preencherMatriz(double[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = tecladoScanner.nextDouble();
            }
        }
    }

    public static double realizarOperacaoS(double[][] matriz){
        double resultadoOperacao = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length - 1 - i; j++) {
                resultadoOperacao += matriz[i][j];
            }
        }

        return resultadoOperacao;
    }

    public static double realizarOperacaoM(double[][] matriz){
        final int QNT_OPERANDO = 66;

        return realizarOperacaoS(matriz) / QNT_OPERANDO;

    }
    
    public static void mensagem(double resultadoOperacao){
        System.out.printf("%.1f\n", resultadoOperacao);
    }

    public static void main(String[] args) {
        double[][] matriz = new double[12][12];
        char indicadorOp = tecladoScanner.next().charAt(0);
        double resultadoOperacao = 0;

        preencherMatriz(matriz);

        if (indicadorOp == 'S') {
            resultadoOperacao = realizarOperacaoS(matriz);
        } else{
            resultadoOperacao = realizarOperacaoM(matriz);
        }

        mensagem(resultadoOperacao);
    }
}
