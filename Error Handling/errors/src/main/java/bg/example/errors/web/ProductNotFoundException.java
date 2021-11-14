package bg.example.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "Product not found !")
public class ProductNotFoundException extends RuntimeException{


    private Long productId;

    public ProductNotFoundException(Long productId) {
        super("Cannot find product with id: " + productId);
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
