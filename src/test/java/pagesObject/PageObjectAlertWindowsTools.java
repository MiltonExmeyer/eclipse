package pagesObject;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectAlertWindowsTools;

public class PageObjectAlertWindowsTools extends MapObjectAlertWindowsTools {

	public PageObjectAlertWindowsTools(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void alertas(String input ,String evidencia, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//SCROLL A BTN ALERTS
		scrollVertical(rutaCarpeta, 361, 1219, 400, 2);
		tiempoEspera(1000);
		//BTN ALERTS AND FRAME Y WINDOWS
		clickTime(btnAlertsFrame, rutaCarpeta, 1, evidencia, "Se da click en el boton Alerts, Frame & Windows");
		//BTN ALERTS 
		clickTime(btnAlertsIni,rutaCarpeta,1, evidencia,"Se ingresa a la seccion Alerts");
		
		//SELECCIONAR PRIMER ALERT
		clickTime(btnAlerts, rutaCarpeta,1, evidencia, "Se selecciona el primer alert");
		clickTime(btnAceptar, rutaCarpeta, 1, evidencia, "Se acepta el alert");
		
		//SELECCIONAR SEGUNDO ALERT
		clickTime(btnAlertsTimer, rutaCarpeta,6, evidencia,"Se selecciona el segundo alert");
		clickTime(btnAceptar, rutaCarpeta, 1, evidencia, "Se acepta el alert");
		
		//SELECCIONAR TERCER ALERT
		clickTime(btnAlertsConfirm, rutaCarpeta,1, evidencia, "Se selecciona el tercer alert");
		//OPCION CANCELAR
		clickTime(btnCancelar, rutaCarpeta, 1, evidencia, "Se cancela el alert");
		//SELECCIONAR TERCER ALERT
		clickTime(btnAlertsConfirm, rutaCarpeta,1, evidencia, "Se selcciona el tercer alert");
		//OPCION ACEPTAR
		clickTime(btnAceptar, rutaCarpeta, 1, evidencia, "Se acepta el alert");
		
		//SELECCIONAR CUARTO ALERT
		clickTime(btnAlertsName, rutaCarpeta,1, evidencia, "Se selcciona el cuarto alert");
		//ENVIAR IMPUT DESDE EL EXCEL
		sendKey(input ,txtInput, rutaCarpeta, evidencia, "Ser envia el un valor : " +input);
		//OPCION ACEPTAR
		clickTime(btnAceptar, rutaCarpeta, 2, evidencia, "Se acepta el alert");	
	}
}
