package nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static By clothesCategory = By.cssSelector("div#category-3");
    public static By menCategory = By.cssSelector("li.dropdown-item dropdown-submenu");
    public static By firstProduct = By.cssSelector("li.thumbnail-top");
    public static By quantityInput = By.id("quantity_wanted");
    public static By Cartbotton = By.name("add-to-cart");
    public static By cartPopup = By.id("myModalLabel");
    public static By totalAmount = By.cssSelector(".ajax_block_cart_total");






}

