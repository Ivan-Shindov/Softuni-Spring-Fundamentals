package bg.example.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {

        // some logic...
        if (true) {
            throw new NullPointerException("Exception !");
        }


        return "test";
    }

}
