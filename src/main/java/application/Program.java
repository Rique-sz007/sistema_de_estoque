package application;
import dao.ProductDAO;
import database.DB;
import entities.Category;
import  dao.CategoryDAO;
import entities.Product;
import services.ProductService;

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


        try {
            Category categoria = new Category(1, "Acessórios");
            Product produto =  new Product(null, "teste03", "produto de teste 3", 80.00, 5, categoria);

            productService.cadastrarProduto(produto);
            System.out.println("Produto cadastrado com sucesso!!");
        }
        catch (SQLException e) {
            if (e.getErrorCode() == 1452) {
                System.out.println("A categoria informada não existe. Verifique o cadastro.");
            }
            else if (e.getErrorCode() == 1062) {
                System.out.println("Esse produto já foi cadastrado!");
            }
            else {
                System.out.println("Ocorreu um erro ao cadastrar o produto.");
            }

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
