package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Utils.validarElemento;

public class SeleccionarProductoPage extends BasePage{

    @AndroidFindBy(id="//android.widget.TextView[contains(@text,'Seleccione')]")
    private MobileElement titulo;

    @AndroidFindBy(id="android:id/text1")
    private List<MobileElement> listaDeProductos;

    private boolean hayProductos(){
        return listaDeProductos.size()>0;
    }

    public void seleccionDeProducto(){
        if(hayProductos()){
            listaDeProductos.get(0).click();
        }else{

        }
    }

    public void validarVistaSeleccionProducto(){
        validarElemento(titulo,"Se visualiza pantalla de 'Seleccionar Producto'");
    }



}
