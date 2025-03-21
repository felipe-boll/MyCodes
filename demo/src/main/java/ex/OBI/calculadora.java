package ex.OBI;

import java.util.Scanner;

public class calculadora {
    
    public static Scanner tecladoScanner = new Scanner(System.in);

    public static double calcular(double primeiroValor, double segundoValor, String operador){
        double terceiroValor = 0;
        
        if (operador.equals("X") || operador.equals("x") || operador.equals("*")) {
            terceiroValor = primeiroValor * segundoValor;
        } else if (operador.equals("/")) {
            terceiroValor = primeiroValor / segundoValor;
        } else if (operador.equals("+")) {
            terceiroValor = primeiroValor + segundoValor;
        } else if (operador.equals("-")) {
            terceiroValor = primeiroValor - segundoValor;
        } else if (operador.equals("%")) {
            terceiroValor = (primeiroValor * segundoValor) / 100;
        }

        return terceiroValor;
    }
    
    public static void main(String[] args) {
        while (tecladoScanner.hasNext()) {
            double primeiroValor = tecladoScanner.nextInt();
            String operador = tecladoScanner.next();
            double segundoValor = tecladoScanner.nextInt();

            double terceiroValor = calcular(primeiroValor, segundoValor, operador);
            
            System.out.printf("= %.1f\n", terceiroValor);
        }
    }
}

