package podam_pojo_data_maker.entity;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import podam_pojo_data_maker.strategy.NameStrategy;
import uk.co.jemos.podam.common.PodamCollection;
import uk.co.jemos.podam.common.PodamIntValue;
import uk.co.jemos.podam.common.PodamStrategyValue;
import uk.co.jemos.podam.common.PodamStringValue;

import java.util.List;
import java.util.Map;

@Data
public class Student {

    @PodamIntValue(minValue = 0, maxValue = 100)
    private int id;

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
