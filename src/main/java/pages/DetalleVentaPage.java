package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static utils.Utils.esperarElemento;
import static utils.Utils.validarElemento;

public class DetalleVentaPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Venta a')]")
    private MobileElement titulo;

    @AndroidFindBy(id="com.rodrigo.registro:id/confirmarydinero")
    private MobileElement btnConfirmarContado;

    @AndroidFindBy(id="com.rodrigo.registro:id/nv_confirmar")
    private MobileElement btnConfirmarTarjeta;

    @AndroidFindBy(id="com.rodrigo.registro:id/nv_precioTotal")
    private MobileElement txtCantidadTotal;

    @AndroidFindBy(id="com.rodrigo.registro:id/buttonDefaultNegative")
    private MobileElement btnCancelar;

    @AndroidFindBy(id="com.rodrigo.registro:id/buttonDefaultPositive")
    private MobileElement btnAceptar;

    @AndroidFindBy(id="com.rodrigo.registro:id/total")
    private MobileElement totalAlert;

    public void pagarContado(){
        btnConfirmarContado.click();
        btnAceptar.click();
    }

    public void validarVistaVenta(){
        esperarElemento(titulo,10);
        validarElemento(titulo,"Se visualiza pantalla de 'Venta'");
    }





}
