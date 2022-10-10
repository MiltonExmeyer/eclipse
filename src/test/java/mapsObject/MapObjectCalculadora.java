package mapsObject;

import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectCalculadora extends ClaseBase
{

	public MapObjectCalculadora(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	//ELEMENTOS DE LA PAG PRINCIPAL
		//BTN OPERACIONA BASICAS
		protected By btnOperaciones =By.xpath("//android.widget.ImageButton[@content-desc='{0}']");

		//BTN RESULTADO
		protected By btnResult = By.id("com.google.android.calculator:id/eq");
		
		//BTN NUMEROS
		protected By btnNumeros= By.xpath("//android.widget.ImageButton[@content-desc='{0}']");
}
