package wikiUiTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.MainPage;
import pages.SearchPage;
import pages.StartPage;
import pages.factories.ArticlePageFactories;
import pages.factories.MainPageFactories;
import pages.factories.SearchPageFactories;
import pages.factories.StartPageFactories;

public class SearchTest extends TestBase {


    StartPage startPage = StartPageFactories.get(driver);



    @Test
    public void testAssertTitile(){
        StartPage startPage = StartPageFactories.get(driver);
        MainPage mainPage = MainPageFactories.get(driver);
        SearchPage searchPage = SearchPageFactories.get(driver);
        ArticlePage articlePage = ArticlePageFactories.get(driver);
        if (Platform.getInstance().isAndroid()){startPage.ckickButtonSkip();}
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.сlickOnArticle("bject-oriented programming language");
        articlePage.checkTitile();
    }


    @Test
    public void testCancelSearch(){
        StartPage startPage = StartPageFactories.get(driver);
        MainPage mainPage = MainPageFactories.get(driver);
        SearchPage searchPage  = SearchPageFactories.get(driver);

        if (Platform.getInstance().isAndroid()){startPage.ckickButtonSkip();}
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.сheckSearchResult();
        searchPage.clickCloseButton();
        searchPage.searchCancelCheck();
    }

    @Test
    public void testChekTitileAndDescription(){
        StartPage startPage = StartPageFactories.get(driver);
        MainPage mainPage = MainPageFactories.get(driver);
        SearchPage searchPage =  SearchPageFactories.get(driver);
        startPage.ckickButtonSkip();
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.waitForElementByTitleAndDescription("Java (programming language)","Object-oriented programming language");
        searchPage.waitForElementByTitleAndDescription("JavaScript","High-level programming language");
        searchPage.waitForElementByTitleAndDescription("Java version history","List of versions of the Java programming language");
    }

}
