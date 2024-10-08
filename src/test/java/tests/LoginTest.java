package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

    @After
    public void tearDownTest() {
        tearDown();
    }
}