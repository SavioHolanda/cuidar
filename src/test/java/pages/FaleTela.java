package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FaleTela {
    public FaleTela(final AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Fale com a gente\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement linkFale;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Nome completo\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoNome;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Telefone Celular\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoCelular;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Informe seu e-mail\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Não recebi a senha provisória\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement opcaoNaoSenhaProvisoria;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tela travada/em carregamento\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement opcaoTelaTravada;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Outros\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement opcaoOutro;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Descreva a ocorrência\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement campoOcorrencia;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ENVIAR\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement btnEnviar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CANCELAR\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement btnCancelar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sucesso\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnEnviadoSucesso;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Recebemos sua notificação e entraremos em contato em breve. Nosso horário de atendimento é de segunda a sexta, das 9h às 19h.\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnEnviadoSucesso2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Informe o seu nome\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtObgNome;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Informe o seu telefone\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtObgTel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Informe o seu email\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtObgEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Selecione sua dúvida\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtObgDuvida;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Informe o problema\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtObgProblema;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Será realizado contato através do Telefone e/ou e-mail informado\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtCttViaTelOuEmail;

    public void clicarLinkFale() {
        linkFale.click();
    }

    public void espere(int numero) throws InterruptedException {
            Thread.sleep(numero * 1000L);
    }

    public void escreverNome(String nome) {
        campoNome.click();
        campoNome.sendKeys(nome);
    }

    public void escreverCelular(String celular) {
        campoCelular.click();
        campoCelular.sendKeys(celular);
    }

    public String txtCel(){
        return campoCelular.getText();
    }

    public void escreverEmail(String email) {
        campoEmail.click();
        campoEmail.sendKeys(email);
    }

    public void selecionarOpcaoTelaTravada() {
        opcaoTelaTravada.click();
        opcaoTelaTravada.click();
    }

    public void selecionarOpcaoOutro() {
        opcaoOutro.click();
    }

    public void escreverOcorrencia(String ocorrencia) {
        campoOcorrencia.click();
        campoOcorrencia.sendKeys(ocorrencia);
    }

    public void clicarBtnEnviar() {
        btnEnviar.click();
    }

    public void clicarBtnCancelar() {
        btnCancelar.click();
    }

    public String mensagemSucesso() {
        return msnEnviadoSucesso.getText() + " " + msnEnviadoSucesso2.getText();
    }

    public String msnObgNome() {
        return txtObgNome.getText();
    }

    public String msnObgTel() {
        return txtObgTel.getText();
    }

    public String msnObgEmail() {
        return txtObgEmail.getText();
    }

    public String msnObgDuvida() {
        return txtObgDuvida.getText();
    }

    public String msnObgProblema() {
        return txtObgProblema.getText();
    }

    public void cttViaTelOuEmail(){
        txtCttViaTelOuEmail.click();
    }
}