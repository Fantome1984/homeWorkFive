package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import wikiUiTest.Helper;

public class AuthPageObgect extends Helper {
    private static final String
            LOGIN_BUTTON="xpath://a[@type='button']",
            LOGIN_INPUT="css:#wpName1",
            PASSWORD_INPUT="css:#wpPassword1",
            SUBMIT_BUTTON="css:#wpLoginAttempt";



    public AuthPageObgect(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton(){
        this.elementClick(LOGIN_BUTTON,"element LOGIN_BUTTON is not found");
    }

    public void enterLoginData(String login,String password){
        this.enteringAValue(LOGIN_INPUT,login,"element LOGIN_INPUT is not found");
        this.enteringAValue(PASSWORD_INPUT,password,"element LOGIN_INPUT is not found");
    }
    public void clickSubmitButton(){
        this.elementClick(SUBMIT_BUTTON,"element SUBMIT_BUTTON is not found");
    }



}
