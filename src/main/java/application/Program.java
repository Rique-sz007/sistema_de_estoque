package application;
import dao.ProductDAO;
import database.DB;
import entities.Category;
import  dao.CategoryDAO;
import entities.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) throws SQLException {

        ProductDAO dao = new ProductDAO();

        List<Product> products = dao.products();
        for (Product pdc  : products) {
            System.out.println("Código " + pdc.getCodigo());
            System.out.println("Nome " + pdc.getNome());
            System.out.println("Preço " + pdc.getPreco());
            System.out.println("Estoque " + pdc.getEstoque());
            System.out.println();
        }




    }
}
