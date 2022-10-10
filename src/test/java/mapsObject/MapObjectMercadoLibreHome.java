package mapsObject;

import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMercadoLibreHome extends ClaseBase {

	public MapObjectMercadoLibreHome(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	//ELEMENTOS DE LA PAG PRINCIPAL
	//CUADRO DE BUSQUEDA
	protected By txtBusqueda = By.xpath("//android.widget.EditText[@resource-id='cb1-edit']");
	//BTN ACEPAR COOKIES
	protected By btncookies =By.xpath("//android.widget.Button[@text='Entendido']");
	//XPATH PARA SELECIONAR EL PRIMER ELEMENTO
	protected By imgPrimerElemento = By.xpath("(//android.widget.TextView)[6]");
	// BTN COMPAR AHORA
	protected By btnComprarAhora = By.xpath("//android.widget.Button[@text='Comprar ahora']");

}
