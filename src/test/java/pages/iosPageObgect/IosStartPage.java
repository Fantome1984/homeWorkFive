package pages.iosPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.StartPage;

public class IosStartPage extends StartPage {
    public IosStartPage(RemoteWebDriver driver) {
        super(driver);
    }


    static {
         buttonSkip = "id:org.wikipedia:id/fragment_onboarding_skip_button";
    }
}
