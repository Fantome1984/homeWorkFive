package pages.mobileWeb;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SavedArticlePage;

public class MwSavedArticlePage extends SavedArticlePage {

    static  {
        сreatedReadingList="";
                serchResultOne="xpath://li[@class='page-summary with-watchstar']";
                serchResultTwo="xpath://li[@class='page-summary with-watchstar'][2]//a[2]";
                articlesTitile="xpath://ul[@class='content-unstyled page-list thumbs page-summary-list mw-mf-watchlist-page-list']";


    }

    public MwSavedArticlePage(RemoteWebDriver driver) {
        super(driver);
    }
}
