package pagesObject;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectMercadoLibreHome;

public class PageObjectMercadoLibreHome extends MapObjectMercadoLibreHome {
  public PageObjectMercadoLibreHome(AppiumDriver<MobileElement> driver) 
  {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
  }

  public void home(String producto, String evidencia, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
	  	//ACEPTAR COOKIES
	  	validacion(btncookies, rutaCarpeta, evidencia, "Se aceptan las cookies");
		//CLICKAR CAMPO BUSCAR
		click(txtBusqueda, rutaCarpeta, evidencia, "Se seleccioan el cuadro de busqueda");
		//ENVIAR PRODUCTO DESDE EL EXCEL
		sendKey(producto, txtBusqueda, rutaCarpeta, evidencia, "Se ingresa el producto a buscar");
		tiempoEspera(500);
		//CLICKAR EN ENVIAR
		tocarPantalla(664, 1401);
		tiempoEspera(1000);
		//SELECCIONAR EL PRIMER ELEMENTO
		click(imgPrimerElemento, rutaCarpeta, evidencia,"Se selcciona el primer elemento disponible");
		//ESCROLL VERTICAL CORTO 
		scrollVertical(rutaCarpeta, 350, 1138, 221, 1);
		tiempoEspera(2000);
		//BOTON COMPRAR AHORA 
		click(btnComprarAhora, rutaCarpeta, evidencia, "Se selecciona comprar ahora ");		

	}
}
