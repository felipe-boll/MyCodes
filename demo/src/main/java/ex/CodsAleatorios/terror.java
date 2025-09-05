package ex.CodsAleatorios;

import java.util.Random;
import java.util.Scanner;

public class terror {
    public static Scanner tecladoScanner = new Scanner(System.in);
    public static Random random = new Random();

    public static String[] reacoes(){
        String[] reacoes = new String[5];
        
        reacoes[0] = "É só isso que voce tem?";
        reacoes[1] = "Isso não assusta nem minha irma recem-nascida";
        reacoes[2] = "uááá, que sono essa sua historia";
        reacoes[3] = "Buá, buá, estou chorando de medo. Só que não";
        reacoes[4] = "Da pra me liberar? Tenho coisas mais importantes que isso pra fazer do que escutar suas historias chatas";

        return reacoes;
    }

    public static void medo(String historiaTerror, String[] reacoes){
        String reacao = " ";

        if (historiaTerror.equals("buu")) {
            reacao = "AAAAAHHHHH!!!! QUE MEDO!!!\nDesito voce ganhou, só não faz isso de novo por favor";
        } else{
            reacao = reacoes[random.nextInt(5)];
        }

        System.out.printf("\n%s\n",reacao);
    }

    public static void main(String[] args) {
        System.out.printf("Tente me assustar, mas duvido que vai conseguir, HAHAHAHAHAHA\n");
        String[] reacoes = reacoes();
        
        while (true) {
            String historiaTerror = tecladoScanner.nextLine().toLowerCase();

            medo(historiaTerror, reacoes);

            if (historiaTerror.equals("buu")) {
                break;
            }

        }
    }
}
