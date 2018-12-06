package utils;

import org.json.JSONObject;

public interface Marshaller<T> {

    public JSONObject toJson(T object);
    public T toObject(String json);

}
