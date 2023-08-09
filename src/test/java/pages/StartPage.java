package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import wikiUiTest.Helper;

public class StartPage extends Helper {
    public StartPage(AppiumDriver driver) {
        super(driver);
    }


    private String buttonSkip = "org.wikipedia:id/fragment_onboarding_skip_button";




        public void ckickButtonSkip(){
            this.elementClick(By.id(buttonSkip),"Не найдена кнопка пропуска");
        }

    }

