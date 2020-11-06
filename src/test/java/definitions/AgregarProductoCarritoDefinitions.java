package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import steps.AgregarProductoCarritoStep;

public class AgregarProductoCarritoDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    AgregarProductoCarritoStep pasos;

    @Given("^el ingreso a la tienda virtual$")
    public void el_ingreso_a_la_tienda_virtual() {
        pasos.abrir_en_navegador_la_aplicacion(driver);
    }


    @When("^ingreso usuario y clave$")
    public void ingreso_usuario_y_clave() {
        pasos.logueo("hamellizo8701@gmail.com","12345");
    }

    @Then("^acceso con usuario registrado$")
    public void acceso_con_usuario_registrado() {
        MatcherAssert.assertThat("Hugo Mellizo", Matchers.equalTo(pasos.nombreUsuario()));
    }

    @Given("^ingreso a sesion women$")
    public void ingreso_a_sesion_women() {
        pasos.agregarProducto(driver);
    }

    @When("^se selecciona un articulo$")
    public void se_selecciona_un_articulo() {
        MatcherAssert.assertThat("Faded Short Sleeve T-shirts", Matchers.equalTo(pasos.validarProducto()));

    }

    @Then("^se agregan al carrro de compras$")
    public void se_agregan_al_carrro_de_compras() {
        pasos.generarOrden(driver);
    }

}
