package pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.ArticlePage;
import pages.SearchPage;
import pages.androidPageObgect.AndroidArticalePage;
import pages.androidPageObgect.AndroidSearchPage;
import pages.iosPageObgect.IosArticalePage;
import pages.iosPageObgect.IosSearchPage;
import pages.mobileWeb.MwArticlePage;
import wikiUiTest.Platform;

public class ArticlePageFactories {
    public static ArticlePage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticalePage(driver);
        }
        else if (Platform.getInstance().isIos()){
            return new IosArticalePage(driver);
        }
        else {
            return new MwArticlePage(driver);
        }
    }
}
