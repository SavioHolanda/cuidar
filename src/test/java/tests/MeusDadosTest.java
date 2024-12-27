package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomeTela;
import utils.TestBase;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

public class MeusDadosTest extends TestBase {
    @Before
    public void setUpTest() throws MalformedURLException {
        setUp();
    }

    @Test
    public void testRealizarOPreenchimentoCorretamenteDeTodosOsCamposESalvar(){
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        loginTela.btnAvancar();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();
        loginTela.ClicarPermicaoLocalizacaoDuranteUsoApp();
        loginTela.ClicarPermicaoNotificacao();
        loginTela.ClicarPermicaoFotoVideoDuranteUsoApp();
        homeTela.clicarMeusDados();

    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
