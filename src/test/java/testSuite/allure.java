package testSuite;

import io.qameta.allure.model.Status;
import javafx.scene.layout.Priority;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ReportAllure;
import testCases.CPA_AsignarVentaCliente;
import testCases.CPA_BorrarCliente;
import testCases.CPA_CrearCliente;
import testCases.CPA_CrearProducto;

import static driver.DriverContext.quitDriver;
import static driver.DriverContext.setUp;

public class allure {

    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUpp(){
        System.out.println("inicio de suite");
        //setUp("emulador-5554","Android","C:\\Users\\a_s_m\\Desktop\\registroDeUsuarios.apk","emulador-5554",true);
       // ReportAllure.addStep("levantar dispositivo",true, Status.PASSED,false);
    }
    @BeforeMethod
    public void inicioTest(){
        setUp("emulador-5554","Android","C:\\Users\\a_s_m\\Desktop\\registroDeUsuarios.apk","emulador-5554",true);
        ReportAllure.addStep("Se visualiza carrusel informativo",true, Status.PASSED,false);

    }

    @AfterMethod
    public void quit(){
        System.out.println("inicio de test");
        quitDriver();
    }
 
    @Test (priority = 1)
    public void CPA_CrearCliente(){
        CPA_CrearCliente cpa = new CPA_CrearCliente();
        cpa.flujoFront();
    }

    @Test (priority = 2)
    public void CPA_CrearProducto(){
        CPA_CrearProducto cpa_crearProducto = new CPA_CrearProducto();
        cpa_crearProducto.flujoFront();
    }

    @Test(priority=4)
    public void CPA_BorrarCliente(){
        CPA_BorrarCliente cpa_borrarCliente = new CPA_BorrarCliente();
        cpa_borrarCliente.flujo();
    }
@Test(priority=3)
    public void CPA_AsignarVentaCliente(){
        CPA_AsignarVentaCliente cpa_asignarVentaCliente = new CPA_AsignarVentaCliente();
        cpa_asignarVentaCliente.flujoFront();
    }

}
