package workWithJSON;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FromJsonToString1 {

    public static void main(String[] args) {
        var file = "src/main/resources/student.json";

        var stringList = getValuesForGivenKeyByPathToFile(file, "id");
        stringList.forEach(System.out::println);
    }

    public static List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }

    public static List<String> getValuesForGivenKeyByPathToFile(String pathToFile, String key) {
        JSONArray jsonArray = new JSONArray(readFileAsString(pathToFile));
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }

    public static String readFileAsString(String file) {
        try {
            return new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
