package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import wikiUiTest.Helper;

public class ArticlePage extends Helper {

    public ArticlePage(AppiumDriver driver) {
        super(driver);
    }

    private String testTitile = "//android.view.View[@bounds='[42,821][913,994]']";
    private String buttonSave = "org.wikipedia:id/page_save";
    private static String save_Menu_tpl ="//android.widget.TextView[@text='{SUBSTRING}']";
    private String createNewReadingList = "//android.widget.TextView[@text='Create new']";
    private String fieldNameNewReadingList = "org.wikipedia:id/text_input";
    private String buttonOk="android:id/button1";
    private String сreatedReadingList ="//android.widget.TextView[@text='Saved articles']";
    private String backButton = "//android.widget.ImageButton[@content-desc='Navigate up']";


    public void checkTitile(){
        super.assertElementPresent(By.xpath(testTitile),"Заголовок не найден");

    }

    public void clickButtonSave(){
        super.elementClick(By.id(buttonSave),"element buttonSave not found");
    }


    private static String getMenuSaveElement(String substring){
        return save_Menu_tpl.replace("{SUBSTRING}",substring);
    }


    public void сlickMenuSaveArticle(String substring){
        String search_result_xpath = getMenuSaveElement(substring);
        super.elementClick(By.xpath(search_result_xpath),"element search_result_xpath not found");
    }

    public void createNewReadingList(String nameReadingList){
        super.elementClick(By.xpath(createNewReadingList),"element createNewReadingList not found");
        super.enteringAValue(By.id(fieldNameNewReadingList),nameReadingList,"element fieldNameNewReadingList not found");
        super.elementClick(By.id(buttonOk),"element buttonOk not found");
    }

    public void clickButtonBack(){
        super.elementClick(By.xpath(backButton),"element backButton not found");
    }

    public void clickReadingList(){
        super.elementClick(By.xpath(сreatedReadingList),"element сreatedReadingList not found");
    }










}


