package spring.config.controllers;

import model.DAO.UserDAO;
import model.User;
import model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.config.AppConfig;

@RestController
public class TestController {

    @Autowired
    private UserDAO userRepository;

    @RequestMapping("/test")
    public String test(){
//        userRepository.save(new User());
        return this.userRepository.getUserByEmail("juannferrari@gmail.com").getName();
    }

    @RequestMapping("/add-user")
    public String addUser(){
        return "ok";
    }
}
