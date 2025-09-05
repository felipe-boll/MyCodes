package ex.LP2.SistemaDeGerenciamentoDeInventario;

public class Cliente {
  private String nome;
  private Pedido pedido;

  public Cliente() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
}
