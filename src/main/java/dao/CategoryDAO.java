package dao;
import java.sql.Connection;
import java.sql.SQLException;
import entities.Category;
import java.sql.PreparedStatement;
import database.DB;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class CategoryDAO {
    public void inserir(String nome) throws  SQLException {

        String sql = "INSERT INTO categorias (nome) VALUES (?)";
        try (Connection conn = DB.getConexao();
             PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, nome);
        statement.executeUpdate();
        }
    }

    public List<Category> categorys() throws SQLException {


        String sql = "SELECT * FROM categorias";
        List<Category> category = new ArrayList<>();

        try (Connection connection = DB.getConexao();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Category categoria = new Category(id, nome);
                category.add(categoria);
            }
            return category;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM categorias WHERE id = ?";

       try ( Connection connection = DB.getConexao();
        PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
        int linhaAfetada = statement.executeUpdate();
        if (linhaAfetada == 0) {
            System.out.println("Categoria não encontrada.");
        } else {
            System.out.println("Categoria excluída com sucesso.");
        }
       } catch (SQLException e) {
           System.out.println("Categoria não encontrada:  " + e.getMessage());

       }
    }
    public void update(Integer id, String nome) throws SQLException {
        String sql = "UPDATE categorias SET nome = ? WHERE id = ?";
        try (Connection connection = DB.getConexao();
        PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(2, id);
        statement.setString(1, nome);
        statement.executeUpdate();
        }
    }
}
