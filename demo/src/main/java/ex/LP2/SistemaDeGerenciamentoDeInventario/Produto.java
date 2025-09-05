package ex.LP2.SistemaDeGerenciamentoDeInventario;

public class Produto {
  private String nome;
  private double preco;
  private String descricao;
  private Categoria categoria;
  private Fornecedor fornecedor;
  private Pedido[] pedidos;

  public Produto() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public Pedido[] getPedidos() {
    return pedidos;
  }

  public void setPedidos(Pedido[] pedidos) {
    this.pedidos = pedidos;
  }
}
