package pages.iosPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;

public class IosMainPage extends MainPage {
    public IosMainPage(RemoteWebDriver driver) {
        super(driver);
    }


    static{
        searchBox="";
                buttonSavedList="";
                buttonMenu="";
                buttonWatchList="";
}
}
