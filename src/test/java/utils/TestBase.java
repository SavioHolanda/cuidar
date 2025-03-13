package utils;

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import pages.*;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected AppiumDriver driver;
    protected LoginTela loginTela;
    protected FaleTela faleTela;
    protected HomeTela homeTela;
    protected EsqueciMinhaSenhaTela esqueciMinhaSenhaTela;
    protected MeusDadosTela meusDadosTela;

    @Before
    public void setUp() throws MalformedURLException {
        CapabilitiesManager capabilitiesManager = new CapabilitiesManager();
        driver = capabilitiesManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginTela = new LoginTela(driver);
        faleTela = new FaleTela(driver);
        homeTela = new HomeTela(driver);
        esqueciMinhaSenhaTela = new EsqueciMinhaSenhaTela(driver);
        meusDadosTela = new MeusDadosTela(driver);
    }

    // @After
    // public void tearDown() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }

    public void espere(int numero) throws InterruptedException {
        Thread.sleep(numero * 1000L);
    }

    public void scroll(double ix, double iy, double fx, double fy) {
        Dimension dimension = driver.manage().window().getSize();
        
        System.out.println(dimension);

        int startx = (int) (dimension.width * ix);
        int starty = (int) (dimension.height * iy);
        int endx = (int) (dimension.width * fx);
        int endy = (int) (dimension.height * fy);

        Map<String, Object> args = new HashMap<>();
        args.put("startX", startx);
        args.put("startY", starty);
        args.put("endX", endx);
        args.put("endY", endy);
        args.put("duration", 1.0);
        
        driver.executeScript("mobile: dragGesture", args);
    }
}