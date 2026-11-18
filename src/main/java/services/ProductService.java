package services;

import dao.ProductDAO;
import entities.Product;

import java.sql.SQLException;

public class ProductService {
    private ProductDAO productDAO;


    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;

    }
    public void cadastrarProduto(Product produto)  throws SQLException {

        productDAO.inserir(produto);


    }


}
