package wikiUiTest;

import org.junit.jupiter.api.Test;
import pages.*;

public class ArticleSavingTest extends TestBase{

    @Test
    public void testSavingArticles(){
        StartPage startPage =  new StartPage(driver);
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ArticlePage articlePage = new ArticlePage(driver);
        SavedArticlePage savedArticlePage = new SavedArticlePage(driver);

        startPage.ckickButtonSkip();
        mainPage.clickSearchBox();
        searchPage.enteringASearchValue("java");
        searchPage.сlickOnArticle("High-level programming language");
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
}
