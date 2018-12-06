package utils;

import model.Billboard;
import org.json.JSONObject;

import java.util.Date;

public class BillboardMarshaller implements Marshaller<Billboard>  {
    @Override
    public JSONObject toJson(Billboard object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("createdAt", object.getCreated_at().getTime());
        jsonObject.put("updatedAt", object.getUpdated_at().getTime());
        jsonObject.put("name", object.getName());
        jsonObject.put("id", object.getId());
        return jsonObject;
    }

    @Override
    public Billboard toObject(String json) {
        JSONObject jsonObject = new JSONObject(json);
        Billboard billboard = new Billboard();
        billboard.setId(jsonObject.optInt("id"));
        billboard.setName(jsonObject.optString("Name"));
        Integer createdAt = jsonObject.optInt("createdAt");
        Integer updatedAt = jsonObject.optInt("updatedAt");
        billboard.setCreated_at(createdAt == null ? new Date() : new Date(createdAt));
        billboard.setUpdated_at(updatedAt == null ? new Date() : new Date(updatedAt));

        return billboard;
    }
}
