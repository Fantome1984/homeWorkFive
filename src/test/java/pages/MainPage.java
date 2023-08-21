package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikiUiTest.Helper;
import wikiUiTest.Platform;

abstract public class MainPage extends Helper {


    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }


   protected static String
      searchBox,
      buttonSavedList,
      buttonMenu,
    buttonWatchList;









     @Step("Кликаем на кнопку поиска")
    public void clickSearchBox(){
        super.elementClick((searchBox),"element searchBox not found");
    }
    @Step("Кликаем по кнопке сохраненных статей")
    public void clickTapBarButtonSaved(){
        super.elementClick((buttonSavedList),"element buttonSavedList not found");

    }
    @Step("Кликаем по кнопке меню")
    public void clickMenuButton(){
        if (Platform.getInstance().isMw()){
            super.elementClick(buttonMenu,"element buttonMenu not found");
        }
        else System.out.println("Method clickMenuButton do nothing for platform " + Platform.getInstance().getPlatformVar());
    }
    @Step("Кликаем по кнопке перехода на страницу сохраненных статей")
    public void clickMenuButtonWatchList(){
        if (Platform.getInstance().isMw()){
            super.elementClick(buttonWatchList,"element buttonMenu not found");
        }
        else System.out.println("Method clickMenuButtonWatchList do nothing for platform " + Platform.getInstance().getPlatformVar());

    }

}
