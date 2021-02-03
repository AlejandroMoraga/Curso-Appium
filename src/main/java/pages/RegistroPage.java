package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;
import static utils.Utils.validarElemento;

public class RegistroPage extends BasePage{

@AndroidFindBy(id="com.rodrigo.registro:id/precio_producto")
List<MobileElement> precios;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Registro')]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PRODUCTOS')]")
    private MobileElement tabProductos;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CLIENTES')]")
    private MobileElement tabClientes;

    @AndroidFindBy(id="com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id="com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy(id="com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(id="com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> clientes;

    @AndroidFindBy(id="com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> productos;

    public boolean validarBtnCrearProducto(){
        if(esperarElemento(btnCrearProducto,10)){
            return true;
        }
        return false;
    }

    public boolean validarBtnCrearCliente(){
        if(esperarElemento(btnCrearCliente,10)){
            return true;
        }
        return false;
    }

    public void validarBotones(){
        if(validarBtnCrearCliente() && validarBtnCrearCliente()){
            addStep("Se visualizan 2 botones mas 'Crear Cliente' y 'Crear Producto'",true, Status.PASSED,false);
        }else{
            addStep("Se visualizan 2 botones mas 'Crear Cliente' y 'Crear Producto'",true,Status.FAILED,true);
        }
    }

    public void validarVistaDesplegada(){
        if(esperarElemento(tituloVistaRegistro,20)){
            addStep("Se visualiza pantalla de 'Registro'",true, Status.PASSED,false);
        }else{
            addStep("Se visualiza pantalla de 'Registro'",true,Status.FAILED,true);
        }
    }

    public void validar(String mensaje){
        validarElemento(tituloVistaRegistro,mensaje);
    }

    public void tabBtnMas(){
        btnMas.click();
        validarBotones();
    }

    public void tabBtnCrearCliente(){
        btnCrearCliente.click();
    }

    public void tabBtnCrearProducto(){
        btnCrearProducto.click();
    }

    public void validarCliente(String  nombreCliente){
        boolean clienteEncontrado =false;
        for(int i=0; i<clientes.size() ; i++){
            if(clientes.get(i).getText().equals(nombreCliente)) {
                addStep("Validando cliente creado en lista ", true, Status.PASSED, false);
                clienteEncontrado = true;
                break;
            }
            if(!clienteEncontrado){

            }
        }
    }

    public void validarProductoIngresado(String nombre, String precio){
        boolean encontrado =false;
        for(int i=0; i<clientes.size() ; i++){
            if(productos.get(i).getText().equals(nombre)) {
                if(precios.get(i).getText().equals(precio)){
                    addStep("Validar que el producto ingresado se encuentre en la lista de la pantalla 'Productos' con el nombre y el precio correcto.", true, Status.PASSED, false);
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                addStep("Validar que el producto ingresado se encuentre en la lista de la pantalla 'Productos' con el nombre y el precio correcto.", true, Status.FAILED, true);
            }
        }
    }

    public void validarClienteBorrado(String  nombreCliente){
        boolean clienteEncontrado =false;
        for(int i=0; i<clientes.size() ; i++) {
            if (clientes.get(i).getText().equals(nombreCliente)) {
                addStep("Validando que cliente " + nombreCliente + " no esta en la lista ", false, Status.FAILED, true);
                clienteEncontrado = true;
                break;
            }
        }
            if(!clienteEncontrado){
                addStep("Validando que cliente "+nombreCliente+" no esta en la lista ", false, Status.PASSED, false);
            }

    }

    public void validarItemIngresado(List<MobileElement> items, String nombreItem, String mensaje, boolean screenshot){
        boolean encontrado = false;
        for(MobileElement item: items){
            if(item.getText().equals(nombreItem)){
                addStep(mensaje, true, Status.PASSED, false);
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            addStep(mensaje, true, Status.FAILED, false);
        }
    }

    public void validarProducto(String nombreProducto, String precioProducto){
        String mensaje="El producto ingresado esta en la lista de la vista 'Productos' con nombre ("+nombreProducto+") y precio ("+precioProducto+") correcto.";
        boolean encontrado = false;
        for(int i=0; i<productos.size(); i++){
            if(productos.get(i).getText().equals(nombreProducto)){
                if(precios.get(i).getText().equals(precioProducto+".00")){
                    addStep(mensaje, false, Status.PASSED, false);
                    encontrado = true;
                    break;
                }
            }
        }
        if(!encontrado){
            addStep(mensaje, false, Status.FAILED, false);
        }
    }

    public void tapTabProductos(){
        tabProductos.click();
    }

    public void seleccionarCliente(){
        clientes.get(0).click();
    }
    public String getNombreClienteParaBorrar(){
        return clientes.get(0).getText();
    }
}
