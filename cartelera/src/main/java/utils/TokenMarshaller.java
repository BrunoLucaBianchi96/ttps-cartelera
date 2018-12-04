package utils;

import model.Token;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

public class TokenMarshaller implements Marshaller<Token> {


    @Override
    public String toJson(Token object) {
        JSONObject json = new JSONObject();
        if(object != null){
            json.put("id", object.getId());
            json.put("name", object.getToken());
        }
        return json.toString();
    }

    @Override
    public Token toObject(String json) {
        JSONObject jsonObject = new JSONObject(json);
        Token token = new Token();
        token.setId(jsonObject.optInt("id"));
        token.setToken(jsonObject.optString("name"));
        return token;
    }
}
