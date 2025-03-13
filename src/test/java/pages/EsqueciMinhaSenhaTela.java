package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EsqueciMinhaSenhaTela {
    public EsqueciMinhaSenhaTela(final AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Esqueceu sua senha?\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
    private WebElement esqueceuSuaSenha;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Digite seu CPF\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement escreverCpf;

    @AndroidFindBy(accessibility = "ENVIAR")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement clicarBtnEnviar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sucesso!\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnSucesso;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sua senha foi atualizada com sucesso!\n" +
            "\n" +
            "[ATENÇÃO] Você receberá uma Senha Provisória!\n" +
            "\n" +
            "O Envio da Senha Provisória é feita por: \n" +
            "- SMS (mensagem no seu celular)\n" +
            "- E-mail (seu e-mail cadastro no aplicativo\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnSucesso1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Atenção!\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnUsuarioNaoEncontrado;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Usuário não encontrado.\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement msnUsuarioNaoEncontrado1;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Digite seu CPF\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtCampoCpf;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CPF obrigatório\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtCampoCpfEmBranco;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Digite o CPF completo\"]")
    @iOSXCUITFindBy(xpath = "xx")
    private WebElement txtCampoCpfIncompleto;

    public void clickEqueceuSuaSenha(){
        esqueceuSuaSenha.click();
    }

    public void escreverCpf(String cpf){
        escreverCpf.sendKeys(cpf);
    }

    public void clickbtnEnviar(){
        clicarBtnEnviar.click();
    }

    public String msnSucesso(){
        return msnSucesso.getText() + msnSucesso1.getText();
    }

    public String msnUsuarioNaoEncontrado(){
        return msnUsuarioNaoEncontrado.getText() + msnUsuarioNaoEncontrado1.getText();
    }

    public String txtCampoCpf(){
        return txtCampoCpf.getText();
    }

    public String txtCampoCpfEmBranco(){
        return txtCampoCpfEmBranco.getText();
    }

    public String txtCampoCpfIncompleto(){
        return txtCampoCpfIncompleto.getText();
    }
}