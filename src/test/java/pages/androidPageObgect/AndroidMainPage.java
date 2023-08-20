package pages.androidPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;

public class AndroidMainPage extends MainPage {
    public AndroidMainPage(RemoteWebDriver driver) {
        super(driver);
    }
    static {
         searchBox="id:org.wikipedia:id/search_container";
        buttonSavedList="xpath://android.widget.ImageView[@bounds='[292,1636][355,1699]']";
                buttonMenu="";
                buttonWatchList="";
    }
}
