package spring.config;

import model.DAO.UserDAO;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.UserService;
import utils.UserMarshaller;

import javax.xml.ws.Response;
import java.util.List;


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
            return userMarshaller.toJson(user).toString();
        } else {
            return "No user for that email";
        }

    }

    @GetMapping("/users/all")
    public String getAllUsers(
    ) {
        List<User> users = service.getAll();
        JSONArray arr = new JSONArray();
        for( User user : users){
            JSONObject userJson = userMarshaller.toJson(user);
            arr.put(userJson);
        }
        return arr.toString();

    }

    @PostMapping("/users")
    public String createUser(
            @RequestBody String json
    ) {
        //Todo: handle sad case :(

        User user = userMarshaller.toObject(json);
        try {
            service.save(user);
        } catch (Exception e){
            return "Could not save user. " + e.getStackTrace();
        }
        return "ok";
    }
}
