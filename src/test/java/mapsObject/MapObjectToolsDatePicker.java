package mapsObject;

import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectToolsDatePicker extends ClaseBase
{

	public MapObjectToolsDatePicker(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	// ELEMENTOS DE LA PAG
	// BTN WIDGETS
	protected By btnWidgets = By.xpath("//android.widget.TextView[@text='Widgets']");
	//BTN  DATA PICKER
	protected By btnDate = By.xpath("//android.widget.TextView[@text='Date Picker']");
	// SELECT DATA
	protected By txtFecha = By.xpath("//android.widget.EditText[@resource-id='datePickerMonthYearInput']");
	// SELECT DATA AND TIME
	protected By txtFechaData = By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");
}
