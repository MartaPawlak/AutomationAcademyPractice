package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckAddingToCartPopup;
import pages.GoToQuickView;
import pages.VerifyCart;
import pages.VerifyPageInEnglish;

public class Zadanie2VerifyCheckout extends TestCore {
    private VerifyPageInEnglish page;
    private GoToQuickView view;
    private CheckAddingToCartPopup cartPopup;
    private VerifyCart cartCheck;

    public void ChangeTestName() {
        setTestName(getClass().getName());
    }

    @BeforeClass
    public void initPageObject() {
        page = new VerifyPageInEnglish(getDriver(), getWait());
        PageFactory.initElements(getDriver(), page);
        view = new GoToQuickView(getDriver(), getWait());
        PageFactory.initElements(getDriver(), view);
        cartPopup = new CheckAddingToCartPopup(getDriver(), getWait());
        PageFactory.initElements(getDriver(), cartPopup);
        cartCheck = new VerifyCart(getDriver());
        PageFactory.initElements(getDriver(), cartCheck);
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
    public void getSizeList() {
        test = extent.createTest("Test Case 2", "getSizeList");
        page.getList();
    }

    @Test(priority = 3)
    public void chooseSize() {
        test = extent.createTest("Test Case 3", "chooseSize");
        page.chooseSize();
    }

    @Test(priority = 4)
    public void verifyActiveFilters() {
        test = extent.createTest("Test Case 4", "verifyActiveFilters");
        page.checkActiveFilters();
    }

    @Test(priority = 5)
    public void showQuickView() {
        test = extent.createTest("Test Case 5", "showQuickView");
        view.showQuickView();
    }

    @Test(priority = 6)
    public void addQuantity() {
        test = extent.createTest("Test Case 6", "addQuantity");
        view.addQuantity(1);
    }

    @Test(priority = 7)
    public void addToCart() {
        test = extent.createTest("Test Case 7", "addToCart");
        view.addToCartButton();
    }

    @Test(priority = 8)
    public void showList() {
        test = extent.createTest("Test Case 8", "showList");
        cartPopup.getQuantity();
    }

    @Test(priority = 9)
    public void getPrice() {
        test = extent.createTest("Test Case 9", "getPrice");
        cartPopup.getPrice();
    }

    @Test(priority = 10)
    public void getTotalPrice() {
        test = extent.createTest("Test Case 10", "getTotalPrice");
        cartPopup.getTotalPrice();
    }

    @Test(priority = 11)
    public void verifyTotalPrice() {
        test = extent.createTest("Test Case 11", "verifyTotalPrice");
        cartPopup.verifyTotalPrice();
    }

    @Test(priority = 12)
    public void proceedToCheckout() {
        test = extent.createTest("Test Case 12", "proceedToCheckout");
        cartPopup.proceedToCheckout();
    }

}

