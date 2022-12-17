package podam;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import podam_pojo_data_maker.entity.Student;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.File;
import java.io.IOException;

public class DemoTest {
    File file = new File(System.getProperty("user.dir") + "/src/test/resources/student.json");

    @Test
    public void test() throws IOException {
        System.out.println(1);
        PodamFactory factory = new PodamFactoryImpl();
        var student = factory.manufacturePojo(Student.class);
        System.out.println(student);

        var student1 = new ObjectMapper().readValue(file, Student.class);
        System.out.println(student1);
    }
}
