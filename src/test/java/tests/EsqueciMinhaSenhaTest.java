package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.TestBase;

public class EsqueciMinhaSenhaTest extends TestBase {

    private static final String CAMPO_CPF_STRING = "30480525005";

    @Test
    public void testDigitarUmCpfCadastradoNoCampoDigiteSeuCfEEnvialo(){
        loginTela.escreverCampoCpf(CAMPO_CPF_STRING);
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf(CAMPO_CPF_STRING);
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
        loginTela.escreverCampoCpf(CAMPO_CPF_STRING);
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("02977711112");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Atenção!Usuário não encontrado.",esqueciMinhaSenhaTela.msnUsuarioNaoEncontrado());
    }

    @Test
    public void testDigitarLetrasECaracteresEspeciaisNoCampoDigiteSeuCpf(){
        loginTela.escreverCampoCpf(CAMPO_CPF_STRING);
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf(",.-a");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Digite seu CPF",esqueciMinhaSenhaTela.txtCampoCpf());
    }

    @Test
    public void testDeixarOCampoDigiteSeuCpfEmBranco(){
        loginTela.escreverCampoCpf(CAMPO_CPF_STRING);
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("CPF obrigatório",esqueciMinhaSenhaTela.txtCampoCpfEmBranco());
    }

    @Test
    public void testDigitarUmCpfIncompletoNoCampoDigiteSeuCpf(){
        loginTela.escreverCampoCpf(CAMPO_CPF_STRING);
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        esqueciMinhaSenhaTela.clickEqueceuSuaSenha();
        esqueciMinhaSenhaTela.escreverCpf("0297");
        esqueciMinhaSenhaTela.clickbtnEnviar();

        Assert.assertEquals("Digite o CPF completo",esqueciMinhaSenhaTela.txtCampoCpfIncompleto());
    }
}