package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageForSteps {

    private final WebDriver webDriver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    private final By orderStatusButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final By orderInput = By.xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");
    private final By goButton = By.xpath(".//button[text()='Go!']");

    public MainPageForSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkNotFoundPageShown() {
        return !webDriver.findElements(By.xpath(".//img[@alt='Not found']")).isEmpty();
    }

    public String getUrl() {
        return url;
    }

    public By getOrderStatusButton() {
        return orderStatusButton;
    }

    public By getOrderInput() {
        return orderInput;
    }

    public By getGoButton() {
        return goButton;
    }
}
