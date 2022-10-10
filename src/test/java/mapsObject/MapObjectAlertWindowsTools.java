package mapsObject;

import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectAlertWindowsTools extends ClaseBase
{

	public MapObjectAlertWindowsTools(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}
	

	// ELEMENTOS DE LA PAG
	protected By btnAlertsFrame = By.xpath("//android.widget.TextView[@text='Alerts, Frame & Windows']");
	protected By btnAlertsIni = By.xpath("//android.widget.TextView[@text='Alerts']");

	// ALERT 1
	protected By btnAlerts = By.xpath("//android.widget.Button[@resource-id='alertButton']");
	protected By btnAceptar = By.xpath("//android.widget.Button[@text='Aceptar']");
	// ALERT 2
	protected By btnAlertsTimer = By.xpath("//android.widget.Button[@resource-id='timerAlertButton']");
	// ALERT 3
	protected By btnAlertsConfirm = By.xpath("//android.widget.Button[@resource-id='confirmButton']");
	protected By btnCancelar = By.xpath("//android.widget.Button[@text='Cancelar']");
	// ALERT 4
	protected By btnAlertsName = By.xpath("//android.widget.Button[@resource-id='promtButton']");
	protected By txtInput = By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/js_modal_dialog_prompt']");
}
