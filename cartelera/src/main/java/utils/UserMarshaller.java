package utils;

import model.User;
import org.json.JSONObject;

public class UserMarshaller  {

    public static String toJson(User user){
        JSONObject json = new JSONObject();
        if(user!= null){
            json.put("id", user.getId());
            json.put("name", user.getName());
        }

        return json.toString();
    }
}
