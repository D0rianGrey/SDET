package podam;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import podam_pojo_data_maker.entity.Employee;
import podam_pojo_data_maker.entity.Student;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.File;
import java.io.IOException;

public class DemoTest {
    File file = new File(System.getProperty("user.dir") + "/src/main/resources/student.json");

    @Test
    public void test1() throws IOException {
        PodamFactory factory = new PodamFactoryImpl();
        var student = factory.manufacturePojo(Student.class);
        System.out.println(student);

        var student1 = new ObjectMapper().readValue(file, Student.class);
        System.out.println(student1);

        var student2 = factory.populatePojo(student1);
        System.out.println(student2);
    }

    @Test
    public void test2() {
        PodamFactory factory = new PodamFactoryImpl();
        var employee = factory.manufacturePojo(Employee.class, String.class);
        System.out.println(employee);
    }
}
