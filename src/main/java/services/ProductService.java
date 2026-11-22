package services;

import dao.ProductDAO;
import entities.Product;
import exceptions.CategoryNotFoundException;
import exceptions.ProductAlreadyExistsException;

import java.sql.SQLException;

public class ProductService {
    private ProductDAO productDAO;


    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;

    }
    public void cadastrarProduto(Product produto)  throws SQLException, ProductAlreadyExistsException, CategoryNotFoundException{
        try {
            productDAO.inserir(produto);
        }
        catch (SQLException e) {
            if (e.getErrorCode() == 1452) {
                throw new CategoryNotFoundException("A categoria informada não existe. Verifique o cadastro.");
            }
            else if (e.getErrorCode() == 1062) {
                throw new ProductAlreadyExistsException("Esse produto já foi cadastrado!");
                }

            }


        }




    }



