package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.pom.MainPageForSteps;
import edu.praktikum.sprint4.steps.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static edu.praktikum.sprint4.utils.Utils.randomString;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class OrderStatusTest {

    private static final String NOT_EXISTING_ORDER_NUMBER = randomString();

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    @Test
    public void notExistingOrderMessage() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open()
                .clickOrderStatusButton()
                .sendToOrderInput(NOT_EXISTING_ORDER_NUMBER)
                .clickGoButton();

        assertTrue(mainPage.checkNotFoundPageShown());
    }

    @Test
    public void notExistingOrderMessageSteps() {
        MainPageForSteps mainPage = new MainPageForSteps(webDriver);
        Steps steps = new Steps(webDriver);

        steps.open(mainPage.getUrl())
                .click(mainPage.getOrderStatusButton())
                .input(mainPage.getOrderInput(), NOT_EXISTING_ORDER_NUMBER)
                .click(mainPage.getGoButton());

        assertTrue(mainPage.checkNotFoundPageShown());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
