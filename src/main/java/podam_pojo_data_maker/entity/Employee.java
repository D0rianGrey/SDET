package podam_pojo_data_maker.entity;

import lombok.Data;

@Data
public class Employee<T> {
    private T name;
    private T lastName;
}
