package main;

import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class MainPageAssertTask extends AbstractAssert<MainPageAssertTask, MainPageTask> {
    public MainPageAssertTask(MainPageTask mainPageTask)
    {
        super(mainPageTask, MainPageAssertTask.class);
    }



    public void cartButtonIsVisible() {
        actual.cartButton.should(visible);
    }
    public void adminPannelButtonIsVisible() {
        actual.adminPannelButton.should(visible);
    }

    public void addToCartButtonIsVisible() {
        actual.addToCartButton.should(visible);
    }

    public void increaseButtonIsVisible() {
        actual.increaseButton.should(visible);
    }
    public void closeCartButtonIsVisible() {
        actual.closeCartButton.should(visible);
    }




    public void productPriceListContainsPrice(String price) {
        actual.productPriceList.shouldHave(itemWithText(price));
    }


       public void countInputContainsValue(int index, String value) {
        actual.productCountInputList.get(index).should(value(value));
    }

    public void productCardCountIsEquals(int count) {
        actual.productCardList.should(size(count));
    }
    public void CheckProductPriceHasCorrectPrice(int index, String price) {
        actual.ProductPriceList.get(index)
                .should(text(price));
    }

    public void productNameListContainsProduct(String name) {
        actual.productNameList.shouldHave(itemWithText(name));
    }

    public void orderProcessingNotificationIsVisible() {
        actual.orderProcessingNotification.should(visible);
    }
    public void orderProcessingNotificationIsNotVisible() {
        actual.orderProcessingNotification.shouldNot(visible);
    }
    public void orderProcessingNotificationHaveCorrectText() {
        actual.orderProcessingNotification.shouldHave(text("Заказ принят в обработку!"));
    }

    public void orderAddToCartNotificationIsVisible() {
        actual.orderAddToCartNotification.should(visible);
    }
    public void orderAddToCartNotificationIsNotVisible() {
        actual.orderAddToCartNotification.shouldNot(visible);
    }
    public void orderAddToCartNotificationHaveCorrectText() {
        actual.orderAddToCartNotification.shouldHave(text("Laptop94 (3 шт.) добавлен в корзину"));
    }

    public void orderAddToCartNotificationHaveCorrectTextForProduct(String product) {
        actual.orderAddToCartNotification.shouldHave(text(product + " (1 шт.) добавлен в корзину"));
    }
    public void TotalPriceTextIsVisible() {
        actual.TotalPriceText.should(visible);
    }
    public void TotalPriceTextHaveCorrectPrice(String price) {
        actual.TotalPriceText.shouldHave(text(price));
    }

}
