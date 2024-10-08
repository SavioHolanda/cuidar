package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ultis.TestBase;

import java.net.MalformedURLException;

public class FaleTest extends TestBase {

        @Before
        public void setUpTest() throws MalformedURLException {
            setUp();
        }

        @Test
        public void testRelatarUmProblemaTecnicoCorretamentePreenchendoOsCamposNomeTelefoneEmailProblemaEMsnEEnviar(){
                loginTela.clickBtnAvancarBemVindo();
                faleTela.clicarLinkFale();
                faleTela.escreverNome("Fulado de tal");
                faleTela.escreverCelular("99999999999");
                faleTela.escreverEmail("teste@gmail.com");
                faleTela.escreverOcorrencia("Mensagem teste para enviar um problema a ser reportado.");
                faleTela.selecionarOpcaoTelaTravada();
                faleTela.clicarBtnEnviar();

                Assert.assertEquals("Sucesso Recebemos sua notificação e entraremos em contato em breve. Nosso horário de atendimento é de segunda a sexta, das 9h às 19h.",faleTela.mensagemSucesso());
        }

        @Test
        public void testRelatarUmProblemaTecnicoInvalidoNaoPreenchendoOsCamposNomeTelefoneEmailProblemaEMsnEEnviar(){
                loginTela.clickBtnAvancarBemVindo();
                faleTela.clicarLinkFale();
                faleTela.escreverNome("");
                faleTela.escreverCelular("");
                faleTela.escreverEmail("");
                faleTela.escreverOcorrencia("");
                faleTela.cttViaTelOuEmail();
                faleTela.clicarBtnEnviar();

                Assert.assertEquals("Informe o seu nome",faleTela.msnObgNome());
                Assert.assertEquals("Informe o seu telefone",faleTela.msnObgTel());
                Assert.assertEquals("Informe o seu email",faleTela.msnObgEmail());
                Assert.assertEquals("Selecione sua dúvida",faleTela.msnObgDuvida());
                Assert.assertEquals("Informe o problema",faleTela.msnObgProblema());
        }

        @Test
        public void testRelatarUmProblemaComCaracteresespeciaisOuLetrasNoCampoTelefone(){
                loginTela.clickBtnAvancarBemVindo();
                faleTela.clicarLinkFale();
                faleTela.escreverCelular("%./@!test,");
                faleTela.cttViaTelOuEmail();

                Assert.assertEquals("Telefone Celular",faleTela.txtCel());
        }
        @Test
        public void testRelatarUmCliqueNoBotaoCancelar(){
                loginTela.clickBtnAvancarBemVindo();
                faleTela.clicarLinkFale();
                faleTela.clicarBtnCancelar();

                Assert.assertEquals("CPF",loginTela.textoCampoCpf());
        }

        @After
        public void tearDownTest() {
        tearDown();
        }
}