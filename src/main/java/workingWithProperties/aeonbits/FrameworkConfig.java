package workingWithProperties.aeonbits;

import org.aeonbits.owner.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Config.Sources(value = "file:${user.dir}/src/main/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    String browser();

    BrowserType browserType();

    Long timeout();

    @Key("screen")
    boolean takescreenshot();

    List<String> favtools();

    @DefaultValue("SECONDS")
    TimeUnit value();
}
