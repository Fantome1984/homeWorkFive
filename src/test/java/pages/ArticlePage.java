package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikiUiTest.Helper;
import wikiUiTest.Platform;

abstract public class ArticlePage extends Helper {

    public ArticlePage(RemoteWebDriver driver) {
        super(driver);
    }
protected static String
     testTitile,
     buttonSave,
        save_Menu_tpl,
     createNewReadingList,
     fieldNameNewReadingList,
     buttonOk,
        сreatedReadingList,
      backButton,
    OPTION_REMOVE_MY_LIST_BUTTON;


    public void checkTitile(){
        super.assertElementPresent(testTitile,"Заголовок не найден");

    }

    public void clickButtonSave(){
        if (Platform.getInstance().isMw()){
            this.removeArticalFromSaveIfAdded();
        }

        super.elementClick((buttonSave),"element buttonSave not found");
    }


    private static String getMenuSaveElement(String substring){
        return save_Menu_tpl.replace("{SUBSTRING}",substring);
    }


    public void сlickMenuSaveArticle(String substring){
        String search_result_xpath = getMenuSaveElement(substring);
        super.elementClick(search_result_xpath,"element search_result_xpath not found");
    }

    public void createNewReadingList(String nameReadingList){
        super.elementClick((createNewReadingList),"element createNewReadingList not found");
        super.enteringAValue((fieldNameNewReadingList),nameReadingList,"element fieldNameNewReadingList not found");
        super.elementClick((buttonOk),"element buttonOk not found");
    }

    public void clickButtonBack(){
        if (Platform.getInstance().isAndroid()){
            super.elementClick((backButton),"element backButton not found");
        }
         else System.out.println("Method clickButtonBack do nothing for platform " + Platform.getInstance().getPlatformVar());
    }

    public void clickReadingList(){
        super.elementClick((сreatedReadingList),"element сreatedReadingList not found");
    }

    public void removeArticalFromSaveIfAdded(){
        if (this.isElementPresent(OPTION_REMOVE_MY_LIST_BUTTON)){
            this.elementClick(OPTION_REMOVE_MY_LIST_BUTTON,"element OPTION_REMOVE_MY_LIST_BUTTON not found");
        }
        this.elementVisibility(buttonSave,"element buttonSave not found");
    }










}


