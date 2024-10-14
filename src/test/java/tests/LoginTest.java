package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomeTela;
import ultis.TestBase;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends TestBase {

    @Before
    public void setUpTest() throws MalformedURLException {
        setUp();
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCPFComCPFCadastradoEmMaisDeUmaEntidadeEClicarEmAvancar() throws InterruptedException {
        loginTela.escreverCampoCpf("46393153091");
        loginTela.clickBtnAvancar();
        espere(3);
        loginTela.visualizarEmpresas();

        List<String> empresas = loginTela.visualizarEmpresas();
        List<String> empresasEsperadas = Arrays.asList("NHG", "DIMENSA S.A. 149");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCPFComCPFCadastradoEmApenasUmaEntidadeEClicarEmAvancar(){
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();

        Assert.assertEquals("Senha", loginTela.campoSenha());
    }

    @Test
    public void testRealizarONaoPreenchimentoDoCampoCpfEClicarEmAvancar() {
        loginTela.clickBtnAvancar();

        List<String> empresas = loginTela.visualizarTxt();
        List<String> empresasEsperadas = Arrays.asList("Seja bem-vindo ao Cuid@r autocuidado", "Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!", "Preencha seu CPF para iniciar sua experiência.");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComCaracteresEspeciaisEClicarEmAvancar(){
        loginTela.escreverCampoCpf(",.-");
        loginTela.clickBtnAvancar();

        Assert.assertEquals("CPF", loginTela.textoCampoCpf());
    }

    @Test
    public void testRealizarAValidacaoDoTextoDeBoasVindas(){
        List<String> empresas = loginTela.visualizarTxt();
        List<String> empresasEsperadas = Arrays.asList("Seja bem-vindo ao Cuid@r autocuidado", "Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!", "Preencha seu CPF para iniciar sua experiência.");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoemApenasUmaentidade() {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());

        Assert.assertEquals("Permitir que o app Cuid@r autocuidado envie notificações?", homeTela.txtValidarAcessoAHome());
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoemMaisDeUmaentidade() {
        loginTela.escreverCampoCpf("02971008312");
        loginTela.clickBtnAvancar();
        loginTela.selecionarEmpresaNHG();
        loginTela.clickAvancarEmpresa();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());

        Assert.assertEquals("Permitir que o app Cuid@r autocuidado envie notificações?", homeTela.txtValidarAcessoAHome());
    }

    @Test
    public void testRealizarLoginAlterandoOCpfDoCampoCpf() throws InterruptedException {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.campoCpfLimpar();
        espere(2);

        Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
    }

    @Test
    public void testRealizarLoginComOCampoSenhaEmBranco() {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.clickBtnEntrar();

        Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
    }

    @Test
    public void testRealizarLoginComASenhaInvalida() {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.escreverSenha("senhaInvalida");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("O processo falhou. Usuário não encontrado ou senha incorreta.", loginTela.mensagemSenhaInvalida());
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}