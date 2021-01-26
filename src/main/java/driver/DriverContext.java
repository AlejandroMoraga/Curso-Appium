package driver;

import io.appium.java_client.AppiumDriver;

public class DriverContext {

    private static DriverManager driverManager = new DriverManager();
    public static void setUp(String nombreDispositivo, String sistemaOperativo, String rutaApp, String udId, Boolean emulador){
        driverManager.setUp(nombreDispositivo, sistemaOperativo, rutaApp, udId, emulador);
    }

    public static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }

    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
