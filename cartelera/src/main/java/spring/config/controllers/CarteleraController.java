package spring.config.controllers;

import model.Billboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.services.BillboardService;
import spring.config.services.TokenService;
import utils.BillboardMarshaller;

import java.util.List;

@RestController
public class CarteleraController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BillboardService billboardService;

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

        Billboard billboard = this.billboardMarshaller.toObject(json);
        billboardService.save(billboard);
        return "ok";
    }

    @GetMapping("/cartelera")
    public String getAllBillboards() {
        List<Billboard> billboardList = billboardService.getAllBillboards();
        return billboardMarshaller.toJson(billboardList).toString();
    }

}
