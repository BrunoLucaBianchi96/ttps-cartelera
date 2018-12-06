package spring.config.controllers;


import model.Token;
import model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.UserService;
import utils.TokenMarshaller;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    private TokenMarshaller tokenMarshaller = new TokenMarshaller();

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@RequestHeader(name = "email") String email, @RequestHeader(name = "password") String password){
        Token token = this.userService.checkCredentials(email, password);
        return tokenMarshaller.toJson(token).toString();
    }

}
