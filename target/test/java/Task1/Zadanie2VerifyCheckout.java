package Task1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Zadanie2VerifyCheckout extends TestCore {
        private VerifyPageInEnglish page;
        private GoToQuickView view;
        private CheckAddingToCartPopup cartPopup;
        private VerifyCart cartCheck;

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
        public void getSizeList() {
            page.getList();
        }

        @Test(priority = 3)
        public void chooseSize() {
            page.chooseSize();
        }

        @Test(priority = 4)
        public void verifyActiveFilters() {
            page.checkActiveFilters();
        }

        @Test(priority = 5)
        public void showQuickView() {
            view.showQuickView();
        }

        @Test(priority = 6)
        public void addQuantity() {
            view.addQuantity(1);
        }

        @Test(priority = 7)
        public void addToCart() {
            view.addToCartButton();
        }

        @Test(priority = 8)
        public void showList() {
            cartPopup.getQuantity();
        }

        @Test(priority = 9)
        public void getPrice() {
            cartPopup.getPrice();
        }

        @Test(priority = 10)
        public void getTotalPrice() {
            cartPopup.getTotalPrice();
        }

        @Test(priority = 11)
        public void verifyTotalPrice() {
            cartPopup.verifyTotalPrice();
        }

        @Test(priority = 12)
        public void proceedToCheckout() {
            cartPopup.proceedToCheckout();
        }

}