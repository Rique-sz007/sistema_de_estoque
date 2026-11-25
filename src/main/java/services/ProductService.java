package services;

import dao.ProductDAO;
import entities.Product;
import exceptions.CategoryNotFoundException;
import exceptions.ProductAlreadyExistsException;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;


    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;

    }
    public void cadastrarProduto(Product produto)  throws SQLException, ProductAlreadyExistsException, CategoryNotFoundException {
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
            else {
                throw  e;
            }

            }
        }

        public List<Product> listarProduto() throws SQLException  {
        return productDAO.products();
        }
        public void atualizarProduto(Product product) throws SQLException {

        productDAO.update(
                product.getId(),
                product.getCodigo(),
                product.getNome(),
                product.getPreco(),
                product.getEstoque(),
                product.getCategoria().getId());

        }




    }



