package ex.LP2.SistemaDeGerenciamentoDeInventario;

public class Main {
  public static void main(String[] args) {
    Categoria categoria1 = new Categoria();
    categoria1.setNome("Eletrônicos");
    categoria1.setDescricao("Produtos eletrônicos em geral");

    Categoria categoria2 = new Categoria();
    categoria2.setNome("Alimentos");
    categoria2.setDescricao("Produtos comestiveis");

    Fornecedor fornecedor1 = new Fornecedor();
    fornecedor1.setNome("Elma Chips");

    Fornecedor fornecedor2 = new Fornecedor();
    fornecedor2.setNome("Apple");

    Produto celular = new Produto();
    celular.setNome("Iphone 25 Pro Max Ultra Plus Blaster Gold");
    celular.setPreco(20540.99);
    celular.setDescricao(
        "Vale cada centavo por esse salto de tecnologia (uma camera a mais) comparando com a ultima versao");
    celular.setCategoria(categoria1);
    celular.setFornecedor(fornecedor1);

    Produto salgadinho = new Produto();
    salgadinho.setNome("Cheetos de Requeijão");
    salgadinho.setPreco(15.50);
    salgadinho.setDescricao("Otimo gosto, pésimo cheiro nos dedos");
    salgadinho.setCategoria(categoria1);
    salgadinho.setFornecedor(fornecedor2);

    Produto[] produtosFornecedor1 = { celular };
    fornecedor1.setProduto(produtosFornecedor1);

    Produto[] produtosFornecedor2 = { salgadinho };
    fornecedor2.setProduto(produtosFornecedor2);

    Produto[] produtosEletronicos = { celular };
    categoria1.setProdutos(produtosEletronicos);

    Produto[] produtosComestiveis = { salgadinho };
    categoria2.setProdutos(produtosComestiveis);

    Cliente cliente = new Cliente();
    cliente.setNome("João Silva");

    Pedido pedido = new Pedido();
    Produto[] produtosPedido = { celular, salgadinho };
    pedido.setProdutos(produtosPedido);
    pedido.setCliente(cliente);

    Pedido[] pedidosCelular = { pedido };
    celular.setPedidos(pedidosCelular);

    Pedido[] pedidosSalgadinho = { pedido };
    salgadinho.setPedidos(pedidosSalgadinho);

    cliente.setPedido(pedido);
  }
}
