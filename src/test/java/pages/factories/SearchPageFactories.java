package pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SearchPage;
import pages.androidPageObgect.AndroidSearchPage;
import pages.iosPageObgect.IosSearchPage;
import pages.mobileWeb.MwSearchPage;
import wikiUiTest.Platform;

public class SearchPageFactories {
    public static SearchPage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPage(driver);
        }
        else if (Platform.getInstance().isIos()){
            return new IosSearchPage(driver);
        }
        else{
            return new MwSearchPage(driver);
        }
    }
}
