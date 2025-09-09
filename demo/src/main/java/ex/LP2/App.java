package ex.LP2;
public class App {
    public static void main(String[] args) throws Exception {
        Endereco endereco;
        endereco = new Endereco();
        endereco.setRua("Rua Tal");
        endereco.setNumero("123");
        
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Fulano de Tal");
        pessoa.setEmail("ftal@gmail.com");
        pessoa.setEndereco(endereco);

        pessoa.getEndereco().getRua();

        // teste12

       
    }
}
