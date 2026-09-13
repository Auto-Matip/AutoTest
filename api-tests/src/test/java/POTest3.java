
import main.MainPageAssertTask;
import main.AdminLoginFormAssert;
import main.MainPageTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class POTest3 {
    MainPageTask mainPageTask = new MainPageTask();
    MainPageTask.CartPopup cartPopup = mainPageTask.new CartPopup();
    MainPageTask.AdminLoginForm AdminLoginForm = mainPageTask.new AdminLoginForm();
    MainPageAssertTask mainPageAssertTask = new MainPageAssertTask(mainPageTask);

    @BeforeEach
    void setup(){
        open("http://localhost:8080");
    }
    @Test
    void Task1() {
        mainPageAssertTask.cartButtonIsVisible();
        mainPageAssertTask.adminPannelButtonIsVisible();
        mainPageAssertTask.addToCartButtonIsVisible();
        mainPageAssertTask.increaseButtonIsVisible();
        mainPageTask.productCardList.should(sizeGreaterThanOrEqual(1));
        mainPageAssertTask.orderProcessingNotificationIsNotVisible();
        mainPageTask.inputProductCount(0,"3");
        sleep(1000);
        mainPageAssertTask.countInputContainsValue(0,"3");
        sleep(1000);
        mainPageTask.clickAddtoCartButton();
        mainPageAssertTask.orderAddToCartNotificationIsVisible();
        mainPageAssertTask.orderAddToCartNotificationHaveCorrectText();
        sleep(1000);
        mainPageTask.clickCartButton();
        mainPageAssertTask.orderProcessingNotificationIsNotVisible();
        mainPageAssertTask.orderAddToCartNotificationIsNotVisible();
        mainPageAssertTask.TotalPriceTextIsVisible();
        mainPageAssertTask.TotalPriceTextHaveCorrectPrice("11.97");
        sleep(1000);
        cartPopup.clickmakeOrderButton();
        mainPageAssertTask.orderProcessingNotificationIsVisible();
        mainPageAssertTask.orderProcessingNotificationHaveCorrectText();
        sleep(3000);
        mainPageAssertTask.orderProcessingNotificationIsNotVisible();
    }

    @Test
    void Task2() {
        mainPageAssertTask.cartButtonIsVisible();
        mainPageAssertTask.adminPannelButtonIsVisible();
        mainPageAssertTask.addToCartButtonIsVisible();
        mainPageAssertTask.increaseButtonIsVisible();
        mainPageTask.productCardList.should(sizeGreaterThanOrEqual(3));
        mainPageTask.inputAddToCartButtonList(0);
        mainPageAssertTask.orderAddToCartNotificationHaveCorrectTextForProduct("Laptop94");
        sleep(1000);
        mainPageTask.inputAddToCartButtonList(1);
        mainPageAssertTask.orderAddToCartNotificationHaveCorrectTextForProduct("Laptop98");
        sleep(1000);
        mainPageTask.inputAddToCartButtonList(2);
        mainPageAssertTask.orderAddToCartNotificationHaveCorrectTextForProduct("Laptop9");
        mainPageAssertTask.orderAddToCartNotificationIsVisible();
        sleep(1000);
        mainPageTask.clickCartButton();
        sleep(1000);
        mainPageAssertTask.CheckProductPriceHasCorrectPrice(0,"3.99 ₽");
        mainPageAssertTask.CheckProductPriceHasCorrectPrice(1,"1.99 ₽");
        mainPageAssertTask.CheckProductPriceHasCorrectPrice(2,"6.99 ₽");
        mainPageAssertTask.TotalPriceTextIsVisible();
        mainPageAssertTask.TotalPriceTextHaveCorrectPrice("12.97");
        sleep(1000);
        cartPopup.clickmakeOrderButton();
        mainPageAssertTask.orderProcessingNotificationIsVisible();
        mainPageAssertTask.orderProcessingNotificationHaveCorrectText();

        }
    @Test
    void Task3() {
        mainPageTask.clickAdminButton();
        AdminLoginForm.clickSignInButtonIsVisible();
        AdminLoginForm.LoginFieldIsVisible();
        AdminLoginForm.PasswordFieldIsVisible();
        sleep(1000);
        AdminLoginForm.inputLogin("admin");
        AdminLoginForm.LoginFieldContainsText("admin");
        AdminLoginForm.inputPassword("secret123");
        AdminLoginForm.PasswordFieldFieldContainsText("secret123");
        sleep(1000);
        AdminLoginForm.clickSignInButton();
        AdminLoginForm.CheckAllertIsNotVisible();
        sleep(1000);
        AdminLoginForm.ProductNameFieldIsVisible();
        AdminLoginForm.ProductPriceFieldIsVisible();
        AdminLoginForm.ProductAddButtonIsVisible();
        AdminLoginForm.inputProductName("Hammer");
        AdminLoginForm.ProductNameFieldContainsText("Hammer");
        sleep(1000);
        AdminLoginForm.inputProductPrice("4.33");
        AdminLoginForm.ProductPriceFieldContainsText("4.33");
        sleep(1000);
        AdminLoginForm.ProductAddButtonClick();
        AdminLoginForm.ProductHasAddedNotificationIsVisible();
        AdminLoginForm.ProductHasAddedNotificationText();
        sleep(1000);
        AdminLoginForm.DeleteProductButtonClick(4);
        switchTo().alert().accept();
        sleep(3000);
    }

    @Test
    void Task4() {
        mainPageTask.clickAdminButton();
        AdminLoginForm.clickSignInButtonIsVisible();
        AdminLoginForm.LoginFieldIsVisible();
        AdminLoginForm.PasswordFieldIsVisible();
        sleep(1000);
        AdminLoginForm.inputLogin("admin");
        AdminLoginForm.LoginFieldContainsText("admin");
        AdminLoginForm.inputPassword("secret123");
        AdminLoginForm.PasswordFieldFieldContainsText("secret123");
        sleep(1000);
        AdminLoginForm.clickSignInButton();
        AdminLoginForm.CheckAllertIsNotVisible();
        sleep(1000);
        AdminLoginForm.ProductNameFieldIsVisible();
        AdminLoginForm.ProductPriceFieldIsVisible();
        AdminLoginForm.ProductAddButtonIsVisible();
        AdminLoginForm.inputProductName(4,"Hammer");
        AdminLoginForm.inputProductPrice(4,"4.36");
        AdminLoginForm.SaveButtonClick(3);
        AdminLoginForm.ProductHasUpdateNotificationIsVisible();
        AdminLoginForm.ProductHasUpdateNotificationHasText();
        sleep(1000);
        AdminLoginForm.ComeBackButtonIsVisible();
        AdminLoginForm.ComeBackButtonClick();
        mainPageAssertTask.productPriceListContainsPrice("4.36 ₽");
        mainPageAssertTask.productNameListContainsProduct("Hammer");
        sleep(1000);
    }

}