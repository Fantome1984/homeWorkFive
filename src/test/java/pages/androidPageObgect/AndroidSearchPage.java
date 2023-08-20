package pages.androidPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SearchPage;

public class AndroidSearchPage extends SearchPage {
    public AndroidSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {

         searchText = "id:org.wikipedia:id/search_src_text";
          serchResultBySubstring_tpl = "xpath://android.widget.TextView[contains(@text='{SUBSTRING})']";
          testTitile = "xpath://android.view.View[@bounds='[42,821][913,994]']";
         searchResult = "xpath://*[@resource-id='org.wikipedia:id/fragment_search_results']";
          closeButton = "id:org.wikipedia:id/search_close_btn";
          backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
          serchResultsBySubstring_tpl = "xpath://androidx.recyclerview.widget.RecyclerView//*[@text='{SUBSTRINGONE}']/following-sibling::android.widget.TextView[@text='{SUBSTRINGTWO}']";
    }
}
