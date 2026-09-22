package main;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class MainPageAssertTask extends AbstractAssert<MainPageAssertTask, MainPageTask> {
    public MainPageAssertTask(MainPageTask mainPageTask)
    {
        super(mainPageTask, MainPageAssertTask.class);
    }


    @Step("Проверить видимость кнопки входа в Корзину")
    public void cartButtonIsVisible() {
        actual.cartButton.should(visible);
    }
    @Step("Проверить видимость кнопки входа в Админку")
    public void adminPannelButtonIsVisible() {
        actual.adminPannelButton.should(visible);
    }
    @Step("Проверить видимость кнопки добавления товара в Корзину")
    public void addToCartButtonIsVisible() {
        actual.addToCartButton.should(visible);
    }
    @Step("Проверить видимость кнопки увеличения количества товара")
    public void increaseButtonIsVisible() {
        actual.increaseButton.should(visible);
    }
    @Step("Проверить видимость кнопки закрытия Корзины")
    public void closeCartButtonIsVisible() {
        actual.closeCartButton.should(visible);
    }



    @Step("Проверить что в списке товаров есть товар с ценой = {price}")
    public void productPriceListContainsPrice(String price) {
        actual.productPriceList.shouldHave(itemWithText(price));
    }

    @Step("Проверить что список товаров больше либо равен = {size}")
    public void productCardListShouldBeGreater(int size) {
        actual.productCardList.should(sizeGreaterThanOrEqual(size));
    }


    @Step("Проверить что товар с id = {index} имеет количество = {value}")
       public void countInputContainsValue(int index, String value) {
        actual.productCountInputList.get(index).should(value(value));
    }
    @Step("Проверить что список товаров равен = {count}")
    public void productCardCountIsEquals(int count) {
        actual.productCardList.should(size(count));
    }
    @Step("Проверить что товар с id = {index} имеет цену равную = {price}")
    public void CheckProductPriceHasCorrectPrice(int index, String price) {
        actual.ProductPriceList.get(index)
                .should(text(price));
    }
    @Step("Проверить что в списке товаров есть товар с названием = {name}")
    public void productNameListContainsProduct(String name) {
        actual.productNameList.shouldHave(itemWithText(name));
    }
    @Step("Проверить видимость уведомления о том, что заказ принят в обработку")
    public void orderProcessingNotificationIsVisible() {
        actual.orderProcessingNotification.should(visible);
    }
    @Step("Проверить не видимость уведомления о том, что заказ принят в обработку")
    public void orderProcessingNotificationIsNotVisible() {
        actual.orderProcessingNotification.shouldNot(visible);
    }
    @Step("Проверить текст уведомления о том, что заказ принят в обработку")
    public void orderProcessingNotificationHaveCorrectText() {
        actual.orderProcessingNotification.shouldHave(text("Заказ принят в обработку!"));
    }
    @Step("Проверить видимость уведомления о том, что товар добавлен в корзину")
    public void orderAddToCartNotificationIsVisible() {
        actual.orderAddToCartNotification.should(visible);
    }
    @Step("Проверить не видимость уведомления о том, что товар добавлен в корзину")
    public void orderAddToCartNotificationIsNotVisible() {
        actual.orderAddToCartNotification.shouldNot(visible);
    }
    @Step("Проверить текст уведомления о том, что товар добавлен в корзину")
    public void orderAddToCartNotificationHaveCorrectText() {
        actual.orderAddToCartNotification.shouldHave(text("Laptop94 (3 шт.) добавлен в корзину"));
    }
    @Step("Проверить текст уведомления о том, что товар - {product}, добавлен в корзину")
    public void orderAddToCartNotificationHaveCorrectTextForProduct(String product) {
        actual.orderAddToCartNotification.shouldHave(text(product + " (1 шт.) добавлен в корзину"));
    }
    @Step("Проверить видимость общей суммы товаров добавленных в корзину")
    public void TotalPriceTextIsVisible() {
        actual.TotalPriceText.should(visible);
    }
    @Step("Проверить что общая сумма товаров добавленных в корзину равна - {price}")
    public void TotalPriceTextHaveCorrectPrice(String price) {
        actual.TotalPriceText.shouldHave(text(price));
    }

}
