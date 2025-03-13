package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeTela {
    public HomeTela(final AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtHome;

    @AndroidFindBy(accessibility = "MEUS DADOS")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement btnMeusDados;

    public String txtValidarAcessoAHome(){
        return txtHome.getText();
    }

    public void clicarMeusDados() {
        btnMeusDados.click();
    }
}
