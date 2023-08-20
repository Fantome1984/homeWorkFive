package pages.androidPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.ArticlePage;

public class AndroidArticalePage extends ArticlePage {

    public AndroidArticalePage(RemoteWebDriver driver) {
        super(driver);
    }
    static {
          testTitile = "xpath://android.view.View[@bounds='[42,821][913,994]']";
          buttonSave = "id:org.wikipedia:id/page_save";
          save_Menu_tpl = "xpath://android.widget.TextView[@text='{SUBSTRING}']";
          createNewReadingList = "xpath://android.widget.TextView[@text='Create new']";
          fieldNameNewReadingList = "id:org.wikipedia:id/text_input";
          buttonOk = "id:android:id/button1";
          сreatedReadingList = "xpath://android.widget.TextView[@text='Saved articles']";
          backButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }
}

