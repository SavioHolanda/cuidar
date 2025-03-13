package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MeusDadosTela {

    public MeusDadosTela(final AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"@undefined/input\" and @text=\"Sávio\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoNome;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"@undefined/input\" and @text=\"Borges\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoSobrenome;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"@undefined/input\" and @text=\"Não\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoGrupoSanguineo;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"@undefined/input\" and @text=\"(87) 89999-8998\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoTelefone;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Masculino\"]/android.view.ViewGroup[2]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoSexoMasculino;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"@undefined/input\" and @text=\"61.932-600\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoCep;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"@undefined/input\" and @text=\"Número\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoNumero;

    @AndroidFindBy(accessibility = "SALVAR")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement btnSalvar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tudo certo!\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnSucessoTudoCerto;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cadastro atualizado com sucessso.\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnSucesso;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"O processo falhou.\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnFalhaProcesso;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Por favor, revise seus dados e tente novamente.\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnFalha;

    public void escreverCampoNome(String nome){
        campoNome.click();
        campoNome.sendKeys(nome);
    }

    public void escreverCampoSobrenome(String sobrenome){
        campoSobrenome.click();
        campoSobrenome.sendKeys(sobrenome);
    }

    public void escreverCampoGrupoSanguineo (String gruposanguineo){
        campoGrupoSanguineo.click();
        campoGrupoSanguineo.sendKeys(gruposanguineo);
    }

    public void escreverCampoTelefone (String Telefone){
        campoTelefone.click();
        campoTelefone.sendKeys(Telefone);
    }

    public void selecionarSexoMasculino (){
        campoSexoMasculino.click();
    }

    public void escreverCampoCep (String cep){
        campoCep.click();
        campoCep.sendKeys(cep);
    }

    public void escreverCampoNumero (String numero){
        campoNumero.click();
        campoNumero.sendKeys(numero);
    }

    public void btnSalvar (){
        btnSalvar.click();
    }

    public String msnSucesso(){
        return msnSucessoTudoCerto.getText() +" "+ msnSucesso.getText();
    }

    public String msnFalha(){
        return msnFalhaProcesso.getText() +" "+ msnFalha.getText();
    }

}
