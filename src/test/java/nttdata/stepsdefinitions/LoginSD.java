package nttdata.stepsdefinitions;

import io.cucumber.java.en.And;
import nttdata.steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static nttdata.core.DriverManager.getDriver;
import static nttdata.core.DriverManager.screenShot;

public class LoginSD {
    private WebDriver driver;

    @Given("estoy en la página de la tienda My Store")
    public void estoyEnLaPaginaDeLaTiendaMyStore() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        screenShot();
    }
    @And("me logueo con mi usuario{} y clave{}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.validarLogin();
        screenShot();

    }




}
