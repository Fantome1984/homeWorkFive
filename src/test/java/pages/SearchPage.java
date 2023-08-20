package pages;
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



    public void enteringASearchValue(String text){
        super.enteringAValue((searchText),text,"element searchText not found");

    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        super.assertElementPresent((search_result_xpath),"Статья не найдена");

    }

    public void waitForElementByTitleAndDescription(String title,String description){
       String search_result_xpath1 = getResultSearchElements(title,description);
       super.elementVisibility((search_result_xpath1),"element search_result_xpath1 not found ");
    }

    public void сlickOnArticle(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        super.elementClick((search_result_xpath),"search_result_xpath not found");

    }


    public void сheckSearchResult(){
        super.elementVisibility((searchResult),"element search_Result not found");
        super.assertElementPresent((searchResult),"Ничего не найдено");
    }

    public void clickCloseButton(){
        super.elementClick((closeButton),"element closeButton not found");
    }
    public void searchCancelCheck(){
        super.waitForElementNotPresent((closeButton));
    }

    public void clickButtonBack(){
        super.elementClick((backButton), "element backButton not found");
    }

}
