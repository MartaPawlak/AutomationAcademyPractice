package Task1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Zadanie3VerifyCart  extends TestCore {
    private VerifyPageInEnglish page;
    private GoToQuickView view;
    private CheckAddingToCartPopup cartPopup;
    private VerifyCart cartCheck;
    private DeleteItems delete;
    private ContinueShopping backShopping;

    @BeforeClass
    public void initPageObject () {
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
        page.moveMouseToClothesSection();
    }

    @Test(priority = 1)
    public void goToWomenClothesPage() {
        page.goToWomenClothesPage();
    }

    @Test(priority = 2)
    public void showQuickView() {
        view.showQuickView();
    }

    @Test(priority = 3)
    public void addQuantity() {
        view.addQuantity(2);
    }

    @Test(priority = 4)
    public void addToCart() {
        view.addToCartButton();
    }

    @Test(priority = 5)
    public void proceedToCheckout() {
        cartPopup.proceedToCheckout();
    }

    @Test(priority = 6)
    public void verifyCartTotalPrice() {
        cartCheck.verifyCartTotalPrice();
    }

    @Test(priority = 7)
    public void summaryTotalPrice() {
        cartCheck.summaryTotalPrice();
    }

    @Test(priority = 8)
    public void verifyTotalPrice() {
        cartCheck.verifyTotalPrice();
    }

    @Test(priority = 9)
    public void checkItemQuantityTimesItemPrice() {
        cartCheck.checkItemQuantityTimesItemPrice();
    }

    @Test(priority = 10)
    public void deleteItemsFromCart() {
        delete.deleteItemsFromCart();
    }

    @Test(priority = 11)
    public void checkIfIsNoItem() {
        delete.checkIfIsNoItem();
    }

    @Test(priority = 12)
    public void getBackContinueShopping() {
        backShopping.getBackContinueShopping();
    }

    @Test(priority = 13)
    public void checkURLMainPage() {
        backShopping.checkURLMainPage();
    }
}
