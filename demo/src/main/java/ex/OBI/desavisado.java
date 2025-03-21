package ex.OBI;

import java.util.Scanner;

public class desavisado {
    
    public static Scanner tecladoScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        while (true) {
            System.out.println("Qual seu nome?");
        String nome = tecladoScanner.next();

        if (nome.equals("Felipe")) {
            System.out.printf("Que nome legal!\n\n");
        } else
            System.out.printf("%s: Voce perdeu o jogo (otario, voce perdeu o jogo para um programakkkkkkkkkkk, muito burro)\n\n", nome);
        }
    }
}
