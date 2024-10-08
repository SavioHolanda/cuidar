package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginTela {

    public LoginTela(final AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup[2]")
    //@iOSFindBy(xpath = "xx");
    private WebElement btnAvancar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Seja bem-vindo ao Cuid@r autocuidado\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement txtBoasVindas;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"CPF\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement campoCpf;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Avançar\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement btnAvancarLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"NHG\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement btnSelecionarEmpresa;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Avançar\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement btnAvancarEmpresa;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Senha\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement campoSenha;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Entrar\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup")
    //@iOSFindBy(xpath = "xx");
    private WebElement visualizarEmpresas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Seja bem-vindo ao Cuid@r autocuidado\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement txtBemVindo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement txt2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Preencha seu CPF para iniciar sua experiência.\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement txt3;

    public void clickBtnAvancarBemVindo() {
        for (int i = 0; i < 3; i++) {
            btnAvancar.click();
        }
    }

    public void escreverCampoCpf(String cpf){
        campoCpf.click();
        campoCpf.sendKeys(cpf);
    }

    public String textoCampoCpf(){
        return campoCpf.getText();
    }

    public void clickBtnAvancar(){
        for (int i = 0; i < 2; i++) {
            btnAvancarLogin.click();
        }
    }

    public String textoBoasVindas(){
        return txtBoasVindas.getText();
    }

    public void selecionarEmpresa(){
        btnSelecionarEmpresa.click();
    }

    public void clickAvancarEmpresa(){
        btnAvancarEmpresa.click();
    }

    public void escreverSenha(String senha){
        campoSenha.sendKeys(senha);
    }
    public String campoSenha(){
        return campoSenha.getText();
    }

    public void clickBtnEntrar(){
        btnEntrar.click();
    }

    public String txtBemVindo(){
        return txtBemVindo.getText();
    }

    public List<String> visualizarEmpresas() {
        List<WebElement> elements = visualizarEmpresas.findElements(By.className("android.widget.TextView"));
        List<String> nomesEmpresas = new ArrayList<>();
        for (WebElement element : elements) {
            String empresaNome = element.getText();
            if (!empresaNome.equalsIgnoreCase("Pendente")) {
                nomesEmpresas.add(empresaNome);
            }
        }
        return nomesEmpresas;
    }

    public List<String> visualizarTxt() {
        List<String> txtbemvindo = new ArrayList<>();
            txtbemvindo.add(txtBemVindo.getText());
            txtbemvindo.add(txt2.getText());
            txtbemvindo.add(txt3.getText());
        return txtbemvindo;
    }
}