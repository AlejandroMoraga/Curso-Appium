package testSuite;

import io.qameta.allure.model.Status;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ReportAllure;

import static driver.DriverContext.setUp;

public class allure {

    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void metodo1(){
        System.out.println("inicio de suite");
        setUp("emulador-5554","Android","C:\\Users\\a_s_m\\Desktop\\registroDeUsuarios.apk","emulador-5554",true);
        ReportAllure.addStep("levantar dispositivo",true, Status.PASSED,false);
    }
    @BeforeMethod
    public void metodo2(){
        System.out.println("inicio de test");


    }
    @Test(priority=1)
    public void metodo3(){
        softAssert.assertTrue(false,"es false");
        System.out.println("test 1");
        softAssert.assertAll();
    }
}
