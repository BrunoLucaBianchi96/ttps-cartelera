package utils;

import model.User;
import org.json.JSONObject;

import java.sql.Date;

public class UserMarshaller  {

    public static String toJson(User user){
        JSONObject json = new JSONObject();
        if(user!= null){
            json.put("id", user.getId());
            json.put("name", user.getName());
            json.put("lastName", user.getLastName());
            json.put("notificationType", user.getNotificationType());
            json.put("createdAt", user.getCreated_at().getTime());
            json.put("updatedAt", user.getUpdated_at());
        }
        return json.toString();
    }

    public static User toObject(String json){
        JSONObject jsonObject = new JSONObject(json);
        User user = new User();
        user.setId(jsonObject.optInt("id"));
        user.setName(jsonObject.optString("name"));
        user.setLastName(jsonObject.optString("lastName"));
        user.setNotificationType(jsonObject.optString("notificationType"));
        user.setCreated_at(new Date(jsonObject.optInt("createdAt")));
        return user;
    }
}
