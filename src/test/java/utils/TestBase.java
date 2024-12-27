package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pages.*;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class TestBase {
    protected AppiumDriver<?> driver;
    protected LoginTela loginTela;
    protected FaleTela faleTela;
    protected HomeTela homeTela;
    protected EsqueciMinhaSenhaTela esqueciMinhaSenhaTela;
    protected MeusDadosTela meusDadosTela;

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

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void espere(int numero) throws InterruptedException {
        Thread.sleep(numero * 1000L);
    }

    public void movimentacoes(){
        // Obtenha o tamanho da tela
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

// Coordenadas de início e fim do swipe
        int startX = screenWidth / 2;  // No centro da tela horizontalmente
        int startY = (int) (screenHeight * 0.8);  // Começar 80% a partir do topo
        int endY = (int) (screenHeight * 0.2);  // Terminar 20% a partir do topo

// Execute o swipe de cima para baixo
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))  // Posição inicial
                .waitAction(WaitOptions.waitOptions(ofSeconds(1)))  // Duração da ação
                .moveTo(PointOption.point(startX, endY))  // Posição final
                .release()  // Soltar o toque
                .perform();
    }
}