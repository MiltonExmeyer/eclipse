package run;

import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import pagesObject.PageObjectGoogleChrome;
import pagesObject.PageOBjectCalculadora;
import pagesObject.PageObjectAlertWindowsTools;
import pagesObject.PageObjectMercadoLibreCuenta;
import pagesObject.PageObjectMercadoLibreHome;
import pagesObject.PageObjectToolsDatePicker;

public class Run {

	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;

	PageObjectMercadoLibreHome home;
	PageObjectMercadoLibreCuenta cuenta;
	PageOBjectCalculadora calculadora;
	PageObjectAlertWindowsTools alertsTools;
	PageObjectToolsDatePicker dateTools;
	PageObjectGoogleChrome google;

	ClaseBase claseBase;

	GenerarReportePdf generarReportePdf;

	String imagenMercadoLibre;
	String imagenReporteTools;
	String imagenReporteCalculadora;

	String platformName;
	String deviceName;
	String platformVersion;
	String noReset;
	String autoGrantPermissions;

	@BeforeClass

	@Parameters({ "rutaImagenReporteMercLibre", "rutaImagenReporteTools", "rutaImagenReporteCalculadora",
			"platformName", "deviceName", "platformVersion", "noReset", "autoGrantPermissions", "rutaOutput" })
	public void beforeClass(@Optional("default") String rutaImagenReporteMercLibre,
			@Optional("default") String rutaImagenReporteTools,
			@Optional("default") String rutaImagenReporteCalculadora, @Optional("default") String platformNameM,
			@Optional("default") String deviceNameM, @Optional("default") String platformVersionM,
			@Optional("default") String noResetM, @Optional("default") String autoGrantPermissionsM,
			@Optional("default") String rutaOutput) throws IOException

	{
		generarReportePdf = new GenerarReportePdf();
		imagenMercadoLibre = rutaImagenReporteMercLibre;
		imagenReporteTools = rutaImagenReporteTools;
		imagenReporteCalculadora = rutaImagenReporteCalculadora;

		platformName = platformNameM;
		deviceName = deviceNameM;
		platformVersion = platformVersionM;
		noReset = noResetM;
		autoGrantPermissions = autoGrantPermissionsM;
	}

	// ENTRAR A LA CALCULADORA Y REALIZAR LA OPERACION ASIGNADA
	@DataProvider(name = "calculadora")
	public Object[][] calculadora() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "calculadora");
		return arreglo;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "calculadora", priority = 1)
	public void calculadora(String appPackage, String appActivity, String ejecutar, String evidencia, String operacion,
			String valorUno, String valorDos) throws Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
					noReset, autoGrantPermissions);
			claseBase = new ClaseBase(driver);
			calculadora = new PageOBjectCalculadora(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			// VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si")) {
				generarReportePdf.setRutaImagen(imagenReporteCalculadora);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				calculadora.operaciones(valorUno, valorDos, rutaCarpeta, operacion, evidencia);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				// driver.close();
			} else {
				System.out.println("No se tomaran evidencias para Calculadora...");
				// ACCEDER AL METODO DE PRUEBA INICIAL
				calculadora.operaciones(valorUno, valorDos, rutaCarpeta, operacion, evidencia);
			}

		} else {
			System.out.println("La automatizacion no se ejecutara para Calculadora...");
		}
	}

	
	//INGRESAR A MERCADO LIBRE DESDE EL NAVEGADOR, COMPRAR UN PRODUCTO Y CREAR UNA CUENTA
	@DataProvider(name = "datosMercLibrePro")
	public Object[][] datosMercLibrePro() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "compra");
		return arreglo;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "datosMercLibrePro", priority = 2)
	public void seleccionarPrimerProducto(String url, String appPackage, String appActivity, String ejecutar,
			String evidencia, String producto, String nombre, String apellido, String documento, String email,
			String clave) throws Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
					noReset, autoGrantPermissions);
			claseBase = new ClaseBase(driver);
			google = new PageObjectGoogleChrome(driver);
			home = new PageObjectMercadoLibreHome(driver);
			cuenta = new PageObjectMercadoLibreCuenta(driver);

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			// VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si")) {
				generarReportePdf.setRutaImagen(imagenMercadoLibre);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				home.home(producto, evidencia, rutaCarpeta);
				cuenta.formulario(nombre, apellido, documento, email, clave, evidencia, rutaCarpeta);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				// driver.close();
			} else {
				System.out.println("No se tomaran evidencias para Mercado libre comprar producto...");
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				home.home(producto, evidencia, rutaCarpeta);
				cuenta.formulario(nombre, apellido, documento, email, clave, evidencia, rutaCarpeta);
			}

		} else {
			System.out.println("La automatizacion no se ejecutara para Mercado libre comprar producto...");
		}
	}

	//INGRESAR A MERCADO LIBRE DESDE EL NAVEGADOR Y CREAR UNA CUENTA
	@DataProvider(name = "datosMercLibreCu")
	public Object[][] datosMercLibreCu() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "crearCuenta");
		return arreglo;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "datosMercLibreCu", priority = 3)
	public void crearCuenta(String url, String appPackage, String appActivity, String ejecutar, String evidencia,
			String nombre, String apellido, String documento, String email, String clave)
			throws Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
					noReset, autoGrantPermissions);
			
			claseBase = new ClaseBase(driver);
			google = new PageObjectGoogleChrome(driver);
			home = new PageObjectMercadoLibreHome(driver);
			cuenta = new PageObjectMercadoLibreCuenta(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			// VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si")) {
				generarReportePdf.setRutaImagen(imagenMercadoLibre);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				cuenta.crearCuenta(evidencia, rutaCarpeta);
				cuenta.formulario(nombre, apellido, documento, email, clave, evidencia, rutaCarpeta);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				// driver.close();
			} else {
				System.out.println("No se tomaran evidencias para Mercado libre Crear Cuenta...");
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				cuenta.crearCuenta(evidencia, rutaCarpeta);
				cuenta.formulario(nombre, apellido, documento, email, clave, evidencia, rutaCarpeta);
			}

		} else {
			System.out.println("La automatizacion no se ejecutara para Mercado libre Crear Cuenta...");
		}
	}

	
	//INGRESAR DESDE EL NAVEGADOR A DEMQA Y REALIZAR ACCIONAR LAS ALERTS PRESENTES
	@DataProvider(name = "datosToolsAlerts")
	public Object[][] datosToolsAlerts() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "alertsTools");
		return arreglo;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "datosToolsAlerts", priority = 4)
	public void alertTools(String url, String appPackage, String appActivity, String ejecutar, String evidencia,
			String input) throws Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
					noReset, autoGrantPermissions);
			
			claseBase = new ClaseBase(driver);
			google = new PageObjectGoogleChrome(driver);
			alertsTools = new PageObjectAlertWindowsTools(driver);

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			// VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si")) {
				generarReportePdf.setRutaImagen(imagenReporteTools);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				alertsTools.alertas(input, evidencia, rutaCarpeta);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				// driver.close();
			} else {
				System.out.println("No se tomaran evidencias para Tools Alerts");
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				alertsTools.alertas(input, evidencia, rutaCarpeta);
			}

		} else {
			System.out.println("La automatizacion no se ejecutara para Tools Alerts...");
		}
	}

	
	//INGRESAR DESDE EL NAVEGADOR A DEMOQA HE INGRESAR DATA EN DATA PICKER
	@DataProvider(name = "datosToolsDate")
	public Object[][] datosToolsDate() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "date");
		return arreglo;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "datosToolsDate", priority = 4)
	// INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR
	// UNA CUENTA
	public void dateTools(String url, String appPackage, String appActivity, String ejecutar, String evidencia) throws Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnetion(platformName, deviceName, platformVersion, appPackage, appActivity,
					noReset, autoGrantPermissions);
			
			claseBase = new ClaseBase(driver);
			google = new PageObjectGoogleChrome(driver);
			dateTools = new PageObjectToolsDatePicker(driver);

			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			// VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si")) {
				generarReportePdf.setRutaImagen(imagenReporteTools);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				dateTools.sistemaDate(rutaCarpeta, evidencia);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				// driver.close();
			} else {
				System.out.println("No se tomaran evidencias para Tools Date");
				// ACCEDER AL METODO DE PRUEBA INICIAL
				google.buscador(url, evidencia, rutaCarpeta);
				dateTools.sistemaDate(rutaCarpeta, evidencia);
			}

		} else {
			System.out.println("La automatizacion no se ejecutara para Tools Date...");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		//driver.quit();
	}
}
