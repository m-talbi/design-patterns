package creational.factory;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        StorageFactory factory = new StorageFactory();
        Storage jsonStorage = factory.createStorage("json");
        jsonStorage.createFile("myJsonFile");
        var data = new JSONObject();
        data.put("name", "peter");
        data.put("age", 28);
        jsonStorage.save(data.toString());
    }
}
