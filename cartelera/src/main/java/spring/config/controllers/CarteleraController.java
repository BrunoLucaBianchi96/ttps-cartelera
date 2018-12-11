package spring.config.controllers;

import model.Billboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import spring.config.services.BillboardService;
import spring.config.services.TokenService;
import utils.BillboardMarshaller;

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
    ){
        if (!this.tokenService.checkIfExists(token, user_id)) {
            return "401 - Token mismatch";
        }

        Billboard billboard = this.billboardMarshaller.toObject(json);
        billboardService.save(billboard);
        return "ok";
    }
}
