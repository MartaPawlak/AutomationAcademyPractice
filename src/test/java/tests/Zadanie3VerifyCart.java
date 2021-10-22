package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class Zadanie3VerifyCart extends TestCore {
    private VerifyPageInEnglish page;
    private GoToQuickView view;
    private CheckAddingToCartPopup cartPopup;
    private VerifyCart cartCheck;
    private DeleteItems delete;
    private ContinueShopping backShopping;

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
        delete = new DeleteItems(getDriver());
        PageFactory.initElements(getDriver(), delete);
        backShopping = new ContinueShopping(getDriver());
        PageFactory.initElements(getDriver(), backShopping);

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
    public void showQuickView() {
        test = extent.createTest("Test Case 2", "showQuickView");
        view.showQuickView();
    }

    @Test(priority = 3)
    public void addQuantity() {
        test = extent.createTest("Test Case 3", "addQuantity");
        view.addQuantity(2);
    }

    @Test(priority = 4)
    public void addToCart() {
        test = extent.createTest("Test Case 4", "addToCart");
        view.addToCartButton();
    }

    @Test(priority = 5)
    public void proceedToCheckout() {
        test = extent.createTest("Test Case 5", "proceedToCheckout");
        cartPopup.proceedToCheckout();
    }

    @Test(priority = 6)
    public void verifyCartTotalPrice() {
        test = extent.createTest("Test Case 6", "verifyCartTotalPrice");
        cartCheck.verifyCartTotalPrice();
    }

    @Test(priority = 7)
    public void summaryTotalPrice() {
        test = extent.createTest("Test Case 7", "summaryTotalPrice");
        cartCheck.summaryTotalPrice();
    }

    @Test(priority = 8)
    public void verifyTotalPrice() {
        test = extent.createTest("Test Case 8", "verifyTotalPrice");
        cartCheck.verifyTotalPrice();
    }

    @Test(priority = 9)
    public void checkItemQuantityTimesItemPrice() {
        test = extent.createTest("Test Case 9", "checkItemQuantityTimesItemPrice");
        cartCheck.checkItemQuantityTimesItemPrice();
    }

    @Test(priority = 10)
    public void deleteItemsFromCart() {
        test = extent.createTest("Test Case 10", "deleteItemsFromCart");
        delete.deleteItemsFromCart();
    }

    @Test(priority = 11)
    public void checkIfIsNoItem() {
        test = extent.createTest("Test Case 11", "checkIfIsNoItem");
        delete.checkIfIsNoItem();
    }

    @Test(priority = 12)
    public void getBackContinueShopping() {
        test = extent.createTest("Test Case 12", "getBackContinueShopping");
        backShopping.getBackContinueShopping();
    }

    @Test(priority = 13)
    public void checkURLMainPage() {
        test = extent.createTest("Test Case 13", "checkURLMainPage");
        backShopping.checkURLMainPage();
    }
}
