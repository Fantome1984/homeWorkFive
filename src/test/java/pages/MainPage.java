package pages;
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










    public void clickSearchBox(){
        super.elementClick((searchBox),"element searchBox not found");
    }

    public void clickTapBarButtonSaved(){
        super.elementClick((buttonSavedList),"element buttonSavedList not found");

    }
    public void clickMenuButton(){
        if (Platform.getInstance().isMw()){
            super.elementClick(buttonMenu,"element buttonMenu not found");
        }
        else System.out.println("Method clickMenuButton do nothing for platform " + Platform.getInstance().getPlatformVar());
    }
    public void clickMenuButtonWatchList(){
        if (Platform.getInstance().isMw()){
            super.elementClick(buttonWatchList,"element buttonMenu not found");
        }
        else System.out.println("Method clickMenuButtonWatchList do nothing for platform " + Platform.getInstance().getPlatformVar());

    }

}
