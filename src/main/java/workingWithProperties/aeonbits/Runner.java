package workingWithProperties.aeonbits;

import org.aeonbits.owner.ConfigFactory;

public class Runner {
    public static void main(String[] args) {
        var config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.browser());
        System.out.println(config.browserType());
        System.out.println(config.value());
        System.out.println(config.takescreenshot());
    }
}
