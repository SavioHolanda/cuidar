package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.TestBase;

import java.net.MalformedURLException;

public class EsqueciMinhaSenhaTest extends TestBase {

    @Before
    public void setUpTest() throws MalformedURLException {
        setUp();
    }

    @Test
    public void testDigitarUmCpfCadastradoNoCampoDigiteSeuCfEEnvialo(){
        loginTela.escreverCampoCpf("30480525005");
        loginTela.clickBtnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("30480525005");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Sucesso!Sua senha foi atualizada com sucesso!\n" +
                "\n" +
                "[ATENÇÃO] Você receberá uma Senha Provisória!\n" +
                "\n" +
                "O Envio da Senha Provisória é feita por: \n" +
                "- SMS (mensagem no seu celular)\n" +
                "- E-mail (seu e-mail cadastro no aplicativo",esqueciMinhaSenhaTela.msnSucesso());
    }

    @Test
    public void testDigitarUmCPfNaoCadastradoNoCampoDigiteSeuCpfEEnvialo(){
        loginTela.escreverCampoCpf("30480525005");
        loginTela.clickBtnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("14457748912");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Atenção!Usuário não encontrado.",esqueciMinhaSenhaTela.msnUsuarioNaoEncontrado());
    }

    @Test
    public void testDigitarLetrasECaracteresEspeciaisNoCampoDigiteSeuCpf(){
        loginTela.escreverCampoCpf("30480525005");
        loginTela.clickBtnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf(",.-a");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Digite seu CPF",esqueciMinhaSenhaTela.txtCampoCpf());
    }

    @Test
    public void testDeixarOCampoDigiteSeuCpfEmBranco(){
        loginTela.escreverCampoCpf("30480525005");
        loginTela.clickBtnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("CPF obrigatório",esqueciMinhaSenhaTela.txtCampoCpfEmBranco());
    }

    @Test
    public void testDigitarUmCpfIncompletoNoCampoDigiteSeuCpf(){
        loginTela.escreverCampoCpf("30480525005");
        loginTela.clickBtnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("0297");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Digite o CPF completo",esqueciMinhaSenhaTela.txtCampoCpfIncompleto());
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}