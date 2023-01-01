package workWithJSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SimpleJsonPractice {

    @Test(dataProvider = "dp")
    public void test(String array) {
        System.out.println(array);
    }

    public static void main(String[] args) {
        var file = new File("src/main/resources/student.json");
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(file)) {
            var obj = jsonParser.parse(fileReader);

            var jsonObj = (JSONObject) obj;

            var country = (String) jsonObj.get("country");
            System.out.println(country);

            var peopleArray = (JSONArray) jsonObj.get("people");
            for (Object o : peopleArray) {
                var jsonObject = (JSONObject) o;

                var firstName = (String) jsonObject.get("firstName");
                var id = (Integer) jsonObject.get("id");
                System.out.println(id);
            }


        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "dp")
    public String[] readJson() throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("src/main/resources/student.json"));
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray arrayOfFirstNames = (JSONArray) jsonObj.get("people");
        String[] arr = new String[arrayOfFirstNames.size()];

        for (var i = 0; i < arrayOfFirstNames.size(); i++) {
            JSONObject jsonObject = (JSONObject) arrayOfFirstNames.get(i);
            String firstName = (String) jsonObject.get("firstName");
            arr[i] = firstName;
        }
        return arr;
    }
}
