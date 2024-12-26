package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Api;
import utils.TestBase;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends TestBase {
    Api api = new Api();

    @Before
    public void setUpTest() throws MalformedURLException {
        setUp();
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCPFComCPFCadastradoEmMaisDeUmaEntidadeEClicarEmAvancar() throws InterruptedException {
        loginTela.escreverCampoCpf("46393153091");
        loginTela.btnAvancar();
        espere(3);
        loginTela.visualizarEmpresas();

        List<String> empresas = loginTela.visualizarEmpresas();
        List<String> empresasEsperadas = Arrays.asList("NHG", "DIMENSA S.A. 149");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCPFComCPFCadastradoEmApenasUmaEntidadeEClicarEmAvancar(){
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        loginTela.btnAvancar();

        Assert.assertEquals("Senha", loginTela.campoSenha());
    }

    @Test
    public void testRealizarONaoPreenchimentoDoCampoCpfEClicarEmAvancar() {
        loginTela.btnAvancar();

        List<String> empresas = loginTela.visualizarTxt();
        List<String> empresasEsperadas = Arrays.asList("Bem-vindo(a) ao nosso app!", "Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComCaracteresEspeciaisEClicarEmAvancar(){
        loginTela.escreverCampoCpf(",.-");
        loginTela.btnAvancar();

        Assert.assertEquals("Digite seu CPF", loginTela.textoCampoCpf());
    }

    @Test
    public void testRealizarAValidacaoDoTextoDeBoasVindas(){
        List<String> empresas = loginTela.visualizarTxt();
        List<String> empresasEsperadas = Arrays.asList("Bem-vindo(a) ao nosso app!", "Você terá acesso gratuito à nossa plataforma inteligente, dedicada a cuidar da sua saúde e bem-estar!");

        Assert.assertTrue(empresas.containsAll(empresasEsperadas));
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoemApenasUmaentidade() {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());

        Assert.assertEquals("Permitir que o app Cuid@r autocuidado acesse a localização deste dispositivo?", homeTela.txtValidarAcessoAHome());
    }

    @Test
    public void testRealizarLoginComSucessoComUmUsuarioCadastradoemMaisDeUmaentidade() {
        loginTela.escreverCampoCpf("02971008312");
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        loginTela.selecionarEmpresaNHG();
        loginTela.clickAvancarEmpresa();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());

        Assert.assertEquals("Permitir que o app Cuid@r autocuidado acesse a localização deste dispositivo?", homeTela.txtValidarAcessoAHome());
    }

    @Test
    public void testRealizarLoginAlterandoOCpfDoCampoCpf() throws InterruptedException {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        loginTela.campoCpfLimpar();
        espere(2);

        Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
    }

    @Test
    public void testRealizarLoginComOCampoSenhaEmBranco() {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        loginTela.clickBtnEntrar();

        Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
    }

    @Test
    public void testRealizarLoginComASenhaInvalida() {
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        loginTela.escreverSenha("senhaInvalida");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("O processo falhou. Usuário não encontrado ou senha incorreta.", loginTela.mensagemSenhaInvalida());
    }

    @Test
    public void testRealizarOPreenchimentoDoCampoCpfComUmCpfCadastradoEmApenasUmaEmpresaSendoOPrimeiroAcessoComFirstAcess() throws InterruptedException {
        api.LoginTela("62302731018","360");
        loginTela.escreverCampoCpf("62302731018");
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        espere(2);
        loginTela.clickTermoUso();
        loginTela.clickAceitarTermoUso();
        loginTela.selecionarSexoBiologico();
        movimentacoes();
        loginTela.escreverCampoEndereco("Rua Luiz Gonzaga dos Santos");
        loginTela.escreverCampoCidade("Maracanaú");
        loginTela.escreverCampoEstado("CE");
        loginTela.escreverCampoNumero("555");
        movimentacoes();
        loginTela.clicarBtnEnviar();
        espere(2);
        loginTela.btnAvancar();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();

        Assert.assertEquals("Por favor, aguarde! Estamos buscando suas informações.", loginTela.msnTela1());
        Assert.assertEquals("Falta pouco! Estamos buscando suas configurações visuais.", loginTela.msnTela2());
        Assert.assertEquals("Reta final! Estamos buscando suas funcionalidades.", loginTela.msnTela3());

        Assert.assertEquals("Permitir que o app Cuid@r autocuidado acesse a localização deste dispositivo?", homeTela.txtValidarAcessoAHome());
    }

    @After
    public void tearDownTest() {
        tearDown();
    }

}