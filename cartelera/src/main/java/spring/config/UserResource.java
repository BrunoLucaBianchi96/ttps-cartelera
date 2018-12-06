package spring.config;

import model.DAO.UserDAO;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.TokenService;
import spring.config.services.UserService;
import utils.UserMarshaller;

import javax.xml.ws.Response;
import java.util.List;


@RestController
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private TokenService tokenService;


    private UserMarshaller userMarshaller = new UserMarshaller();

    @GetMapping("/users/{id}")
    public String getUserById(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @PathVariable("id") Integer id
    ) {
        if (this.tokenService.checkIfExists(token, user_id)) {
            User user = service.getUserById(id);
            if (user != null) {
                return userMarshaller.toJson(user).toString();
            } else {
                return "No user for that id";
            }
        } else {
            return "401 - Token mismatch";
        }
    }

    @GetMapping("/users")
    public String getUserByEmail(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @RequestParam(name = "email") String email
    ) {
        if (this.tokenService.checkIfExists(token, user_id)) {
            User user = service.getUserByEmail(email);
            if (user != null) {
                return userMarshaller.toJson(user).toString();
            } else {
                return "No user for that email";
            }
        } else {
            return "401 - Token mismatch";
        }
    }

    @GetMapping("/users/all")
    public String getAllUsers(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id
    ) {
        if (this.tokenService.checkIfExists(token, user_id)) {
            List<User> users = service.getAll();
            JSONArray arr = new JSONArray();
            for (User user : users) {
                JSONObject userJson = userMarshaller.toJson(user);
                arr.put(userJson);
            }
            return arr.toString();
        } else {
            return "401 - Token mismatch";
        }
    }

    @PostMapping("/users")
    public String createUser(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @RequestBody String json
    ) {
        //Todo: handle sad case :(
        if (this.tokenService.checkIfExists(token, user_id)) {
            User user = userMarshaller.toObject(json);
            try {
                service.save(user);
            } catch (Exception e) {
                return "Could not save user. " + e.getStackTrace();
            }
            return "ok";
        } else {
            return "401 - Token mismatch";
        }
    }

}