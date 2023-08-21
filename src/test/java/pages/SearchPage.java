package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import wikiUiTest.Helper;
abstract public class SearchPage extends Helper {

 public SearchPage(RemoteWebDriver driver) {
        super(driver);
    }


     protected static String
      searchText,
    serchResultBySubstring_tpl,
      testTitile,
      searchResult,
      closeButton,
      backButton,
     serchResultsBySubstring_tpl;


    private static String getResultSearchElement(String substring){
        return serchResultBySubstring_tpl.replace("{SUBSTRING}",substring);
    }
    private static String getResultSearchElements(String substringOne,String substringTwo){
        return serchResultsBySubstring_tpl.replace("{SUBSTRINGONE}", substringOne).replace("{SUBSTRINGTWO}",substringTwo);
    }


     @Step("Вводим значение в поле поиска {text}")
    public void enteringASearchValue(String text){
        super.enteringAValue((searchText),text,"element searchText not found");

    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        super.assertElementPresent((search_result_xpath),"Статья не найдена");

    }
    @Step("Проеряем заголовок и описание")
    public void waitForElementByTitleAndDescription(String title,String description){
        screenshot(this.takeScrrenshot("articale.titile"));
       String search_result_xpath1 = getResultSearchElements(title,description);
       super.elementVisibility((search_result_xpath1),"element search_result_xpath1 not found ");
    }
    @Step("Кликаем по статье")
    public void сlickOnArticle(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        super.elementClick((search_result_xpath),"search_result_xpath not found");

    }

    @Step("Проверяем поисковую выдачу")
    public void сheckSearchResult(){
        super.elementVisibility((searchResult),"element search_Result not found");
        super.assertElementPresent((searchResult),"Ничего не найдено");
    }

    @Step("Кликаем на кнопку отмены поиска")

    public void clickCloseButton(){
        super.elementClick((closeButton),"element closeButton not found");
    }

    @Step("Проеряем отсутсвие кнопки отмены поиска")
    public void searchCancelCheck(){
        super.waitForElementNotPresent((closeButton));
    }

    public void clickButtonBack(){
        super.elementClick((backButton), "element backButton not found");
    }

}
