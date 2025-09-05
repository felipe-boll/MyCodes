package ex.LP2.SistemaDeGerenciamentoDeInventario;

public class Pedido {
  private Produto[] produtos;
  private Cliente cliente;

  public Pedido() {
  }

  public Produto[] getProdutos() {
    return produtos;
  }

  public void setProdutos(Produto[] produtos) {
    this.produtos = produtos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
