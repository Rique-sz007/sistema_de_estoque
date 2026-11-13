
package entities;

public class Product {
    private Integer id;
    private String codigo;
    private String nome;
    private Double preco;
    private Integer estoque;
    private Category categoria;

    public Product(Integer id, String codigo, String nome, Double preco, Integer estoque, Category categoria) {
        this.id = id;
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
        setCategoria(categoria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O código não pode ser null ou vazio.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser null ou vazio.");
        }
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        if (preco == null || preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        if (estoque == null || estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo ou null.");
        }
        this.estoque = estoque;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("A categoria não pode ser null.");
        }
        this.categoria = categoria;
    }
}
