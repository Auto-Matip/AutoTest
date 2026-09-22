package main;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Кликнуть по кнопке входа в Админку")
    public void clickAdminButton(){
        adminPannelButton.click();
    }

    @Step("Кликнуть по кнопке входа в Корзину")
    public void clickCartButton(){
        cartButton.click();
    }
    @Step("Кликнуть по кнопке добавления товара в Корзину")
    public void clickAddtoCartButton(){
        addToCartButton.click();
    }

    @Step("Кликнуть по кнопке увеличения количества товара")
    public void clickIncreaseButton(){
        increaseButton.click();
    }
    @Step("Кликнуть по кнопке закрытия Корзины")
    public void clickCloseCartButton() {

        closeCartButton.click();
    }
    @Step("Ввести в поле количества товара равное - {text} для товара с id = {index}")
    public void inputProductCount(int index, String text) {
        productCountInputList.get(index).clear();
        productCountInputList.get(index)
                .sendKeys(text);
    }

    @Step("Добавить в корзину товар с id = {index}")
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

        @Step("Кликнуть по кнопке закрытия Корзины")
        public void clickCloseCartPopupButton() {
            closeCartButton.click();

        }
        @Step("Нажать на кнопку Оформить заказ")
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

        @Step("Нажать на кнопку Sign in в Админке")
        public void clickSignInButton() {
            SignInButton.click();

        }
        @Step("Ввести в поле логин - {login}")
        public void inputLogin(String login) {
            LoginField.sendKeys(login);

        }

        @Step("Ввести в поле пароль - {password}")
        public void inputPassword(String password) {
            PasswordField.sendKeys(password);

        }

        @Step("Проверить текст уведомления о неправильном логине или пароле")
        public void CheckAllertText() {
            AllertText.shouldHave(text("Неверные учетные данные пользователя"));

        }

        @Step("Проверить видимость уведомления о неверном логине или пароле")
        public void CheckAllertVisible() {
            AllertText.should(visible);
        }
        @Step("Проверить не видимость уведомления о неверном логине или пароле")
        public void CheckAllertIsNotVisible() {
            AllertText.shouldNot(visible);

        }
        @Step("Проверить видимость кнопки Sign in в Админке")
        public void clickSignInButtonIsVisible() {
            SignInButton.should(visible);
        }
        @Step("Проверить видимость поля логин")
        public void LoginFieldIsVisible() {
            LoginField.should(visible);
        }
        @Step("Проверить видимость поля пароль")
        public void PasswordFieldIsVisible() {
            PasswordField.should(visible);
        }
        @Step("Проверить что поле логин содержит текст - {login}")
        public void LoginFieldContainsText(String login) {
            LoginField.shouldHave(value(login));
        }
        @Step("Проверить что поле пароль содержит текст - {password}")
        public void PasswordFieldFieldContainsText(String password) {
            PasswordField.shouldHave(value(password));
        }
        @Step("Проверить видимость поля Имя товара")
        public void ProductNameFieldIsVisible() {
            ProductNameField.should(visible);
        }
        @Step("Проверить видимость поля Цена товара")
        public void ProductPriceFieldIsVisible() {
            ProductPriceField.should(visible);
        }
        @Step("Проверить видимость кнопки Добавления товара")
        public void ProductAddButtonIsVisible() {
            ProductAddButton.should(visible);
        }
        @Step("Проверить видимость кнопки Возврата на Главную страницу")
        public void ComeBackButtonIsVisible() {
            ComeBackButton.should(visible);
        }
        @Step("Проверить видимость уведомления что товар был добавлен")
        public void ProductHasAddedNotificationIsVisible() {
            ProductHasAddedNotification.should(visible);
        }
        @Step("Проверить что поле Имя товара содержит текст - {login}")
        public void ProductNameFieldContainsText(String login) {
            ProductNameField.shouldHave(value(login));
        }
        @Step("Проверить что поле Цена товара содержит текст - {login}")
        public void ProductPriceFieldContainsText(String login) {
            ProductPriceField.shouldHave(value(login));
        }
        @Step("Нажать на кнопку добавления товара")
        public void ProductAddButtonClick() {
            ProductAddButton.click();
        }
        @Step("Проверить текст уведомления что товар был добавлен")
        public void ProductHasAddedNotificationText() {
            ProductHasAddedNotification.shouldHave(text("Товар успешно добавлен!"));

        }
        @Step("Ввести название товара - {name}")
        public void inputProductName(String name) {
            ProductNameField.sendKeys(name);

        }
        @Step("Ввести цену товара - {price}")
        public void inputProductPrice(String price) {
            ProductPriceField.sendKeys(price);
        }
        @Step("Нажать на кнопку удаления товара с id - {index}")
        public void DeleteProductButtonClick(int index) {
            DeleteButtonList.get(index)
                    .click();
        }
        @Step("Ввести для товара с id - {index}, Имя товара = {name}")
        public void inputProductName(int index, String name) {
            ProductNameList.get(index).clear();
            ProductNameList.get(index)
                    .sendKeys(name);
        }
        @Step("Ввести для товара с id - {index}, Цену товара = {price}")
        public void inputProductPrice(int index, String price) {
            ProductPriceList.get(index).clear();
            ProductPriceList.get(index)
                    .sendKeys(price);
        }
        @Step("Кликнуть на кнопку Сохранить")
        public void SaveButtonClick(int index) {
            SaveButtonList.get(index)
                    .click();
        }
        @Step("Проверить текст уведомления что товар был обновлен")
        public void ProductHasUpdateNotificationHasText() {
            ProductHasUpdateNotification.shouldHave(text("Товар #7 обновлен"));

        }
        @Step("Проверить видимость уведомления что товар был добавлен")
        public void ProductHasUpdateNotificationIsVisible() {
            ProductHasUpdateNotification.should(visible);
        }
        @Step("Нажать на кнопку Возврата на Главную страницу")
        public void ComeBackButtonClick() {
            ComeBackButton.click();
        }
    }
}
