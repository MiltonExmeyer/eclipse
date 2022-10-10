package pagesObject;

import java.io.File;
import java.io.IOException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectGoogleChrome;

public class PageObjectGoogleChrome extends MapObjectGoogleChrome {

	public PageObjectGoogleChrome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void buscador(String url, String evidencia, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//OPCIONES DEL NAVEGADOR
		click(btnOpciones, rutaCarpeta, evidencia, "Abrir las opciones del buscador");
		//BOTON NUEVA PESTAÑA
		clickTools(btnNuevaPestaña, rutaCarpeta, evidencia, "Adicionar nueva pestaña");
		//SELECCIONAR EL CUADRO DE TEXTO
		click(txtBuscar, rutaCarpeta, evidencia, "Se selecciona el cuado de busqueda");
		//ENVIAR LA URL DESDE EL EXCEL
		sendKey(url, txtBuscarDos, rutaCarpeta, evidencia, "Se ingresa la url");
		tiempoEspera(2000);
		//TOUCH PARA ENVIAR EL TEXTO
		tocarPantalla(664, 1401);
		tiempoEspera(2000);
	}
	
}
