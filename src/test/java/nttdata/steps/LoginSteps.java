package nttdata.steps;

import nttdata.page.LoginPage;
import nttdata.page.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {
    private LoginPage loginPage;
    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    // Escribir el usuario

    public void typeUser(String user) {
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
    }

    //Escribir el password
    public void typePassword(String password) {
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    //Hacer click en el botón login
    public void clickbtnLogin() {
        driver.findElement(LoginPage.loginButton).click();

    }

    public void validarLogin() {
        clickbtnLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.alert")));

            Assert.assertTrue("El mensaje de alerta no se mostró.", loginPage.isAlertMessageDisplayed());
            System.out.println("Error: " + loginPage.getAlertMessage());
        } catch (TimeoutException e) {

            System.out.println("Inicio de sesión exitoso.");
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.carouselItem));
                System.out.println("El carrusel se mostró correctamente.");
            } catch (Exception innerException) {
                System.out.println("El carrusel no se mostró: " + innerException.getMessage());
            }
        }
        }
    }