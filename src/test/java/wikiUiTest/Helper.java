package wikiUiTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class Helper{

    protected RemoteWebDriver driver;

    public Helper(RemoteWebDriver driver){this.driver = driver;}


    public WebElement elementVisibility(String locator, String error_messege){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement elementClick(String locator, String error_messege){
        WebElement element = elementVisibility(locator,error_messege);
        element.click();
        return element;
    }

    public WebElement assertElementHasText(String locator, String expected, String error){
        WebElement element = elementVisibility(locator,error);
        String actual = element.getAttribute("text");
        Assert.assertEquals(expected,actual,error);
        return element;
    }

    public WebElement enteringAValue(String locator, String text,String error_messege){
        WebElement element = elementVisibility(locator,error_messege);
        element.sendKeys(text);
        return element;
    }


    public boolean waitForElementNotPresent(String locator){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver,15);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void swipeUp(){

        if (driver instanceof AppiumDriver){
            TouchAction action = new TouchAction((AppiumDriver)driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width/2;
            int start_y = (int)(size.height*0.8);
            int end_y = (int)(size.height*0.2);
            action.press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).
                    moveTo(PointOption.point(x,end_y)).release().perform();}
        else {
            System.out.println("Method swipeUp() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void quickSwipeUp(){
        swipeUp();

    }

    public void swipeUpToElement(String locator,String error_messege,int max_swipes){
        By by = this.getLocatorByString(locator);
        int alredy_swipe = 0;
        while (driver.findElements(by).size()==0){
            if(alredy_swipe>max_swipes){
                waitForElementNotPresent(locator);
                return;
            }
            quickSwipeUp();
            ++alredy_swipe;
        }

    }

    public void swipeElementToLeft(String locator, String error_messege){

        if (driver instanceof AppiumDriver||Platform.getInstance().isAndroid()){
            WebElement element = elementVisibility(locator,error_messege);
            int left_x = element.getLocation().getX();
            int rigth_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y+element.getSize().getHeight();
            int middle_y =(upper_y+lower_y)/2;
            TouchAction action = new TouchAction((AppiumDriver)driver);
            action.press(PointOption.point(rigth_x,middle_y)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                    .moveTo(PointOption.point(left_x,middle_y)).release()
                    .perform();
        }
        else if (Platform.getInstance().isMw()){
            elementClick(locator,error_messege);
        }
        else System.out.println("Method swipeElementToLeft() do nothing for platform " + Platform.getInstance().getPlatformVar());

    }

    public int chekAmmountElement(String locator){
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(String locator,String error_messege){
        int ammount_of_elements = chekAmmountElement(locator);
        if (ammount_of_elements >0){
            String defaultErrorMessege ="An Element "  +locator+" supposted be not present ";
            throw new AssertionError(defaultErrorMessege + " " + error_messege);
        }

    }

    public void assertElementPresent(String locator, String error_messege){
        int ammount_of_elements = chekAmmountElement(locator);
        Assert.assertTrue(error_messege,ammount_of_elements>0);
    }

    private By getLocatorByString(String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")){
            return By.xpath(locator);
        }
        else if (by_type.equals("id")){
            return By.id(locator);
        }
        else if (by_type.equals("css")){
            return By.cssSelector(locator);
        }
        else {
            throw new IllegalArgumentException("Cannot get tupe of locator. Locator " + locator_with_type);
        }


    }
    public void scrollWebPageUp(){
        if(Platform.getInstance().isMw()){
            JavascriptExecutor JsExecutor=(JavascriptExecutor) driver;
            JsExecutor.executeScript("window.scrollBY(0,250)");
        }
        else System.out.println("Method scrollWebPageUp do nothing for platform " + Platform.getInstance().getPlatformVar());
    }

    public boolean isElementPresent(String locator){
        return chekAmmountElement(locator)>0;

    }

    public String takeScrrenshot(String name){
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File sourse = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/"+name+"_screenshot.png";
        try {
            FileUtils.copyFile(sourse, new File(path));
            System.out.println("The screensot was taken: "+path);
        }
        catch (Exception e){
            System.out.println("Cannot take screenshot. Error: "+e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path){
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        }
        catch (IOException e){
            System.out.println("Cannot get bytes from screenshot. Error: "+e.getMessage());
        }
        return bytes;
    }




}


