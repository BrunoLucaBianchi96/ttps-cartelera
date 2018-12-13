package utils;

import model.Token;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

public class TokenMarshaller implements Marshaller<Token> {


    @Override
    public JSONObject toJson(Token object) {
        JSONObject json = new JSONObject();
        if(object != null){
            json.put("id", object.getId());
            json.put("token", object.getToken());
        }
        return json;
    }

    @Override
    public Token toObject(String json) {
        JSONObject jsonObject = new JSONObject(json);
        Token token = new Token();
        token.setId(jsonObject.optInt("id"));
        token.setToken(jsonObject.optString("token"));
        return token;
    }
}
