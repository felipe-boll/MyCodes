import java.util.Scanner;

public class bubbleSort {
    
    public static Scanner tecladoScanner = new Scanner(System.in);

    public static void trocar(int[] vet, int i){
        int ajuda = vet[i];
        vet[i] = vet[i + 1];
        vet[i + 1] = ajuda;
    }

    public static void bubbleSor(int[] vet){
        int contMov = 0;
        boolean troca = true;
        int tamanho = vet.length;
        

            troca = false;

        for (int i = 0; i <= tamanho - 1; i++) {
            if (vet[i] == tamanho) {
                System.out.println(vet[i]);
                break;
            } else if (vet[i] > vet[i + 1]) {
                trocar(vet, i);
                contMov += 2;
                troca = true;
            }

            System.out.printf("%d ", vet[i]);
        }
        

        System.out.println(contMov);
    }


    public static void main(String[] args) {
        int[] vet = new int[4];

        for (int i = 0; i < vet.length; i++) {
            vet[i] = tecladoScanner.nextInt();
        }

        bubbleSor(vet);
    }
}
