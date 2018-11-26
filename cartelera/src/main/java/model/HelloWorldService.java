package model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component("helloWorldService")
public class HelloWorldService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "Hello! " + name;
    }
}