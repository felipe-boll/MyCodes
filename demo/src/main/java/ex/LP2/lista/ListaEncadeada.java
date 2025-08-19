package ex.LP2.lista;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;
    private int tamanho = 0;

    public ListaEncadeada() {
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void add(int elemento){
        No no = new No();
        no.setElemento(elemento);
        no.setProximo(null);

        if (tamanho==0){ //lista vazia
            this.primeiro = no;
        }else{
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        tamanho++;
    }

    public void addInicio(int elemento){
        No no = new No();
        no.setElemento(elemento);
        no.setProximo(null);
        if (tamanho==0){
            ultimo = no;
        }
        no.setProximo(primeiro);
        primeiro = no;
        tamanho++;

    }

    public void addPosicao(int pos, int elemento){
        if (pos == 0){//adiciona no inicio
            addInicio(elemento);
            return;
        }
        if (pos == tamanho){//adiciona no final
            add(elemento);
            return;
        }
        No no = new No();
        no.setElemento(elemento);
        no.setProximo(null);
        No atual = primeiro;

        for(int i=0; i<pos-1;i++){
            atual=atual.getProximo();
        }
        no.setProximo(atual.getProximo());
        atual.setProximo(no);
        tamanho++;

    }







    public void show(){
        No iterator = primeiro;
        System.out.println("Lista");
        for (int i = 1; i <= tamanho; i++) {
            System.out.println(iterator.getElemento()+" ");
            iterator = iterator.getProximo();
        }
    }

}
