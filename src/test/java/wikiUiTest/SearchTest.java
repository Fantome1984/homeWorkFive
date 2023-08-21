package wikiUiTest;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;;
import pages.ArticlePage;
import pages.MainPage;
import pages.SearchPage;
import pages.StartPage;
import pages.factories.ArticlePageFactories;
import pages.factories.MainPageFactories;
import pages.factories.SearchPageFactories;
import pages.factories.StartPageFactories;
@Epic("Тесты на поиск статей")

public class SearchTest extends TestBase {



    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка заголовка")
    @Description("Кликаем на кнопку поиска, вводим поисковое значение, проверяем заголовок")
    @Step("Старт теста testAssertTitile")
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
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отмена поиска")
    @Description("Кликаем на кнопку поиска, вводим поисковое значение,отменяем поиск,проверяем отсутствие кнопки отмены поиска")
    @Step("Старт теста testCancelSearch")
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
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка заголовка и описания")
    @Description("Кликаем на кнопку поиска, вводим поисковое значение,проверяем заголовок и описание")
    @Step("Старт теста testChekTitileAndDescription")
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
