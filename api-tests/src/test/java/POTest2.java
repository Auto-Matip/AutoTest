
import main.MainPageAssertTask;
import main.MainPageTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class POTest2 {
    MainPageTask mainPageTask = new MainPageTask();
    MainPageTask.CartPopup cartPopup = mainPageTask.new CartPopup();
    MainPageTask.AdminLoginForm AdminLoginForm = mainPageTask.new AdminLoginForm();
    MainPageAssertTask mainPageAssertTask = new MainPageAssertTask(mainPageTask);

    @BeforeEach
    void setup(){
        open("http://localhost:8080");
    }
    @Test
    void test() {
        mainPageAssertTask.cartButtonIsVisible();
        mainPageAssertTask.adminPannelButtonIsVisible();
        mainPageAssertTask.addToCartButtonIsVisible();
        mainPageAssertTask.increaseButtonIsVisible();
        mainPageAssertTask.productPriceListContainsPrice("3.99 ₽");
        mainPageAssertTask.productNameListContainsProduct("Laptop9");
        mainPageAssertTask.productCardCountIsEquals(4);
        mainPageTask.productCardList.should(sizeGreaterThanOrEqual(1));
        mainPageTask.productNameList.should(sizeGreaterThanOrEqual(1));

       sleep(1000);
        mainPageTask.clickIncreaseButton();
        sleep(1000);
        mainPageTask.clickAddtoCartButton();
        sleep(1000);
        mainPageTask.clickCartButton();
        sleep(1000);
        mainPageAssertTask.closeCartButtonIsVisible();
        mainPageTask.clickCloseCartButton();
        sleep(1000);
        mainPageTask.clickAdminButton();
        sleep(1000);
        back();
        sleep(1000);
        mainPageAssertTask.cartButtonIsVisible();
        mainPageTask.inputProductCount(0,"67");
        sleep(1000);
        mainPageAssertTask.countInputContainsValue(0,"67");
        sleep(1000);
        mainPageTask.clickAddtoCartButton();
        sleep(1000);
        mainPageTask.clickCartButton();
        sleep(1000);
        cartPopup.clickmakeOrderButton();
        sleep(1000);
            }


    @Test
    void Admintest() {
        mainPageTask.clickAdminButton();
        AdminLoginForm.clickSignInButtonIsVisible();
        AdminLoginForm.LoginFieldIsVisible();
        AdminLoginForm.PasswordFieldIsVisible();
        sleep(1000);
        AdminLoginForm.inputLogin("admin123");
        AdminLoginForm.LoginFieldContainsText("admin123");
        AdminLoginForm.inputPassword("secret");
        AdminLoginForm.PasswordFieldFieldContainsText("secret");
        sleep(1000);
        AdminLoginForm.clickSignInButton();
        sleep(1000);
        AdminLoginForm.CheckAllertVisible();
        AdminLoginForm.CheckAllertText();
        sleep(1000);
        AdminLoginForm.inputLogin("admin");
        AdminLoginForm.LoginFieldContainsText("admin");
        AdminLoginForm.inputPassword("secret123");
        AdminLoginForm.PasswordFieldFieldContainsText("secret123");
        sleep(1000);
        AdminLoginForm.clickSignInButton();
        AdminLoginForm.CheckAllertIsNotVisible();
        sleep(1000);
    }
}