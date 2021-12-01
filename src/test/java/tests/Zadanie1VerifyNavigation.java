package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.VerifyPageInEnglish;

public class Zadanie1VerifyNavigation extends TestCore {
    private VerifyPageInEnglish page;


    @BeforeClass
    public void initPageObject() {
        page = new VerifyPageInEnglish(getDriver(), getWait());
        PageFactory.initElements(getDriver(), page);
    }

    @Test(priority = 0)
    public void moveMouseToClothesSection() {
        test = extent.createTest("Test Case 0", "moveMouseToClothesSection");
        page.moveMouseToClothesSection();
    }

    @Test(priority = 1)
    public void goToWomenClothesPage() {
        test = extent.createTest("Test Case 1", "goToWomenClothesPage");
        page.goToWomenClothesPage();
    }

    @Test(priority = 2)
    public void verifyUrl() {
        test = extent.createTest("Test Case 2", "verifyUrl");
        page.verifyUrlWomenPage();
    }
}

