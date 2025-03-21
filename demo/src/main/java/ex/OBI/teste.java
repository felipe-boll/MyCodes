package ex.OBI;

import java.util.Random;
import java.util.Scanner;

public class teste {

    public static Scanner tecladoScanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] vetor = new int[10];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextInt();
            System.out.println(vetor[i]);
        }
    }
}