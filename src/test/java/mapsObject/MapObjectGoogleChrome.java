package mapsObject;

import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectGoogleChrome extends ClaseBase {

	public MapObjectGoogleChrome(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// ELEMENTOS DE LA PAG PRINCIPAL
	//BTN OPCIONES
	protected By btnOpciones = By.id("com.android.chrome:id/menu_button");
	//BTN NUEVA PESTAÑA
	protected By btnNuevaPestaña = By.xpath("//android.widget.TextView[@text='Nueva pestaña']");
	//CAMPO DE BUSQUEDA
	protected By txtBuscar = By.id("com.android.chrome:id/search_box_text");
	// CAMPO DE BUSQUEDA SELECCIONADO
	protected By txtBuscarDos = By.id("com.android.chrome:id/url_bar");
}
