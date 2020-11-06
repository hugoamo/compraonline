package steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import pageobject.automationpracticeHomePageObject;

public class AgregarProductoCarritoStep {

    private automationpracticeHomePageObject paginaPrincipal;

    @Step
    public void abrir_en_navegador_la_aplicacion(WebDriver driver) {
        paginaPrincipal.open();
        driver.manage().window().maximize();
    }

    @Step
    public void logueo(String username, String contraseia){
        paginaPrincipal.loguearse(username,contraseia);
    }
    @Step
    public String nombreUsuario(){
        return paginaPrincipal.nombreUsuario();
    }
    @Step
    public void agregarProducto(WebDriver driver){
        paginaPrincipal.agregarProducto(driver);
    }
    @Step
    public String validarProducto(){
        return paginaPrincipal.validarProducto();
    }
    @Step
    public void generarOrden(WebDriver driver){
        paginaPrincipal.generarOrden(driver);
    }
}
