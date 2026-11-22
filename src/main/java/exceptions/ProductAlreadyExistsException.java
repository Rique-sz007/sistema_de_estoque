package exceptions;

import dao.ProductDAO;

public class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException(String mensagem) {
        super(mensagem);

    }



}
