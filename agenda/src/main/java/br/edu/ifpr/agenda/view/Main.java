package br.edu.ifpr.agenda.view;

import br.edu.ifpr.agenda.controller.ContatoController;
import br.edu.ifpr.agenda.model.Contato;
import br.edu.ifpr.agenda.model.Endereco;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando");
        Contato contato = new Contato();
        Endereco endereco = new Endereco();
        endereco.setRua("Rua Lilas");
        endereco.setNumero("287");
        endereco.setCidade("Cascavel");
        endereco.setEstado("Parana");

        ContatoController controller = new ContatoController();
        contato.setNome("Felipe Chaves Boll");
        contato.setCelular("(45)99831-9393");
        contato.setEmail("felipechavesboll@gmail.com");
        contato.setEndereco(endereco);
        controller.cadastrarContato(contato);


    }
}