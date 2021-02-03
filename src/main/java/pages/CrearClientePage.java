package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.model.Status;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;

public class CrearClientePage extends BasePage{


    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Crear Cliente')]")
    private MobileElement tituloVistaCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement inputID;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement inputNombre;

    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement inputTelefono;

    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement inputDireccion;

    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement inputNotas;

    @AndroidFindBy(id="com.rodrigo.registro:id/cambiar_ubicacion")
    private MobileElement btnCambiarUbicacion;

    @AndroidFindBy(id="com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;



        public void validarVistaDesplegada(){
            if(esperarElemento(tituloVistaCrearCliente,10)){
                addStep("Validar vista registro desplegada",true, Status.PASSED,false);
            }else{
                addStep("Validar vista registro desplegada",true,Status.FAILED,true);
            }
        }



    public void completarFormulario(String nombre, String ID, String telefono, String direccion, String notas){

            inputNombre.setValue(nombre);
        this.driver.hideKeyboard();

        inputID.click();
        inputID.setValue(ID);
        this.driver.hideKeyboard();

        inputTelefono.click();
        inputTelefono.setValue(ID);
        this.driver.hideKeyboard();

        inputDireccion.click();
        inputDireccion.setValue(ID);
        this.driver.hideKeyboard();

        inputNotas.click();
        inputNotas.setValue(ID);
        this.driver.hideKeyboard();

    }

    public void tapGuardar(){
        btnGuardar.click();
    }
}
