package podam_pojo_data_maker.strategy;

import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public class NameStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue(Class<?> aClass, List<Annotation> list) {
        //as example faker here
        return Stream.of("Testing", "Automation", "Testingminibytes")
                .findAny()
                .orElseThrow();
    }
}
