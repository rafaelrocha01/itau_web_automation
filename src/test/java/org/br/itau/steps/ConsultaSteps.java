package org.br.itau.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.br.itau.core.BaseTest;
import org.br.itau.page.ListaPage;
import org.br.itau.page.PrincipalPage;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class ConsultaSteps extends BaseTest {

    public RemoteWebDriver driver;
    public ListaPage listaPage;
    public PrincipalPage principalPage;

    @Dado("que eu esteja na pagina incial do Icarros")
    public void queEuEstejaNaPaginaIncialDoIcarros() {
        driver = startTestCase();
        listaPage = new ListaPage(driver);
        principalPage = new PrincipalPage(driver);
    }

    @Quando("eu selecionar a marca {string} e o modelo {string}")
    public void euSelecionarAMarcaEOModelo(String arg0, String arg1) {
        principalPage.selecionaMarca(arg0);
        principalPage.selecionaModelo(arg1);
        principalPage.desmarcarCheckZero();
    }

    @E("eu clicar em buscar")
    public void euClicarEmBuscar() {
        principalPage.clicarBuscar();
    }

    @Entao("eu visualizarei uma lista com os mais de {string} carros")
    public void euVisualizareiUmaListaComOsMaisDeCarros(String arg0) {
        Assert.assertTrue(listaPage.obterTamanhoLista() >= 3);
        finishTestCase();
    }

    @Entao("eu poderei ver os dados salvos em um arquivo externo {string}")
    public void euPodereiVerOsDadosSalvosEmUmArquivoExterno(String arg0) {
    }

    @Dado("que eu tenha o arquivo criado no passo anterior")
    public void queEuTenhaOArquivoCriadoNoPassoAnterior() {
    }

    @Quando("eu buscar no site os dados salvos no arquivo")
    public void euBuscarNoSiteOsDadosSalvosNoArquivo() {
    }

    @Entao("eu poderei comparar se os valores continuam os mesmos")
    public void euPodereiCompararSeOsValoresContinuamOsMesmos() {
    }

    @Entao("eu visualizarei o valor a vista {string} do modelo {string} e o valor {string} a vista do modelo {string}")
    public void euVisualizareiOValorAVistaDoModeloEOValorAVistaDoModelo(String arg0, String arg1, String arg2, String arg3) {
        Assert.assertTrue(listaPage.validarPrecoModeloVeiculo(0, arg0, arg1));
        Assert.assertTrue(listaPage.validarPrecoModeloVeiculo(1, arg2, arg3));
        finishTestCase();
    }

    @Entao("eu poderei ver os dados salvos em um arquivo externo {string} com dados da primeira pagina")
    public void euPodereiVerOsDadosSalvosEmUmArquivoExternoComDadosDaPrimeiraPagina(String arg0) {
        try {
            listaPage.gravarDadosDaListaDeVeiculos(arg0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finishTestCase();
    }
}
