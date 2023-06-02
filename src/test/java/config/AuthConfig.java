package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/auth.properties",
        "system:properties"
})

public interface AuthConfig extends Config {

    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getKey();

    @Key("remoteUrl")
    String getRemoteUrl();
}
