package wikiUiTest;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.*;
import pages.factories.*;
@Epic("Тесты на сохранение статей")

public class ArticleSavingTest extends TestBase {


    private String login = "NikitaShletkin";
    private String password = "57570000Vks";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Features(value = {@Feature("Поиск"),@Feature("Сохранение статьи"),@Feature("Удаление статьи")})
    @DisplayName("Сохранение и удаление статьи из избранного")
    @Description("Кликаем на кнопку поиска, вводим поисковое значение,переходим в статью, " +
            "добавлем ее в избранное, переходим во вторую статью, так же добавлем ее в избранное, " +
            "переходим в избранное, удаляем сатьтю, проеряем удаление статьи и сохрание оставшейся статьи ")
    @Step("Старт теста testAssertTitile")
    public void testSavingArticles() throws InterruptedException {
        StartPage startPage = StartPageFactories.get(driver);
        MainPage mainPage = MainPageFactories.get(driver);
        SearchPage searchPage = SearchPageFactories.get(driver);
        ArticlePage articlePage = ArticlePageFactories.get(driver);
        SavedArticlePage savedArticlePage = SavedArticlePageFactories.get(driver);
        AuthPageObgect authPageObgect = new AuthPageObgect(driver);

        if (Platform.getInstance().isAndroid()){
            startPage.ckickButtonSkip();
            mainPage.clickSearchBox();
            searchPage.enteringASearchValue("java");
            searchPage.сlickOnArticle("igh-level programming language");
            articlePage.clickButtonSave();
            articlePage.clickButtonSave();
            articlePage.сlickMenuSaveArticle("Add to another reading list");
            articlePage.createNewReadingList("Saved articles");
            articlePage.clickButtonBack();
            searchPage.сlickOnArticle("Java (programming language)");
            articlePage.clickButtonSave();
            articlePage.clickButtonSave();
            articlePage.сlickMenuSaveArticle("Add to another reading list");
            articlePage.clickReadingList();
            articlePage.clickButtonBack();
            searchPage.clickButtonBack();
            mainPage.clickTapBarButtonSaved();
            savedArticlePage.clickPageSavedArticle();
            savedArticlePage.deleteArticle();
            savedArticlePage.chekDeleteArticle();
            savedArticlePage.checkingSavedArticle("JavaScript");
        }
        else if (Platform.getInstance().isMw()){
            mainPage.clickSearchBox();
            searchPage.enteringASearchValue("java");
            searchPage.сlickOnArticle("igh-level programming language");
           articlePage.clickButtonSave();
            authPageObgect.clickAuthButton();
            authPageObgect.enterLoginData(login,password);
            authPageObgect.clickSubmitButton();
            articlePage.checkTitile();
            mainPage.clickSearchBox();
            searchPage.enteringASearchValue("java");
            searchPage.сlickOnArticle("bject-oriented programming language");
            articlePage.clickButtonSave();
            mainPage.clickMenuButton();
            mainPage.clickMenuButtonWatchList();
            savedArticlePage.deleteArticle();
            savedArticlePage.refreshPage();
            savedArticlePage.chekDeleteArticle();
            savedArticlePage.chekArticle();
        }


    }
}
