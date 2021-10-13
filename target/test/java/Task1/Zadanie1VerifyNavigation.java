package Task1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Zadanie1VerifyNavigation extends TestCore {
    private VerifyPageInEnglish page;


    @BeforeClass
    public void initPageObject() {
        page = new VerifyPageInEnglish(getDriver(), getWait());
        PageFactory.initElements(getDriver(), page);
    }

        @Test(priority = 0)
    public void moveMouseToClothesSection() {
        page.moveMouseToClothesSection();
    }

    @Test(priority = 1)
    public void goToWomenClothesPage() {
        page.goToWomenClothesPage();
    }

    @Test(priority = 2)
    public void verifyUrl() {
        page.verifyUrlWomenPage();
    }
}

