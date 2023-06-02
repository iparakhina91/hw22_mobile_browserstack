package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", authConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getKey());

        mutableCapabilities.setCapability("app", mobileConfig.getApp());

        mutableCapabilities.setCapability("device", mobileConfig.getDevice());
        mutableCapabilities.setCapability("os_version", mobileConfig.getVersion());

        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL(authConfig.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
