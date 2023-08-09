package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import wikiUiTest.Helper;

public class SavedArticlePage extends Helper {
    public SavedArticlePage(AppiumDriver driver) {
        super(driver);
    }

    private String сreatedReadingList ="//android.widget.TextView[@text='Saved articles']";

    private String serchResultOne ="//android.widget.TextView[@text='High-level programming language']";
     private String serchResultTwo ="//android.widget.TextView[@text='Java (programming language)']";
    private String articlesTitile = "//android.view.View[@bounds='[42,821][913,908]']";

    public void clickPageSavedArticle(){
        super.elementClick(By.xpath(сreatedReadingList),"ellement сreatedReadingList not found" );
    }

    public void deleteArticle(){
        super.swipeElementToLeft(By.xpath(serchResultTwo),"Не удалось осуществить свайп");
    }

    public void chekDeleteArticle(){
        super.assertElementNotPresent(By.xpath(serchResultTwo),"Статья не удалена");
    }
    public void checkingSavedArticle(String expected){
        super.elementVisibility(By.xpath(serchResultOne),"ellement serchResultOne not found");
        super.elementClick(By.xpath(serchResultOne),"ellement serchResultOne not found");
        super.assertElementHasText(By.xpath(articlesTitile),expected,"Заголовок не соответсвует ожидаемому");
    }



}
