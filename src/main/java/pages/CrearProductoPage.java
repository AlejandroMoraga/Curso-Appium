package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.model.Status;
import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;
import static utils.Utils.validarElemento;

public class CrearProductoPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Crear Producto')]")
private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id="com.rodrigo.registro:id/nombre_producto")
    private MobileElement inputNombreProducto;

    @AndroidFindBy(id="com.rodrigo.registro:id/precio")
    private MobileElement inputPrecio;

    @AndroidFindBy(id="com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;
/*
    public void validarVistaDesplegada_1(){
        if(esperarElemento(tituloVistaCrearProducto,10)){
            addStep("Validar vista registro desplegada",true, Status.PASSED,false);
        }else{
            addStep("Validar vista registro desplegada",true,Status.FAILED,true);
        }
    }
*/
    public void validarVistaDesplegada(String mensaje){
        validarElemento(tituloVistaCrearProducto,mensaje);
    }

    public void completarFormulario(String nombreProducto, String precioProducto){
        //validar que precioProducto sea numerico
        inputNombreProducto.setValue(nombreProducto);
        this.driver.hideKeyboard();
        inputPrecio.click();
        inputPrecio.setValue(precioProducto);
        this.driver.hideKeyboard();
    }

    public void tapConfirmar(){
        btnConfirmar.click();
    }

}
