package utils;

import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static reports.ReportAllure.addStep;

public class Utils {

    public static boolean esperarElemento(MobileElement elemento, int segundos){
        try{
            System.out.println("[Utils - esperarElemento] se busca elemento "+elemento);
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(),segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            return true;
        }catch(Exception e){
            System.out.println("[Utils - esperarElemento] "+elemento+" no se encontro. ");
            return false;
        }
    }

    public static void validarElemento(MobileElement elemento, String mensaje){
        if(esperarElemento(elemento,20)){
            addStep(mensaje,true, Status.PASSED,false);
        }else{
            addStep(mensaje,true,Status.FAILED,true);
        }
    }


    public static void swipeAbajo(){
        int anchor= (int)(DriverContext.getDriver().manage().window().getSize().width*0.89);
        int startPoint=(int)(DriverContext.getDriver().manage().window().getSize().height*0.89);
        int endPint=(int)(DriverContext.getDriver().manage().window().getSize().height*0.650);
        TouchAction touchAction = new TouchAction(DriverContext.getDriver());
        touchAction.press(PointOption.point(anchor,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(anchor,endPint)).release().perform();
        System.out.println("Se hace swip abajo");
    }

    public static String cadenaAleatorea(){
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static String stringEnteroAleatoreo(int n){
        return String.valueOf((int) (Math.random() * n) + 1);
    }
}
