package spring.config.controllers;

import model.Billboard;
import model.DAO.UserDAO;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.TokenService;
import spring.config.services.UserService;
import utils.BillboardMarshaller;
import utils.Marshaller;
import utils.UserMarshaller;

import javax.xml.ws.Response;
import java.util.List;


@RestController
public class UserController extends MainController {

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
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
            User user = service.getUserById(id);
            if (user != null) {
                return userMarshaller.toJson(user).toString();
            } else {
                return "No user for that id";
            }
    }

    @GetMapping("/users")
    public String getUserByEmail(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @RequestParam(name = "email") String email
    ) {
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
            User user = service.getUserByEmail(email);
            if (user != null) {
                return userMarshaller.toJson(user).toString();
            } else {
                return "No user for that email";
            }
    }

    @GetMapping("/users/all")
    public String getAllUsers(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id
    ) {
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
            List<User> users = service.getAll();
            JSONArray arr = new JSONArray();
            for (User user : users) {
                JSONObject userJson = userMarshaller.toJson(user);
                arr.put(userJson);
            }
            return arr.toString();
    }

    @PostMapping("/users")
    public String createUser(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @RequestBody String json
    ) {

        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
            User user = userMarshaller.toObject(json);
            try {
                service.save(user);
            } catch (Exception e) {
                return "Could not save user. " + e.getStackTrace();
            }
            return "ok";
    }


    @PutMapping("users/{id}")
    public String updateUser(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @RequestBody String json
    ) {
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
            User user = userMarshaller.toObject(json);
            try {
                service.update(user);
            } catch (Exception e){
                return "Could not update user. " + e.getStackTrace();
            }
            return "ok";
    }

    @GetMapping("/users/{id}/carteleras/")
    public String getBillboardsForUser(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @PathVariable("id") Integer id
    ) {
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
            List<Billboard> billboards = service.getBillboardsOfUser(id);
            JSONArray arr = new JSONArray();
            BillboardMarshaller marshaller = new BillboardMarshaller();
            for( Billboard billboard: billboards){
                JSONObject userJson = marshaller.toJson(billboard);
                arr.put(userJson);
            }
            return arr.toString();
    }
}

