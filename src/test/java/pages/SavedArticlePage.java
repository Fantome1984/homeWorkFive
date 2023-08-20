package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikiUiTest.Helper;
import wikiUiTest.Platform;


import java.util.List;

abstract public class SavedArticlePage extends Helper {
    public SavedArticlePage(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            сreatedReadingList,
            serchResultOne,
            serchResultTwo,
            articlesTitile;


    public void clickPageSavedArticle() {
        super.elementClick((сreatedReadingList), "ellement сreatedReadingList not found");
    }

    public void deleteArticle() {
        super.swipeElementToLeft((serchResultTwo), "Не удалось осуществить свайп");
    }

    public void chekDeleteArticle() {
        super.assertElementNotPresent((serchResultTwo), "Статья не удалена");
    }

    public void checkingSavedArticle(String expected) {
        Platform.getInstance().isAndroid();
            super.elementVisibility((serchResultOne), "ellement serchResultOne not found");
            super.elementClick((serchResultOne), "ellement serchResultOne not found");
            super.assertElementHasText((articlesTitile), expected, "Заголовок не соответсвует ожидаемому");
        }
        public void chekArticle(){
        if (Platform.getInstance().isMw()){
            this.elementVisibility( serchResultOne,"Статья удалена");
        }
        }
        public void refreshPage(){
        if (Platform.getInstance().isMw()){
            driver.navigate().refresh();
        }
        else System.out.println("Method refreshPage do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }


