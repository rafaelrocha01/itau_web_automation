package org.br.itau.page;

import org.br.itau.core.BasePage;
import org.br.itau.core.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrincipalPage extends BasePage {

    @FindBy(xpath = "//button[@title = 'Marca']")
    private WebElement cmbMarca;
    @FindBy(xpath = "//button[@title = 'Modelo']")
    private WebElement cmbModelo;
    @FindBy(id = "anunciosNovos")
    private WebElement chkZero;

    public PrincipalPage(RemoteWebDriver driver){
        seleniumLib = new SeleniumLib(driver);
        PageFactory.initElements(driver, this);
    }

    public void selecionaMarca(String marca){
        seleniumLib.clicar(cmbMarca);
        seleniumLib.clicarPorTexto(marca);
    }

    public void selecionaModelo(String modelo){
        //seleniumLib.clicar(cmbModelo);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seleniumLib.setScrollToElement(seleniumLib.driver.findElement(By.xpath("//*[text() = '"+modelo+"']")));
        seleniumLib.clicarPorTexto(modelo);
    }

    public void clicarBuscar(){
        seleniumLib.clicarPorTexto("Buscar");
    }

    public void desmarcarCheckZero(){
        seleniumLib.clicar(chkZero);
    }
}
