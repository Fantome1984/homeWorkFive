package pages.iosPageObgect;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SavedArticlePage;

public class IosSavedAricalePage extends SavedArticlePage {
    public IosSavedAricalePage(RemoteWebDriver driver) {
        super(driver);
    }


    static {

      сreatedReadingList ="xpath://android.widget.TextView[@text='Saved articles']";
      serchResultOne ="xpath://android.widget.TextView[@text='High-level programming language']";
      serchResultTwo ="xpath://android.widget.TextView[@text='Java (programming language)']";
      articlesTitile = "xpath://android.view.View[@bounds='[42,821][913,908]']";
}
}

