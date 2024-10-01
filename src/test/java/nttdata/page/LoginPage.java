package nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By alertMessage = By.cssSelector("li.alert");
    public static By carouselItem = By.cssSelector(".carousel-item");


    public boolean isAlertMessageDisplayed() {
        return driver.findElement(alertMessage).isDisplayed();
    }

    public String getAlertMessage() {
        return driver.findElement(alertMessage).getText();
    }


}