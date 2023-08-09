package wikiUiTest;

import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.MainPage;
import pages.SearchPage;
import pages.StartPage;

public class SearchTest extends TestBase{


    @Test
    public void testAssertTitile(){
        StartPage startPage =  new StartPage(driver);
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ArticlePage articlePage = new ArticlePage(driver);

        startPage.ckickButtonSkip();
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.сlickOnArticle("Java (programming language)");
        articlePage.checkTitile();
    }


    @Test
    public void testCancelSearch(){
        StartPage startPage =  new StartPage(driver);
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        startPage.ckickButtonSkip();
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.сheckSearchResult();
        searchPage.clickCloseButton();
        searchPage.searchCancelCheck();
    }

    @Test
    public void testChekTitileAndDescription(){
        StartPage startPage =  new StartPage(driver);
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        startPage.ckickButtonSkip();
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.waitForElementByTitleAndDescription("Java (programming language)","Object-oriented programming language");
        searchPage.waitForElementByTitleAndDescription("JavaScript","High-level programming language");
        searchPage.waitForElementByTitleAndDescription("Java version history","List of versions of the Java programming language");
    }

}
