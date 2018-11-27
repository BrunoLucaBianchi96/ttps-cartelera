package spring.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @RequestMapping("/hello")
    public String hello(
            @RequestParam(value = "name", defaultValue = "Bruno") String name
    ){
        return "Hello "+ name;
    }
}
