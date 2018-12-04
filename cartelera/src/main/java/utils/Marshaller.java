package utils;

public interface Marshaller<T> {

    public String toJson(T object);
    public T toObject(String json);

}
