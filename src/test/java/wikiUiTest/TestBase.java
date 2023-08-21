package wikiUiTest;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public class TestBase  {

    protected RemoteWebDriver driver;

    @Before
    @Step("Запуск драйвера и сесии")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        if (Platform.getInstance().isMw()) {
            this.openWikiWebPageForMobileWeb();
        }

    }

    @After
    @Step("Закрытие драйвера и сесии")
    public void tearDown() {
        driver.quit();
    }

    protected void openWikiWebPageForMobileWeb(){
        if (Platform.getInstance().isMw()){
            driver.get("https://en.m.wikipedia.org");
        }
        else{
            System.out.println("Method openWikiWebPageForMobileWeb() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }





}
