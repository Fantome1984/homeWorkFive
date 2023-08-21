package pages;

import io.qameta.allure.Step;
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
    @Step("Кликаем на кнопку авторизации")
    public void clickAuthButton(){
        this.elementClick(LOGIN_BUTTON,"element LOGIN_BUTTON is not found");
    }
    @Step("Вводим учетные данные")
    public void enterLoginData(String login,String password){
        this.enteringAValue(LOGIN_INPUT,login,"element LOGIN_INPUT is not found");
        this.enteringAValue(PASSWORD_INPUT,password,"element LOGIN_INPUT is not found");
    }
    @Step("Кликаем на кнопку входа")
    public void clickSubmitButton(){
        this.elementClick(SUBMIT_BUTTON,"element SUBMIT_BUTTON is not found");
    }



}
