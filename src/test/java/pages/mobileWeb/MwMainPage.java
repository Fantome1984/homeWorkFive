package pages.mobileWeb;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;

public class MwMainPage extends MainPage {

    static {
         searchBox ="css:button#searchIcon";
         buttonMenu="css:#mw-mf-main-menu-button";
        buttonWatchList="xpath://a[@data-event-name='menu.watchlist']";
    }




    public MwMainPage(RemoteWebDriver driver) {
        super(driver);
    }



}
