package pages;
import io.qameta.allure.Step;
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

    @Step("Кликаем по сохраненной странице")
    public void clickPageSavedArticle() {
        super.elementClick((сreatedReadingList), "ellement сreatedReadingList not found");
    }
    @Step("Удаляем статью")
    public void deleteArticle() {
        super.swipeElementToLeft((serchResultTwo), "Не удалось осуществить свайп");
    }


    @Step("Прверяем факт удаления статьи")
    public void chekDeleteArticle() {
        super.assertElementNotPresent((serchResultTwo), "Статья не удалена");
    }
    @Step("Проеряем оставшеюся статью по заголовку")
    public void checkingSavedArticle(String expected) {
        Platform.getInstance().isAndroid();
            super.elementVisibility((serchResultOne), "ellement serchResultOne not found");
            super.elementClick((serchResultOne), "ellement serchResultOne not found");
            super.assertElementHasText((articlesTitile), expected, "Заголовок не соответсвует ожидаемому");
        }
    @Step("Проеряем наличие оставшейся статьи")
        public void chekArticle(){
        if (Platform.getInstance().isMw()){
            this.elementVisibility( serchResultOne,"Статья удалена");
        }
        }
    @Step("Обновляем страницу")
        public void refreshPage(){
        if (Platform.getInstance().isMw()){
            driver.navigate().refresh();
        }
        else System.out.println("Method refreshPage do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }


