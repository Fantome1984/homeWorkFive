package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import wikiUiTest.Helper;

public class MainPage extends Helper {


    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    private String searchBox = "org.wikipedia:id/search_container";
    private String buttonSavedList = "org.wikipedia:id/nav_tab_reading_lists";






    public void clickSearchBox(){
        super.elementClick(By.id(searchBox),"element searchBox not found");
    }


    public void clickTapBarButtonSaved(){
        super.elementClick(By.id(buttonSavedList),"element buttonSavedList not found");

    }
}
