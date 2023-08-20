package pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;
import pages.StartPage;
import pages.androidPageObgect.AndroidMainPage;
import pages.androidPageObgect.AndroidStartPage;
import pages.iosPageObgect.IosMainPage;
import pages.iosPageObgect.IosStartPage;
import wikiUiTest.Platform;

public class StartPageFactories {

    public static StartPage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()) {
            return new AndroidStartPage(driver);
        }
        else{
            return new IosStartPage(driver);
        }
    }
}
