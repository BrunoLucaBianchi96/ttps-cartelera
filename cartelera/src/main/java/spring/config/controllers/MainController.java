package spring.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import spring.config.services.TokenService;

public class MainController {

    @Autowired
    private TokenService tokenService;

    public Boolean checkCredentials(String token, int user_id){
        return this.tokenService.checkIfExists(token, user_id);
    }

}
