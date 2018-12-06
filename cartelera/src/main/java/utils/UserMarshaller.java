package utils;

import model.User;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Date;


public class UserMarshaller implements Marshaller<User> {

    @Override
    public JSONObject toJson(User user){

        JSONObject json = new JSONObject();
        if(user!= null){
            json.put("id", user.getId());
            json.put("name", user.getName());
            json.put("lastName", user.getLastName());
            json.put("notificationType", user.getNotificationType());
            json.put("createdAt", user.getCreated_at().getTime());
            json.put("updatedAt", user.getUpdated_at());
        }
        return json;
    }
    @Override
    public User toObject(String json){
        JSONObject jsonObject = new JSONObject(json);
        User user = new User();
        user.setEmail(jsonObject.getString("email"));
        user.setId(jsonObject.optInt("id"));
        user.setName(jsonObject.optString("name"));
        user.setLastName(jsonObject.optString("lastName"));
        user.setNotificationType(jsonObject.optString("notificationType"));
        Integer createdAt = jsonObject.optInt("createdAt");
        Date createdAtDate = (createdAt != null) ? new Date(createdAt) : (new Date());
        user.setCreated_at(createdAtDate);
        return user;
    }
}
