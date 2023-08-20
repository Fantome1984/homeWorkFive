package pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.ArticlePage;
import pages.MainPage;
import pages.androidPageObgect.AndroidArticalePage;
import pages.androidPageObgect.AndroidMainPage;
import pages.iosPageObgect.IosArticalePage;
import pages.iosPageObgect.IosMainPage;
import pages.mobileWeb.MwMainPage;
import wikiUiTest.Platform;

public class MainPageFactories {

    public static MainPage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMainPage(driver);
        }
        else if (Platform.getInstance().isIos()){
            return new IosMainPage(driver);
        }
        else{
            return new MwMainPage(driver);
        }
    }
}
