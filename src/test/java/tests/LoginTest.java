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
    public void testRealizarOPreenchimentoDoCampoCPFComCPFCadastradoEmMaisDeUmaEntidadeEClicarEmAvancar(){
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("46393153091");
        loginTela.clickBtnAvancar();
        loginTela.visualizarEmpresas();

        List<String> empresas = loginTela.visualizarEmpresas();
        List<String> empresasEsperadas = Arrays.asList("NHG", "DIMENSA S.A. 149");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCPFComCPFCadastradoEmApenasUmaEntidadeEClicarEmAvancar(){
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();

        Assert.assertEquals("Senha", loginTela.campoSenha());
    }

    @Test
    public void testRealizarONaoPreenchimentoDoCampoCpfEClicarEmAvancar(){
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();

        Assert.assertEquals("Seja bem-vindo ao Cuid@r autocuidado", loginTela.txtBemVindo());
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComCaracteresEspeciaisEClicarEmAvancar(){
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf(",.-");
        loginTela.clickBtnAvancar();

        Assert.assertEquals("CPF", loginTela.txtBemVindo());
    }

    @Test
    public void testRealizarAValidacaoDoTextoDeBoasVindas(){
        loginTela.clickBtnAvancarBemVindo();

        List<String> empresas = loginTela.visualizarTxt();
        List<String> empresasEsperadas = Arrays.asList("Seja bem-vindo ao Cuid@r autocuidado", "Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!", "Preencha seu CPF para iniciar sua experiência.");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoemApenasUmaentidade() {
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());
        Assert.assertEquals("PERMITIR", homeTela.txtValidarAcessoAHome());
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoemMaisDeUmaentidade() {
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("02971008312");
        loginTela.clickBtnAvancar();
        loginTela.selecionarEmpresaNHG();
        loginTela.clickAvancarEmpresa();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());
        Assert.assertEquals("PERMITIR", homeTela.txtValidarAcessoAHome());
    }

    @Test
    public void testRealizarLoginAlterandoOCpfDoCampoCpf() {
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.campoCpfLimpar();

        Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
    }

    @Test
    public void testRealizarLoginComOCampoSenhaEmBranco() {
        loginTela.clickBtnAvancarBemVindo();
        loginTela.escreverCampoCpf("48135484070");
        loginTela.clickBtnAvancar();
        loginTela.clickBtnEntrar();

        Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}