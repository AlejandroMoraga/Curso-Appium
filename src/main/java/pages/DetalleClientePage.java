package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebElement;

import static reports.ReportAllure.addStep;
import static utils.Utils.*;

public class DetalleClientePage extends BasePage{


    @AndroidFindBy(id="com.rodrigo.registro:id/vc_anadirVenta")
    private WebElement  btnAgregarNuevaVenta;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Entrega Dinero')]")
    private WebElement btnEntregaDinero;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Precios especiales')]")
    private WebElement btnPreciosEspeciales;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ver ventas realizadas')]")
    private WebElement btnVerVentasRealizadas;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ver dinero entregado')]")
    private WebElement btnDineroEntregado;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Eliminar cliente')]")
    private WebElement btnEliminarCliente;

    @AndroidFindBy(id="com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement txtBorrar;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'CANCEL')]")
    private MobileElement btnCancelar;

    @AndroidFindBy(id="android:id/button1")
    private MobileElement btnOK;

    @AndroidFindBy(id="com.rodrigo.registro:id/vercli_ultVenta")
    private MobileElement txtUltimaVenta;

    public void borrarCliente(){
        swipeAbajo();
        swipeAbajo();
        btnEliminarCliente.click();
        txtBorrar.click();
        validarElemento(txtBorrar,"Se visualiza popUp de confirmacion");
        txtBorrar.setValue("BORRAR");
        btnOK.click();
    }

    public void agregarVenta(){
        btnAgregarNuevaVenta.click();
    }

    public void validarVistaDetalleCliente(){
        esperarElemento(txtUltimaVenta,20);
        validarElemento(txtUltimaVenta,"Se visualiza pantalla 'Detalle del Cliente'");
    }

    public void validarTotalUltimaVenta(String cantidad, String precio){

        String totalObtenido = txtUltimaVenta.getText();
        int total= Integer.parseInt(cantidad)*Integer.parseInt(precio);
        String totalString = String.valueOf(total);

        System.out.println(totalObtenido);
        System.out.println(totalString);

        if(totalObtenido.indexOf(totalString)!=-1){
            addStep("Validacion del total de venta = cantidad x precio " + totalString,true, Status.PASSED,false);
        }else{
            addStep("Validacion del total de venta = cantidad x precio",true, Status.FAILED,true);
        }


    }





    
}
