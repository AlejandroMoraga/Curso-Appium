package testSuite;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static driver.DriverContext.setUp;

public class ejercicioTestNG {

   // private AppiumDriver driver;
   // private URL server =null;
   // DesiredCapabilities cap = new DesiredCapabilities();

    @BeforeSuite
    public void metodo1(){
        System.out.println("inicio de suite");
        //setUp();

        }
    @BeforeMethod
    public void metodo2(){
        System.out.println("inicio de test");


    }
    @Test(priority=1)
    public void metodo3(){
        System.out.println("test 1");
    }
    @Test(priority = 2)
    public void metodo4(){
        System.out.println("test2");
    }
    @AfterMethod
    public void metodo5(){
        System.out.println("termino de test");
    }

}
