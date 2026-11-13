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
        Connection conn = DB.getConexao();

        String sql = "INSERT INTO categorias (nome) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome);
        statement.executeUpdate();
    }

    public List<Category> categorys() throws SQLException {
        Connection connection = DB.getConexao();

        String sql = "SELECT * FROM categorias";
        List<Category> category = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Category name = new Category(id, nome);
                category.add(name);
            }
            return category;
        }
    }

    public void delete(Integer id) throws SQLException {
        Connection connection = DB.getConexao();

        String sql = "DELETE FROM categorias WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
    public void update(Integer id, String nome) throws SQLException {
        Connection connection = DB.getConexao();

        String sql = "UPDATE categorias SET nome = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(2, id);
        statement.setString(1, nome);
        statement.executeUpdate();
    }
}
