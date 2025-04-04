package ex.OBI;

import java.util.Scanner;

public class picos_e_vales {

    public static Scanner tecladoScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int quantTestes = tecladoScanner.nextInt();
        int resultado = 0;
        int infAnterior = Integer.MIN_VALUE;
        int infAtual = Integer.MIN_VALUE;

        for(int i = 0; i < quantTestes; i++){
            infAtual = tecladoScanner.nextInt();
        
            if (infAtual > infAnterior || infAtual < infAnterior) {
                resultado = 1;
            } else{
                resultado = 0;
                break;
            }
    
            infAnterior = infAtual;
        }

        System.out.println(resultado);
    }
}
