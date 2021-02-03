package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CarruselPage extends BasePage{


    @AndroidFindBy(id="com.rodrigo.registro:id/next")
    private MobileElement flechaNext;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement btnPermitir;

    @AndroidFindBy(id="com.rodrigo.registro:id/done")
    private MobileElement btnDone;

    public void flujoCarrusel(){
        flechaNext.click();

        flechaNext.click();

        flechaNext.click();

        btnPermitir.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnDone.click();
    }




}
