package bg.example.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/products/{id}/details")
    public String getDetails(@PathVariable("id") long productId) {
        // productRepo.findById(productId).orElseThrow(new ProductNotFoundExcep);
        throw new ProductNotFoundException(productId);
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ModelAndView handleDbExceptions(ProductNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("product-not-found");
        modelAndView.addObject("productId", e.getProductId());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }


}

