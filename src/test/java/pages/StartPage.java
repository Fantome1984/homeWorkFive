package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikiUiTest.Helper;
 abstract public class StartPage extends Helper {
    public StartPage(RemoteWebDriver driver) {
        super(driver);
    }


     protected static String buttonSkip;




        public void ckickButtonSkip(){
            this.elementClick((buttonSkip),"Не найдена кнопка пропуска");
        }

    }

