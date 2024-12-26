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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Digite seu CPF\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement campoCpf;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"481.354.840-70\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement campoCpflimpar;

    @AndroidFindBy(accessibility = "Avançar")
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

    @AndroidFindBy(xpath = "//android.widget.ScrollView")
    //@iOSFindBy(xpath = "xx");
    private WebElement visualizarEmpresas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bem-vindo(a) ao nosso app!\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement txtBemVindo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement txt2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Por favor, aguarde! Estamos buscando suas informações.\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement msnTela1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Falta pouco! Estamos buscando suas configurações visuais.\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement msnTela2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reta final! Estamos buscando suas funcionalidades.\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement msnTela3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"O processo falhou.\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement msnSenhaInvalida;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Usuário não encontrado ou senha incorreta.\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement msnSenhaInvalida1;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    //@iOSFindBy(xpath = "xx");
    private WebElement termoUso;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Aceitar\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement aceitarTermoUso;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Usuário titular \"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoNome;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Titular\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoSobrenome;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"10/09/1996\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoNascimento;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Masculino\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstBtnSexoMasculino;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"(01) 10011-9999\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoTelefone;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"ruht2083@uorak.com\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"61.932-600\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoCep;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoCepVazio;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.view.View/android.widget.EditText[4]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoEndereco;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.view.View/android.widget.EditText[5]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoCidade;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.view.View/android.widget.EditText[6]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoEstado;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View/android.view.View/android.widget.EditText[7]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstCampoNumero;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Enviar\"]")
    //@iOSFindBy(xpath = "xx");
    private WebElement firstBtnEnviar;

    public void escreverCampoCpf(String cpf){
        campoCpf.click();
        campoCpf.sendKeys(cpf);
    }

    public String textoCampoCpf(){
        return campoCpf.getText();
    }

    public void btnAvancar(){
        btnAvancarLogin.click();
    }

    public void selecionarEmpresaNHG(){
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
        return txtbemvindo;
    }

    public String msnTela1(){
        return msnTela1.getText();
    }

    public String msnTela2(){
        return msnTela2.getText();
    }

    public String msnTela3(){
        return msnTela3.getText();
    }

    public void campoCpfLimpar(){
        campoCpflimpar.clear();
    }

    public String campoCpfLimparTxt(){
        return campoCpflimpar.getText();
    }

    public String mensagemSenhaInvalida() {
        return msnSenhaInvalida.getText() + " " + msnSenhaInvalida1.getText();
    }

    public void clickTermoUso() {
        termoUso.click();
    }

    public void clickAceitarTermoUso() {
        aceitarTermoUso.click();
    }

    public void escreverCampoNome(String nome) {
        firstCampoNome.sendKeys(nome);
    }

    public void escreverCampoSobrenome(String sobrenome) {
        firstCampoSobrenome.sendKeys(sobrenome);
    }

    public void escreverCampoNascimento(String sobrenome) {
        firstCampoNascimento.sendKeys(sobrenome);
    }

    public void selecionarSexoBiologico() {
        firstBtnSexoMasculino.click();
    }

    public void escreverCampoTelefone(String telefone) {
        firstCampoTelefone.sendKeys(telefone);
    }

    public void escreverCampoEmail(String email) {
        firstCampoEmail.sendKeys(email);
    }

    public void limparCampoCep() {
        firstCampoCep.clear();
    }

    public void escreverCampoCep(String cep) {
        firstCampoCepVazio.sendKeys(cep);
    }

    public void escreverCampoEndereco(String endereco) {
        firstCampoEndereco.sendKeys(endereco);
    }

    public void escreverCampoCidade(String cidade) {
        firstCampoCidade.sendKeys(cidade);
    }

    public void escreverCampoEstado(String estado) {
        firstCampoEstado.sendKeys(estado);
    }

    public void escreverCampoNumero(String numero) {
        firstCampoNumero.sendKeys(numero);
    }

    public void clicarBtnEnviar() {
        firstBtnEnviar.click();
    }

}