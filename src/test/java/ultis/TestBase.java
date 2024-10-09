package ultis;

import pages.FaleTela;
import pages.HomeTela;
import pages.LoginTela;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected AppiumDriver<?> driver;
    protected LoginTela loginTela;
    protected FaleTela faleTela;
    protected HomeTela homeTela;

    public void setUp() throws MalformedURLException {
        CapabilitiesManager capabilitiesManager = new CapabilitiesManager();
        driver = capabilitiesManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginTela = new LoginTela(driver);
        faleTela = new FaleTela(driver);
        homeTela = new HomeTela(driver);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void espere(int numero) throws InterruptedException {
        Thread.sleep(numero * 1000L);
    }
}