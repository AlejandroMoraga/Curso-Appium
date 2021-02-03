package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static utils.Utils.esperarElemento;
import static utils.Utils.validarElemento;


public class CompraIndividualPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Compra Individual')]")
    MobileElement titulo;

    @AndroidFindBy(id="com.rodrigo.registro:id/cp_cantidad")
    private MobileElement inputCantidadComprada;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'AGREGAR')]")
    private MobileElement btnAgregar;

    @AndroidFindBy(id="com.rodrigo.registro:id/cp_precio")
    MobileElement precio;

    public void agregarCantidad(String cantidad){
        inputCantidadComprada.setValue(cantidad);
        btnAgregar.click();
    }

    public void validarVistaCompraIndividual(){
        esperarElemento(titulo,20);
        validarElemento(titulo,"Se visualiza pantalla de 'Compra Individual'");
    }

    public String getPrecio(){
        String p =precio.getText();
        return p.substring(0,p.length()-3);
    }





}
