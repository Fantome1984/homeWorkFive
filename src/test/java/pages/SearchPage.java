package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import wikiUiTest.Helper;

import java.util.Locale;

public class SearchPage extends Helper {

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }



    private String searchText ="org.wikipedia:id/search_src_text";
    private static String serchResultBySubstring_tpl ="//android.widget.TextView[@text='{SUBSTRING}']";
    private String testTitile = "//android.view.View[@bounds='[42,821][913,994]']";
    private String searchResult = "//*[@resource-id='org.wikipedia:id/fragment_search_results']";
    private String closeButton ="org.wikipedia:id/search_close_btn";
    private String backButton = "//android.widget.ImageButton[@content-desc='Navigate up']";
    private static String serchResultsBySubstring_tpl = "//androidx.recyclerview.widget.RecyclerView//*[@text='{SUBSTRINGONE}']/following-sibling::android.widget.TextView[@text='{SUBSTRINGTWO}']";


    private static String getResultSearchElement(String substring){
        return serchResultBySubstring_tpl.replace("{SUBSTRING}",substring);
    }
    private static String getResultSearchElements(String substringOne,String substringTwo){
        return serchResultsBySubstring_tpl.replace("{SUBSTRINGONE}", substringOne).replace("{SUBSTRINGTWO}",substringTwo);
    }



    public void enteringASearchValue(String text){
        super.enteringAValue(By.id(searchText),text,"element searchText not found");

    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        super.assertElementPresent(By.xpath(search_result_xpath),"Статья не найдена");

    }

    public void waitForElementByTitleAndDescription(String title,String description){
       String search_result_xpath1 = getResultSearchElements(title,description);
       super.elementVisibility(By.xpath(search_result_xpath1),"element search_result_xpath1 not found ");
    }

    public void сlickOnArticle(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        super.elementClick(By.xpath(search_result_xpath),"search_result_xpath not found");

    }


    public void сheckSearchResult(){
        super.elementVisibility(By.xpath(searchResult),"element search_Result not found");
        super.assertElementPresent(By.xpath(searchResult),"Ничего не найдено");
    }

    public void clickCloseButton(){
        super.elementClick(By.id(closeButton),"element closeButton not found");
    }
    public void searchCancelCheck(){
        super.waitForElementNotPresent(By.id(closeButton));
    }

    public void clickButtonBack(){
        super.elementClick(By.xpath(backButton), "element backButton not found");
    }

}
