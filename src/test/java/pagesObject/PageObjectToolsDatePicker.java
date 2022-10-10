package pagesObject;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectToolsDatePicker;

public class PageObjectToolsDatePicker extends MapObjectToolsDatePicker {

	public PageObjectToolsDatePicker(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void sistemaDate(File rutaCarpeta, String evidencia) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
				//SCROLL A BTN WINDGETS
				scrollVertical(rutaCarpeta, 361, 1219, 400, 3);
				tiempoEspera(1000);
				//BTN WIDGETS
				clickTime(btnWidgets, rutaCarpeta, 1, evidencia,"Se ingresa a la seccion Widgets");
				//BTN DATA
				clickTime(btnDate,rutaCarpeta,1, evidencia, "Se ingresa a la opcion Date Picker");

				//LLAMADO FECHA DEL SISTEMA
				String fecha = fechaHoraToolsQa();
				String[] fechaV = fecha.split("-");
				//PARCEO DE VALORES 
				int mes  = Integer.parseInt(fechaV[0]);
				int dia  = Integer.parseInt(fechaV[1]);
				int anno  = Integer.parseInt(fechaV[2]);
				int hora = Integer.parseInt(fechaV[3]);
				int min = Integer.parseInt(fechaV[4]);
				int seg = Integer.parseInt(fechaV[5]);
				
				mes =mes-1;
				dia =dia-1;
				anno = anno-1;
				hora = hora -1;
				
				//CREAR VARIABLES PARA CADA IMPUT
				String fechaMenor = mes+"/"+dia+"/"+anno;
				String fechaMenorHora = mes+"/"+dia+"/"+anno+" "+hora+":"+min+":"+seg;
				
				//BORRAR EL CONTENIDO TXT
				borrartxt(txtFecha, rutaCarpeta, evidencia, "Se borra el contenido del cuadro Select Date");
				tiempoEspera(1000);
				//ENVIAR PRIMER IMPUT
				sendKey(fechaMenor,txtFecha, rutaCarpeta, evidencia, "Se ingresa la fecha establecida");
				tiempoEspera(1000);
				
				//BORRAR CONTENIDO DEL TXT
				borrartxt(txtFechaData,rutaCarpeta, evidencia, "Se borra el contenido del cuadro Date And Time");
				//ENVIAR SEGUNDO IMPUT
				sendKey(fechaMenorHora,txtFechaData, rutaCarpeta, evidencia, "Se ingresa la fecha establecida");
				tiempoEspera(2000);
				
			}
}