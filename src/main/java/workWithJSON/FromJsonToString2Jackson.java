package workWithJSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FromJsonToString2Jackson {

    //https://stackabuse.com/converting-json-array-to-a-java-array-or-list/

    public static void main(String[] args) {

        File file = new File("src/main/resources/student.json");
        var a = getAllPeople(file);
        a.forEach(System.out::println);

        System.out.println("-------------");

        var b = getAllIdOfPeople(file);
        b.forEach(System.out::println);

    }

    public static List<People> getAllPeople(File jsonFile) {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<People> langList;
        try {
            langList = objectMapper.readValue(
                    new File(jsonFile.toURI()),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return langList;
    }

    public static List<Integer> getAllIdOfPeople(File jsonFile) {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<People> id;
        try {
            id = objectMapper.readValue(
                    new File(jsonFile.toURI()),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return id.stream().map(People::getId).toList();
    }
}
