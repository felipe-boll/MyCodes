package ex.LP2.SistemaDeGerenciamentoDeInventario;

public class Categoria {
  private String nome;
  private String descricao;
  private Produto[] produtos;

  public Categoria() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Produto[] getProdutos() {
    return produtos;
  }

  public void setProdutos(Produto[] produtos) {
    this.produtos = produtos;
  }
}
