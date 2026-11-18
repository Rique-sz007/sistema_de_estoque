
package dao;

import database.DB;
import entities.Product;
import entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void inserir(Product produto) throws SQLException {
        Connection conn = DB.getConexao();

        String sql = "INSERT INTO produto (codigo, nome, preco, estoque, categoria_id) VALUES (?,?,?,?,?)";
        try (PreparedStatement smts = conn.prepareStatement(sql)) {
            smts.setString(1, produto.getCodigo());
            smts.setString(2, produto.getNome());
            smts.setDouble(3, produto.getPreco());
            smts.setInt(4, produto.getEstoque());
            smts.setInt(5, produto.getCategoria().getId());

            smts.executeUpdate();
        }
    }

    public List<Product> products() throws SQLException {
        Connection connection = DB.getConexao();

        String sql = """
                SELECT p.id, p.codigo, p.nome, p.preco, p.estoque,
                       c.id AS categoria_id, c.nome AS categoria_nome
                FROM produto p
                INNER JOIN categorias c ON p.categoria_id = c.id
                """;

        List<Product> products = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int estoque = rs.getInt("estoque");

                int categoriaId = rs.getInt("categoria_id");
                String categoriaNome = rs.getString("categoria_nome");
                Category categoria = new Category(categoriaId, categoriaNome);
                Product product = new Product(
                        id, codigo, nome, preco, estoque, categoria
                );
                products.add(product);
            }
        }
        return products;
    }

    public void delete(Integer id) throws  SQLException{

        String sql = "DELETE FROM produto WHERE id = ?";
       try(Connection conn = DB.getConexao();
           PreparedStatement smts = conn.prepareStatement(sql)) {
            smts.setInt(1, id);
            int linhaAfetado = smts.executeUpdate();
            if (linhaAfetado == 0) {
                System.out.println("Nenhuma  linha foi afetada!");
            }
            else {
                System.out.println("O produto foi excluído!");
            }
        }
    }
    public  void update(Integer id, String codigo, String nome, double preco, int estoque, int categoria_id) throws SQLException{
        String sql = "UPDATE produto SET codigo = ?, nome = ?, preco = ?, estoque = ?, categoria_id = ? WHERE id = ?";
       try (Connection connection = DB.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);) {
           statement.setString(1, codigo);
           statement.setString(2, nome);
           statement.setDouble(3, preco);
           statement.setInt(4, estoque);
           statement.setInt(5,categoria_id);
           statement.setInt(6, id);
           int linhaAfetada = statement.executeUpdate();
           if (linhaAfetada == 0) {
               System.out.println("Nenhum produto foi encontrado.");
           }
           else { System.out.println("Produto atualizado com sucesso!");}

       }
    }


}
