package workWithJSON;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.Arrays;

public class JSONPath {
    public static void main(String[] args) {
        var file = new File("src/main/resources/student.json");
        JsonPath jsonPath = new JsonPath(file);
        var a = jsonPath.get("id").toString();
        var b = jsonPath.getList("id", Integer.class);
        b.forEach(System.out::println);
    }
}
