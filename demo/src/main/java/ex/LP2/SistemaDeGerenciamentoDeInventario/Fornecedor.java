package ex.LP2.SistemaDeGerenciamentoDeInventario;

public class Fornecedor {
  private String nome;
  private Produto[] produto;

  public Fornecedor() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto[] getProduto() {
    return produto;
  }

  public void setProduto(Produto[] produto) {
    this.produto = produto;
  }
}
