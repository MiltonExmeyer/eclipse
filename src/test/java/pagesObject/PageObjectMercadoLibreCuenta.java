package pagesObject;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectMercadoLibreCuenta;


public class PageObjectMercadoLibreCuenta extends MapObjectMercadoLibreCuenta {

	public PageObjectMercadoLibreCuenta(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void formulario(String nombre, String apellido, String documento, String email, String clave, String evidencia, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//BOTON CREAR CUENTA
		validacion(btnCrearCuenta, rutaCarpeta, evidencia, "Se Selecciona el boton crear cuenta");
		tiempoEspera(2000);
		//INGRESAR DATOS DEL FORMULARIO
		click(txtNombre,rutaCarpeta, evidencia, "Se selecciona el campo para ingresar el nombre");
		sendKey(nombre, txtNombre, rutaCarpeta, evidencia, "Se ingresa el nombre");
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(apellido, txtApellido, rutaCarpeta, evidencia,"Se ingresa el apellido ");
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(documento, txtDocumento, rutaCarpeta, evidencia, "Se ingresa el documento");
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(email, txtEmail, rutaCarpeta, evidencia, "Se ingresa el email ");
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(clave, txtClave, rutaCarpeta, evidencia, "Se ingresa la calve");
		tocarPantalla(50, 280);
		tiempoEspera(500);
		
		//SCROLL VERTICAL
		scrollVertical(rutaCarpeta, 328,1100, 600, 1);
		tiempoEspera(2000);
		click(checkboxAceptarTerm, rutaCarpeta, evidencia, "Se aceptan los terminos y condiciones");
		tiempoEspera(500);
		clickTime(btnCatcha, rutaCarpeta, 2, evidencia, "S acepta el Captcha");
		tiempoEspera(2000);
		
	}
	
	public void crearCuenta(String evidencia, File rutaCarpeta ) throws Exception
	{
		//ACCIONES
		//ACEPTAR COOKIES
		validacion(btnEntendido, rutaCarpeta, evidencia, "Se aceptan las cookies");
		//BTN DE OPCIONES
		click(btnOptions, rutaCarpeta, evidencia, "Se desplegan las opciones para el usuario");
		//BTN CREAR CUENTA
		click(btnCrearCuentaDirect, rutaCarpeta, evidencia, "Se selecciona Crea tu cuenta");
		tiempoEspera(2000);
		click(btnPeru, rutaCarpeta, evidencia, "Se confirma que se desea requistrar en Peru");
		tiempoEspera(1000);
	}
	
	}
	

