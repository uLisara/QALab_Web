package nttdata.stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nttdata.steps.ProductSteps;
import org.openqa.selenium.WebDriver;

public class ProductSD {
    private WebDriver driver;
    private final ProductSteps productSteps;

    public ProductSD() {
        this.productSteps = new ProductSteps(driver);
    }
    @When("navego a la categoria{} y subcategoria{}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        if (categoria.equalsIgnoreCase("Clothes") && subcategoria.equalsIgnoreCase("Men")) {
            productSteps.navegarCategoryMen();
        }
    }

    @And("agrego {} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        productSteps.añadirProductoMen(cantidad);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        productSteps.validarProductoCarrito();

    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        double expectedTotal = 19.12 * 2;
        productSteps.validarTotalCarrito(expectedTotal);

    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
