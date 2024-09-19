package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.rules.BrowserRule;
import org.junit.Rule;
import org.junit.Test;

import static edu.praktikum.sprint4.utils.Utils.randomString;
import static org.junit.Assert.assertTrue;

public class OrderStatusRuleTest {

    private static final String NOT_EXISTING_ORDER_NUMBER = randomString();

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void notExistingOrderMessage() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage.open()
                .clickOrderStatusButton()
                .sendToOrderInput(NOT_EXISTING_ORDER_NUMBER)
                .clickGoButton();

        assertTrue(mainPage.checkNotFoundPageShown());
    }
}
