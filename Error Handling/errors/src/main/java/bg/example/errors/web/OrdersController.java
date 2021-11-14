package bg.example.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrdersController {

    @GetMapping("/orders/{id}/details")
    public String getDetails(@PathVariable("id") long orderId) {
        // productRepo.findById(orderId).orElseThrow(new ProductNotFoundExcep);
        throw new ObjectNotFoundException(orderId);
    }


}
