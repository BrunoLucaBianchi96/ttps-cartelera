package spring.config;

import model.DAO.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.UserService;
import utils.UserMarshaller;

import javax.xml.ws.Response;


@RestController
public class UserResource {

    @Autowired
    private UserService service;


    private UserMarshaller userMarshaller = new UserMarshaller();

    @GetMapping("/users/{id}")
    public User getUserById(
            @PathVariable("id") Integer id
    ) {
        User user = service.getUserById(id);
        if(user!= null){
            return user;
        } else {
            return new User();
        }

    }

    @GetMapping("/users")
    public String getUserByEmail(
            @RequestParam(name = "email") String email
    ) {
        User user = service.getUserByEmail(email);
        if(user!= null){
            return userMarshaller.toJson(user);
        } else {
            return "No user for that email";
        }

    }

    @PostMapping("/users")
    public String createUser(
            @RequestBody String json
    ) {
        //Todo: handle sad case :(
        User user = userMarshaller.toObject(json);
        service.save(user);
        return "ok";
    }
}
