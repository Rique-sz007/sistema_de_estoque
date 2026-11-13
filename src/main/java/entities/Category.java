package entities;

public class Category {
    private Integer id;
    private String nome;

    public Category(int id, String nome) {
        this.id = id;
        setNome(nome);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser null.");
        }
        this.nome = nome;
    }


}
