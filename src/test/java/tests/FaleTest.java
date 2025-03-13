package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.TestBase;

public class FaleTest extends TestBase {

        private static final String CAMPO_VAZIO = "";

        @Test
        public void testRelatarUmProblemaTecnicoCorretamentePreenchendoOsCamposNomeTelefoneEmailProblemaEMsnEEnviando(){
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
        public void testRelatarUmProblemaTecnicoInvalidoNaoPreenchendoOsCamposNomeTelefoneEmailProblemaEMsnEEnviando(){
                faleTela.clicarLinkFale();
                faleTela.escreverNome(CAMPO_VAZIO);
                faleTela.escreverCelular(CAMPO_VAZIO);
                faleTela.escreverEmail(CAMPO_VAZIO);
                faleTela.escreverOcorrencia(CAMPO_VAZIO);
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
                faleTela.clicarLinkFale();
                faleTela.escreverCelular("%./@!test,");
                faleTela.cttViaTelOuEmail();

                Assert.assertEquals("Telefone Celular",faleTela.txtCel());
        }

        @Test
        public void testRelatarUmCliqueNoBotaoCancelar(){
                faleTela.clicarLinkFale();
                faleTela.clicarBtnCancelar();

                Assert.assertEquals("Digite seu CPF",loginTela.textoCampoCpf());
        }

        @Test
        public void testRelatarUmProblemaTecnicoCorretamentePreenchendoOsCamposNomeTelefoneEmailProblemaEMsnEEnviandoNaTelaDeLogin() throws InterruptedException {
                loginTela.escreverCampoCpf("48135484070");
                loginTela.btnAvancar();
                espere(2);
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
        public void testRelatarUmProblemaTecnicoInvalidoNaoPreenchendoOsCamposNomeTelefoneEmailProblemaEMsnEEnviandoNaTelaDeLogin() throws InterruptedException {
                loginTela.escreverCampoCpf("48135484070");
                loginTela.btnAvancar();
                espere(2);
                faleTela.clicarLinkFale();
                faleTela.escreverNome(CAMPO_VAZIO);
                faleTela.escreverCelular(CAMPO_VAZIO);
                faleTela.escreverEmail(CAMPO_VAZIO);
                faleTela.escreverOcorrencia(CAMPO_VAZIO);
                faleTela.cttViaTelOuEmail();
                faleTela.clicarBtnEnviar();

                Assert.assertEquals("Informe o seu nome",faleTela.msnObgNome());
                Assert.assertEquals("Informe o seu telefone",faleTela.msnObgTel());
                Assert.assertEquals("Informe o seu email",faleTela.msnObgEmail());
                Assert.assertEquals("Selecione sua dúvida",faleTela.msnObgDuvida());
                Assert.assertEquals("Informe o problema",faleTela.msnObgProblema());
        }

        @Test
        public void testRelatarUmProblemaComCaracteresespeciaisOuLetrasNoCampoTelefoneNaTelaDeLogin() throws InterruptedException {
                loginTela.escreverCampoCpf("48135484070");
                loginTela.btnAvancar();
                espere(2);
                faleTela.clicarLinkFale();
                faleTela.escreverCelular("%./@!test,");
                faleTela.cttViaTelOuEmail();

                Assert.assertEquals("Telefone Celular",faleTela.txtCel());
        }

        @Test
        public void testRelatarUmCliqueNoBotaoCancelarNaTelaDeLogin() throws InterruptedException {
                loginTela.escreverCampoCpf("48135484070");
                loginTela.btnAvancar();
                espere(2);
                faleTela.clicarLinkFale();
                faleTela.clicarBtnCancelar();

                Assert.assertEquals("481.354.840-70", loginTela.campoCpfLimparTxt());
        }
}