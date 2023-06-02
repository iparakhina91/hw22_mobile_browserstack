package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getKey();

    @Key("remoteUrl")
    String getRemoteUrl();
}
