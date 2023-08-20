package pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;
import pages.SavedArticlePage;
import pages.androidPageObgect.AndroidMainPage;
import pages.androidPageObgect.AndroidSavedAricalePage;
import pages.iosPageObgect.IosMainPage;
import pages.iosPageObgect.IosSavedAricalePage;
import pages.mobileWeb.MwSavedArticlePage;
import wikiUiTest.Platform;

public class SavedArticlePageFactories {

    public static SavedArticlePage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSavedAricalePage(driver);
        }
        else if (Platform.getInstance().isIos()){
            return new IosSavedAricalePage(driver);
        }
        else return new MwSavedArticlePage(driver);
    }
}
