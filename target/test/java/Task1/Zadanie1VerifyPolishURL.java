package Task1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Zadanie1VerifyPolishURL extends TestCore{
    private VerifyPageInPolish language;

    @BeforeClass
    public void initPageObject() {
        language = new VerifyPageInPolish(getDriver(), getWait());
        PageFactory.initElements(getDriver(), language);
    }

    @Test(priority = 0)
    public void changeToPolishLanguage() {
        language.changeToPolishLanguage();
    }

    @Test(priority = 1)
    public void chooseLanguagePolish() {
        language.chooseLanguagePolish();
    }
    @Test(priority = 2)
    public void moveMouseToClothesSectionInPolish() {
        language.moveMouseToClothesSectionInPolish();
    }

    @Test(priority = 3)
    public void goToWomenClothesPageInPolish() {
        language.goToWomenClothesPageInPolish();
    }

    @Test(priority = 4)
    public void verifyUrlWomenPageInPolish() {
        language.verifyUrlWomenPageInPolish();
    }

}
