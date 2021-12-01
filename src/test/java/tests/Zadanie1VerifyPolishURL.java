package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.VerifyPageInPolish;

public class Zadanie1VerifyPolishURL extends TestCore {
    private VerifyPageInPolish language;

    @BeforeClass
    public void initPageObject() {
        language = new VerifyPageInPolish(getDriver(), getWait());
        PageFactory.initElements(getDriver(), language);
    }

    @Test(priority = 0)
    public void changeToPolishLanguage() {
        test = extent.createTest("Test Case 0", "changeToPolishLanguage");
        language.changeToPolishLanguage();
    }

    @Test(priority = 1)
    public void chooseLanguagePolish() {
        test = extent.createTest("Test Case 1", "chooseLanguagePolish");
        language.chooseLanguagePolish();
    }

    @Test(priority = 2)
    public void moveMouseToClothesSectionInPolish() {
        test = extent.createTest("Test Case 2", "moveMouseToClothesSectionInPolish");
        language.moveMouseToClothesSectionInPolish();
    }

    @Test(priority = 3)
    public void goToWomenClothesPageInPolish() {
        test = extent.createTest("Test Case 3", "goToWomenClothesPageInPolish");
        language.goToWomenClothesPageInPolish();
    }

    @Test(priority = 4)
    public void verifyUrlWomenPageInPolish() {
        test = extent.createTest("Test Case 4", "verifyUrlWomenPageInPolish");
        language.verifyUrlWomenPageInPolish();
    }

}
