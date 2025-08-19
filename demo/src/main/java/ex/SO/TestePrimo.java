package ex.SO;

public class TestePrimo {
    public static void main(String[] args) {
        if(args.length <= 1){
            System.out.println("Numero de argumentos invalido");
            return;
        }

        System.out.printf("arg[0]: %s\narg[1]: %s\n", args[0], args[1]);
        int it;
        char print;

        try{
            it = Integer.parseInt(args[0]);
            print = args[1].charAt(0);
            
            if(print == 'p'){
                executarVerificarPrimoP(it);
            } else{
                executarVerificarPrimo(it);
            }

        } catch(Exception e){
            System.out.println("Seus argumentos estão incorretos!");
            return;
        }
    }

    public static boolean verificarPrimo(long n){
        for (long i = 2; i < n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }

    public static void executarVerificarPrimo(long it){
        for(long i = 2; i < it; i++){
            verificarPrimo(i);
        }
    }

    public static void executarVerificarPrimoP(long it) {
        for (long i = 2; i < it; i++) {
            System.out.println(i + ": " + verificarPrimo(i));
        }
    }
}
