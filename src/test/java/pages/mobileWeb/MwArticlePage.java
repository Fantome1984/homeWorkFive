package pages.mobileWeb;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.ArticlePage;

public class MwArticlePage extends ArticlePage {

    static {
        testTitile="css:#firstHeading";
        OPTION_REMOVE_MY_LIST_BUTTON="xpath://span[@class='mw-ui-icon mw-ui-icon-wikimedia-unStar-progressive']";
        buttonSave="xpath://span[@class='mw-ui-icon mw-ui-icon-wikimedia-star-base20']";
    }


    public MwArticlePage(RemoteWebDriver driver) {
        super(driver);
    }
}
