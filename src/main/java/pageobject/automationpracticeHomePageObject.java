package pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

@DefaultUrl(value ="http://automationpractice.com/index.php")
public class automationpracticeHomePageObject extends PageObject {
    @FindBy (xpath = "//a[@class='login']")
    WebElementFacade lknSingIn;
    @FindBy (xpath = "//input[@id='email']")
    WebElementFacade txtEmail;
    @FindBy (xpath = "//input[@id='passwd']")
    WebElementFacade txtClave;
    @FindBy (xpath = "//*[@id='SubmitLogin' or @name='SubmitLogin']")
    WebElementFacade btnSingIn;
    @FindBy (xpath = "//a[@class='account']")
    WebElementFacade lknNombreusuario;
    @FindBy (xpath = "//*[@class='sf-with-ul' and @title='Women']")
    WebElementFacade lknSesionWomen;
    @FindBy (xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/span/span")
    WebElementFacade btnTextProucto;
    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=1&token=de750a958f435fd0c92fd0dd9735abea']")
    WebElementFacade lknProducto;
    @FindBy (xpath = "//*[@id='layer_cart_product_title' and @class='product-name']")
    WebElementFacade lblNombreProducto;
    @FindBy (xpath = "//*[@title='Proceed to checkout' and @class='btn btn-default button button-medium']")
    WebElementFacade btnContinuarPago;
    @FindBy (xpath = "//*[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']")
    WebElementFacade btnConfirmacionPago;
    @FindBy (xpath = "//*[@name='processAddress' and @class='button btn btn-default button-medium']")
    WebElementFacade btnConfirmacionProceso;
    @FindBy (xpath = "//*[@name='processCarrier' and @class='button btn btn-default standard-checkout button-medium']")
    WebElementFacade btnConfirmacionEnvio;
    @FindBy (xpath = "//*[@id='uniform-cgv']")
    WebElementFacade ckbAceptarTerminos;
    @FindBy (xpath = "//*[@class='bankwire' and @title='Pay by bank wire']")
    WebElementFacade lknSelecionMetodoPago;
    @FindBy (xpath = "//*[@class='button btn btn-default button-medium' and @type='submit']")
    WebElementFacade btnFinalizarCompra;

    public void loguearse(String username, String contraseia) {

        if (existeElemento(lknSingIn)) {
            lknSingIn.click();
            txtEmail.sendKeys(username);
            txtClave.sendKeys(contraseia);
            btnSingIn.click();
        } else {

        }
        resetImplicitTimeout();
    }

    private boolean existeElemento(WebElementFacade xpathElemento) {
        boolean estaPresente;
        try {
            estaPresente = xpathElemento.isCurrentlyVisible();
        } catch (Exception e) {
            return false;
        }
        return estaPresente;
    }
    public String nombreUsuario(){
        return lknNombreusuario.getText();

    }
    public String validarProducto(){
        return  lblNombreProducto.getText();
    }
    public void agregarProducto(WebDriver driver){
        lknSesionWomen.click();
        Actions action = new Actions(driver);
        action.build();
        if (existeElemento(btnTextProucto)) {
            action.moveToElement(btnTextProucto);
            btnTextProucto.click();
            lknProducto.click();
        } else {

        }
        resetImplicitTimeout();
    }
    public void generarOrden(WebDriver driver){
        Actions action = new Actions(driver);
        action.build();
        btnContinuarPago.click();
        btnConfirmacionPago.click();
        btnConfirmacionProceso.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,500);");
        ckbAceptarTerminos.click();
        System.out.println(ckbAceptarTerminos.isSelected());
        btnConfirmacionEnvio.click();
        lknSelecionMetodoPago.click();
        btnFinalizarCompra.click();

    }

}
