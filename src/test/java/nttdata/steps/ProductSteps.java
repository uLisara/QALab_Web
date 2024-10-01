package nttdata.steps;

import nttdata.page.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.Assert;

public class ProductSteps {

    private final WebDriver driver;
    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        this.driver = driver;
        this.productPage = new ProductPage(driver);
    }

    public void navegarCategoryMen() {
        if (driver == null) {
            throw new RuntimeException("WebDriver no está inicializado.");
        }
        WebElement clothesCategoryElement = driver.findElement(ProductPage.clothesCategory);
        clothesCategoryElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.menCategory));

        WebElement menCategoryElement = driver.findElement(ProductPage.menCategory);
        menCategoryElement.click();
    }
    public void añadirProductoMen(int cantidad) {
        WebElement firstProductElement = driver.findElement(ProductPage.firstProduct);
        firstProductElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ProductPage.quantityInput));

        WebElement quantityInputElement = driver.findElement(ProductPage.quantityInput);
        quantityInputElement.clear();
        quantityInputElement.sendKeys(String.valueOf(cantidad));

        WebElement addToCartButton = driver.findElement(ProductPage.Cartbotton);
        addToCartButton.click();
    }

    public void validarProductoCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.cartPopup));
        Assert.assertTrue("El producto no fue agregado correctamente.", confirmationPopup.isDisplayed());
    }
    public void validarTotalCarrito(double expectedTotal) {
        WebElement totalAmountElement = driver.findElement(ProductPage.totalAmount);
        String totalAmountText = totalAmountElement.getText().replace("S/", "").trim();

        double actualTotal = Double.parseDouble(totalAmountText);
        Assert.assertEquals("El total no coincide con el esperado.", expectedTotal, actualTotal, 0.01);
    }

}
