package spring.config.controllers;

import model.Billboard;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.BillboardService;
import spring.config.services.TokenService;
import spring.config.services.UserService;
import utils.BillboardMarshaller;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CarteleraController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BillboardService billboardService;

    @Autowired
    private UserService userService;

    private BillboardMarshaller billboardMarshaller = new BillboardMarshaller();

    @PostMapping("/cartelera")
    public String createBillboard(
            @RequestHeader(name = "token") String token,
            @RequestHeader(name = "user_id") int user_id,
            @RequestBody String json
    ) {
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }
        if(!isAdmin(user_id)){
            return "401 - not Allowed";
        }

        Billboard billboard = this.billboardMarshaller.toObject(json);
        billboardService.save(billboard);
        return json;
    }

    private boolean isAdmin(int user_id) {
        List<Role> roles=this.userService.getUserById(user_id).getRoles();
        boolean isAdmin = false;
        for( Role each : roles){
            isAdmin = (each.getName().equals("ADMIN") || isAdmin);
        }
        return isAdmin;
    }

    @GetMapping("/cartelera")
    public String getAllBillboards() {
        List<Billboard> billboardList = billboardService.getAllBillboards();
        return billboardMarshaller.toJson(billboardList).toString();
    }

}
