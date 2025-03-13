package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.TestBase;

public class MeusDadosTest extends TestBase {

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
        meusDadosTela.escreverCampoNome("Sávio");
        meusDadosTela.escreverCampoSobrenome("Borges");
        meusDadosTela.escreverCampoGrupoSanguineo("Não");
        meusDadosTela.escreverCampoTelefone("87899998998");
        //meusDadosTela.selecionarSexoMasculino();
        scroll(0.5,0.7,0.5,0.3);
        meusDadosTela.escreverCampoCep("61932600");
        meusDadosTela.escreverCampoNumero("555");
        meusDadosTela.btnSalvar();

        Assert.assertEquals("Tudo certo! Cadastro atualizado com sucessso.", meusDadosTela.msnSucesso());
    }

    @Test
    public void testRealizarONaoPreenchimentoDosCamposObrigatoriosESalvar(){
        loginTela.escreverCampoCpf("48135484070");
        loginTela.btnAvancar();
        //loginTela.btnAvancar();
        loginTela.escreverSenha("Fale1234@");
        loginTela.clickBtnEntrar();
        loginTela.ClicarPermicaoLocalizacaoDuranteUsoApp();
        loginTela.ClicarPermicaoNotificacao();
        loginTela.ClicarPermicaoFotoVideoDuranteUsoApp();
        homeTela.clicarMeusDados();
        meusDadosTela.escreverCampoNome(" ");
        meusDadosTela.escreverCampoSobrenome(" ");
        meusDadosTela.escreverCampoGrupoSanguineo(" ");
        meusDadosTela.escreverCampoTelefone(" ");
        //meusDadosTela.selecionarSexoMasculino();
        scroll(0.5,0.7,0.5,0.3);
        meusDadosTela.escreverCampoCep(" ");
        //meusDadosTela.escreverCampoNumero(" ");
        meusDadosTela.btnSalvar();

        Assert.assertEquals("O processo falhou. Por favor, revise seus dados e tente novamente.", meusDadosTela.msnFalha());
    }
}