package main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageTask {

    public SelenideElement
            adminPannelButton = $x("//*[@class='btn-outline']"),
            cartButton = $x("//*[@id='open-cart-btn']"),
            addToCartButton = $x("//*[@data-action='add-to-cart']"),
            increaseButton = $x("//button[text()='+']"),
                 closeCartButton = $x("//*[@id='close-modal']"),
            orderProcessingNotification = $x("//*[@class='toast']"),
            TotalPriceText = $x("//*[@id='total-price']"),
            orderAddToCartNotification = $x("//*[@class='toast']");

    public ElementsCollection
            productCardList = $$x("//*[contains(@id, 'card')]"),
            productNameList = $$x("//h4"),
            productPriceList = $$x("//div[@class='product-card']/h4/following-sibling::div[1]"),
            addToCartButtonList = $$x("//*[@data-action='add-to-cart']"),
            ProductPriceList = $$x("//*[@style='width:70px; text-align:right']"),
            productCountInputList = $$x("//*[@type='number']");

    public void clickAdminButton(){
        adminPannelButton.click();
    }


    public void clickCartButton(){
        cartButton.click();
    }

    public void clickAddtoCartButton(){
        addToCartButton.click();
    }
    public void clickIncreaseButton(){
        increaseButton.click();
    }
    public void clickCloseCartButton() {

        closeCartButton.click();
    }

    public void inputProductCount(int index, String text) {
        productCountInputList.get(index).clear();
        productCountInputList.get(index)
                .sendKeys(text);
    }
    public void inputAddToCartButtonList(int index) {
        addToCartButtonList.get(index)
                .click();
    }









    public class CartPopup {
        SelenideElement
                closeCartButton = $x("//*[@id='close-modal']"),
                makeOrderButton = $x("//*[@id='makeOrder']");


        ElementsCollection
                cartItemList = $$x("//*[contains(@id, 'cart-item-')]");

        public void clickCloseCartPopupButton() {
            closeCartButton.click();

        }
        public void clickmakeOrderButton() {
            makeOrderButton.click();

        }


    }

    public class AdminLoginForm {
        SelenideElement
                SignInButton = $x("//*[@type='submit']"),
                LoginField = $x("//*[@id='username']"),
                AllertText = $x("//*[@class='alert alert-danger']"),
                PasswordField = $x("//*[@id='password']"),
                ProductNameField = $x("//*[@id='n-name']"),
                ProductPriceField = $x("//*[@id='n-price']"),
                ProductAddButton = $x("//*[@id='add-btn']"),
                ProductHasAddedNotification = $x("//*[@class='toast']"),
                ProductHasUpdateNotification = $x("//*[@class='toast']"),
                ComeBackButton = $x("//*[contains(text(), 'Вернуться')]");



        ElementsCollection
                DeleteButtonList = $$x("//*[@class='btn btn-del']"),
                ProductNameList = $$x("//*[@type='text']"),
                ProductPriceList = $$x("//*[@type='number']"),
                SaveButtonList = $$x("//*[@class='btn btn-upd']");

        public void clickSignInButton() {
            SignInButton.click();

        }
        public void inputLogin(String login) {
            LoginField.sendKeys(login);

        }

        public void inputPassword(String password) {
            PasswordField.sendKeys(password);

        }

        public void CheckAllertText() {
            AllertText.shouldHave(text("Неверные учетные данные пользователя"));

        }

        public void CheckAllertVisible() {
            AllertText.should(visible);

        }
        public void CheckAllertIsNotVisible() {
            AllertText.shouldNot(visible);

        }
        public void clickSignInButtonIsVisible() {
            SignInButton.should(visible);
        }
        public void LoginFieldIsVisible() {
            LoginField.should(visible);
        }
        public void PasswordFieldIsVisible() {
            PasswordField.should(visible);
        }

        public void LoginFieldContainsText(String login) {
            LoginField.shouldHave(value(login));
        }

        public void PasswordFieldFieldContainsText(String password) {
            PasswordField.shouldHave(value(password));
        }

        public void ProductNameFieldIsVisible() {
            ProductNameField.should(visible);
        }
        public void ProductPriceFieldIsVisible() {
            ProductPriceField.should(visible);
        }
        public void ProductAddButtonIsVisible() {
            ProductAddButton.should(visible);
        }
        public void ComeBackButtonIsVisible() {
            ComeBackButton.should(visible);
        }
        public void ProductHasAddedNotificationIsVisible() {
            ProductHasAddedNotification.should(visible);
        }
        public void ProductNameFieldContainsText(String login) {
            ProductNameField.shouldHave(value(login));
        }
        public void ProductPriceFieldContainsText(String login) {
            ProductPriceField.shouldHave(value(login));
        }
        public void ProductAddButtonClick() {
            ProductAddButton.click();
        }
        public void ProductHasAddedNotificationText() {
            ProductHasAddedNotification.shouldHave(text("Товар успешно добавлен!"));

        }
        public void inputProductName(String name) {
            ProductNameField.sendKeys(name);

        }

        public void inputProductPrice(String price) {
            ProductPriceField.sendKeys(price);

        }
        public void DeleteProductButtonClick(int index) {
            DeleteButtonList.get(index)
                    .click();
        }
        public void inputProductName(int index, String name) {
            ProductNameList.get(index).clear();
            ProductNameList.get(index)
                    .sendKeys(name);
        }
        public void inputProductPrice(int index, String price) {
            ProductPriceList.get(index).clear();
            ProductPriceList.get(index)
                    .sendKeys(price);
        }
        public void SaveButtonClick(int index) {
            SaveButtonList.get(index)
                    .click();
        }
        public void ProductHasUpdateNotificationHasText() {
            ProductHasUpdateNotification.shouldHave(text("Товар #7 обновлен"));

        }
        public void ProductHasUpdateNotificationIsVisible() {
            ProductHasUpdateNotification.should(visible);
        }
        public void ComeBackButtonClick() {
            ComeBackButton.click();
        }
    }
}
