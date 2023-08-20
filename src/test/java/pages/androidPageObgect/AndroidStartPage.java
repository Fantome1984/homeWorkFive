package pages.androidPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.StartPage;

public class AndroidStartPage extends StartPage {

    public AndroidStartPage(RemoteWebDriver driver) {
        super(driver);
    }


    static {
          buttonSkip = "id:org.wikipedia:id/fragment_onboarding_skip_button";
    }
}
