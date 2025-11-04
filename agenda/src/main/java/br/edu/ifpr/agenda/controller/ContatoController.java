package br.edu.ifpr.agenda.controller;

import br.edu.ifpr.agenda.model.Contato;
import br.edu.ifpr.agenda.model.dao.ContatoDAO;

public class ContatoController {
    private ContatoDAO dao;

    public ContatoController() {
        this.dao = new ContatoDAO();
    }

    public void cadastrarContato(Contato contato){
        if(contato.getNome() == null  || contato.getNome().isEmpty()){
            System.out.println("Nome não pode ser vazio");
            return;
        }

        dao.salvar(contato);
        
    }

    public void excluirContato(int id){
        if (id <= 0) {
            System.err.println("id invalido");
            return;
        }

        dao.delete(id);
    }

    public void atualizarContato(Contato contato, int id){
        if (id <= 0) {
            System.err.println("id invalido");
            return;
        }
        
        dao.update(contato);
    }

    

}
