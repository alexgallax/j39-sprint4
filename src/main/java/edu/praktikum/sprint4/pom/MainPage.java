package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver webDriver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    private final By orderStatusButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By orderInput = By.xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage open() {
        webDriver.get(url);
        return this;
    }

    public MainPage clickOrderStatusButton() {
        webDriver.findElement(orderStatusButton).click();
        return this;
    }

    public MainPage sendToOrderInput(String text) {
        webDriver.findElement(orderInput).sendKeys(text);
        return this;
    }

    public MainPage clickGoButton() {
        webDriver.findElement(goButton).click();
        return this;
    }

    public boolean checkNotFoundPageShown() {
        return !webDriver.findElements(By.xpath(".//img[@alt='Not found']")).isEmpty();
    }
}
