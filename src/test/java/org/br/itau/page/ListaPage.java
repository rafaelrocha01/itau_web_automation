package org.br.itau.page;

import org.br.itau.core.BasePage;
import org.br.itau.core.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPage extends BasePage {

    @FindBy(xpath = "//form[@id = 'anunciosForm']/ul/li")
    private List<WebElement> listaCarros;

    public ListaPage(RemoteWebDriver driver){
        seleniumLib = new SeleniumLib(driver);
        PageFactory.initElements(driver, this);
    }

    public int obterTamanhoLista(){
        return listaCarros.size();
    }

    public boolean validarPrecoModeloVeiculo(int pos, String preco, String modelo){
        return listaCarros.get(pos).findElements(By.xpath(".//a[@title = '"+modelo+"']/h3[text() = '"+preco+"']")).size() > 0;
    }

    public void gravarDadosDaListaDeVeiculos(String dirName) throws IOException {
        File f = new File(dirName);
        if(!f.exists()){
            f.createNewFile();
        }
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(dirName));
        for(WebElement item : listaCarros){
            seleniumLib.setScrollToElement(item);
            if(!item.getAttribute("class").equals("publicidade")) {

                String modelo = item.findElement(By.xpath(".//h2[@class = 'esquerda titulo_anuncio']//span")).getText();
                String ano = item.findElement(By.xpath(".//li[@class = 'primeiro']//span/../p")).getText().trim();
                String km = item.findElement(By.xpath(".//li[@class = 'usado']//p")).getText().trim();
                String cor = item.findElement(By.xpath(".//li//span[text() = 'Cor']/../p")).getText().trim();
                String cambio = item.findElement(By.xpath(".//li[@class = 'ultimo']/p")).getText().trim();
                String preco = item.findElement(By.xpath(".//h3[@class = 'direita preco_anuncio']")).getText();

                buffWrite.write("modelo:"+modelo+";"+"ano:"+ano+";"+"km:"+km+";"+"cor:"+cor+";"+"cambio:"+cambio+";"+"preco:"+preco+";");
                buffWrite.newLine();
            }
        }
        buffWrite.close();
    }
}
