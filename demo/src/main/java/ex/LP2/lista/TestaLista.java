package ex.LP2.lista;

public class TestaLista {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.add(3);
        lista.add(9);
        lista.add(150);
        lista.add(1);
        lista.show();
        lista.addInicio(200);
        lista.show();
        lista.addPosicao(2, 1000);
        lista.show();
        
        
    }

}
