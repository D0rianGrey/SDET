package podam_pojo_data_maker.entity;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import podam_pojo_data_maker.strategy.NameStrategy;
import uk.co.jemos.podam.common.*;

import java.util.List;
import java.util.Map;

@Data
public class Student {

    @PodamExclude
    @PodamIntValue(minValue = 1, maxValue = 100)
    private int id;

    @PodamExclude
    @PodamStrategyValue(value = NameStrategy.class)
    @PodamStringValue(length = 6)
    private String firstName;
    private String lastName;
    private Address address;

    @PodamCollection(nbrElements = 2, collectionElementStrategy = NameStrategy.class)
    private List<String> jobs;

    @PodamCollection(nbrElements = 2)
    private Map<Integer, String> map;


}
