package wikiUiTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_IOS="ios";
    private static final String PLATFORM_ANDROID="android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String PLATFORM_MOBILE_WEB ="mobile_web";


    private static Platform instance;

    private Platform(){};

    public static Platform getInstance(){
        if (instance==null){
            instance=new Platform();
        }
        return instance;
    }


   public RemoteWebDriver getDriver()throws Exception{
       URL URL = new URL(APPIUM_URL);
       if (this.isAndroid()){
           return new AndroidDriver<>(URL,getAndroidDesiredCapabilities());
       }
       else if (this.isIos()){
           return new IOSDriver<>(URL,getIosDesiredCapabilities());
       }
       else if (this.isMw()) {
           return new ChromeDriver(this.getMwChromeOptions());
       }
       else throw new Exception("Cannot detect type of the driver. Platform value"+this.getPlatformVar());
   }


    public boolean isAndroid(){
        return isPlatform(PLATFORM_ANDROID);
    }



    public boolean isIos(){
        return isPlatform(PLATFORM_IOS);
    }

    public boolean isMw(){
        return isPlatform(PLATFORM_MOBILE_WEB);
    }



    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Em");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\nsshletkin\\Downloads\\homeWorkTwo\\src\\main\\java\\apks\\Wikipedia_2.7.50446-r-2023-06-28_Apkpure.apk");
        capabilities.setCapability("orientation", "PORTRAIT");
        return capabilities;

    }
    private DesiredCapabilities getIosDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPohone SE");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("app", "C:\\Users\\nsshletkin\\Downloads\\homeWorkTwo\\src\\main\\java\\apks\\Wikipedia.app");
        capabilities.setCapability("orientation", "PORTRAIT");
        return capabilities;

    }

    private boolean isPlatform(String my_platform){
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private ChromeOptions getMwChromeOptions(){
        Map<String,Object> deviceMetriks = new HashMap<String,Object>();
        deviceMetriks.put("width",360);
        deviceMetriks.put("heigth",640);
        deviceMetriks.put("pixelRatio",3.0);
        Map<String,Object> mobileEmulation = new HashMap<String,Object>();
        mobileEmulation.put("deviceMetriks",deviceMetriks);
        mobileEmulation.put("userAgent","Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=360,640");
        return chromeOptions;




    }

    public String getPlatformVar(){
        return System.getenv("PLATFORM");
    }
}
