package pages.mobileWeb;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SearchPage;

public class MwSearchPage extends SearchPage {
    static{
         searchText = "css:form>input[type='search']";
         serchResultBySubstring_tpl = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
         testTitile = "xpath://android.view.View[@bounds='[42,821][913,994]']";
         searchResult = "css:ul.page-list>li.page-summary";
         closeButton = "xpath://div[@class='header-action']";
         backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
         serchResultsBySubstring_tpl = "xpath://androidx.recyclerview.widget.RecyclerView//*[@text='{SUBSTRINGONE}']/following-sibling::android.widget.TextView[@text='{SUBSTRINGTWO}']";
    }

    public MwSearchPage(RemoteWebDriver driver) {
        super(driver);
    }
}
