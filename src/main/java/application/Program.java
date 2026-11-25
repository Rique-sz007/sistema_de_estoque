package application;
import dao.ProductDAO;
import database.DB;
import entities.Category;
import  dao.CategoryDAO;
import entities.Product;
import exceptions.CategoryNotFoundException;
import services.ProductService;
import exceptions.ProductAlreadyExistsException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) throws SQLException {
        ProductDAO DAO = new ProductDAO();
        CategoryDAO dao = new CategoryDAO();
        ProductService productService = new ProductService(DAO);
        List<Product> products = productService.listarProduto();

        for (Product product : products) {
            System.out.println("Codígo: " +product.getCodigo());
            System.out.println("Nome: " +product.getNome());
            System.out.println("Preço: " +product.getPreco());
            System.out.println("Estoque: " +product.getEstoque());
            System.out.println("Categoria: " +product.getCategoria().getNome());
            System.out.println();
        }








       /* try {
            Category categoria = new Category(999, "Acessório");
            Product produto = new Product(null, "teste04", "produto de teste 4", 80.00, 5, categoria);
            productService.cadastrarProduto(produto);
            System.out.println("Produto cadastrado com sucesso!!");
        }
        catch (ProductAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        catch (CategoryNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("Ocorreu um erro ao cadastrar produto." + e.getMessage());
            System.out.println("Detalhes técnicos: " + e.getMessage());
        }
        //dao.delete(999);

        /*dao.update(2, "POO2", "Mouse", 75.00, 15, 3);

         List<Product> products = dao.products();
        for (Product pdc  : products) {
            System.out.println("Código: " + pdc.getCodigo());
            System.out.println("Nome: " + pdc.getNome());
            System.out.println("Preço: " + pdc.getPreco());
            System.out.println("Estoque: " + pdc.getEstoque());
            System.out.println("Category: " + pdc.getCategoria().getNome());
            System.out.println();
        }*/




    }
}
