package claseBase;

import java.io.File;
//import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;

@SuppressWarnings("unused")
public class ClaseBase 
{
	
	@SuppressWarnings("rawtypes")
	protected AppiumDriver driver;

	// CONSTRUCTOR DE LA CLASE
	public ClaseBase(AppiumDriver<MobileElement> driver) 
	{
		super();
	}
	
	// METODO DE NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(String platformName, String deviceName, String platformVersion, 
				String appPackage, String appActivity, String noReset, String autoGrantPermissions)
	{
		AppiumDriver driver = null;
		try {
			// CREARLAS CAPABILITYS DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName",platformName);
			caps.setCapability("deviceName", deviceName);
			caps.setCapability("platformVersion", platformVersion);
			caps.setCapability("appPackage", appPackage );
			caps.setCapability("appActivity",appActivity);
			caps.setCapability("noReset", noReset);
			caps.setCapability("autoGrantPermissions",autoGrantPermissions);

			// INSTANCIAR APPIUM DRIVER
			try {
				printConsola("cargando capability de appium, favor esperar ....");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				
			} catch (MalformedURLException e) {
				printConsola(e.getMessage());
			}
			return driver;
		} catch (Exception e) {
			printConsola(e.getMessage());
		}
		return driver;
	}
	
		
	private static void printConsola(String string) 
	{}

		//METODO CLICK 
				public void click(By locator, File rutaCarpeta, String evidencia, String mensaje) throws Exception
				{
					driver.findElement(locator).click();
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
					tiempoEspera(500);
				}
				
				public void clickTools(By locator, File rutaCarpeta, String evidencia, String mensaje) throws Exception
				{
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
					driver.findElement(locator).click();
					tiempoEspera(500);
				}
				
				//METODO CLICK TIME
				public void clickTime(By locator, File rutaCarpeta, int time, String evidencia, String mensaje ) throws Exception
				{
					driver.findElement(locator).click();
					tiempoEspera(time*1000);
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
				}
				
				
				public void clickOptional(By locator, File rutaCarpeta, int numBusqueda,String evidencia, String mensaje) throws Exception
				{
					driver.findElement(locator).click();
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
					tiempoEspera(1000);
				}
				
				
				public void validacion(By localizador, File rutaCarpeta, String evidencia, String mensaje) {
				    try {
				        driver.findElement(localizador).isEnabled();
				        clickOptional(localizador, rutaCarpeta, 1, evidencia, mensaje);
				    }catch (Exception e){
				    	System.out.println(e);
				    }
				}
				
				//METODO BORRAR
				public void borrar (By locator, File rutaCarpeta, String evidencia, String mensaje) throws Exception
				{
					driver.findElement(locator).clear();
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
				}
				
				//METODO BORRAR
				public void borrartxt (By locator, File rutaCarpeta, String evidencia, String mensaje) throws Exception
					{
						driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
						captureScreen(rutaCarpeta, locator, evidencia, mensaje);
					}
				
				//METODO ENVIAR TEXTO
				public void sendKey(String string, By locator, File rutaCarpeta, String evidencia, String mensaje) throws Exception
				{
					driver.findElement(locator).sendKeys(string);
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
				}
				
				//METODO REEMPLAZAR VALORES
				public void sendKeyValue(String string, By locator, File rutaCarpeta) throws Exception
				{
					driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a"), string);
					captureScreenBasic(rutaCarpeta);
				}
				
				//METODO ENTER SUBMIT
				public void submit(By locator,  File rutaCarpeta, String evidencia, String mensaje) throws Exception
				{
					driver.findElement(locator).submit();
					tiempoEspera(500);
					captureScreen(rutaCarpeta, locator, evidencia, mensaje);
				}
				
				//METODO TIEMPO DE ESPERA
				public void tiempoEspera(long tiempo) throws InterruptedException
				{
					Thread.sleep(tiempo);
				}
				
				// SCROLL DOWN  200 PIXEL VERTICAL
				public void scrollDown(int y, int numMovimiento) throws InterruptedException
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					for (int i=0; i<= numMovimiento; i++) {
					js.executeScript("window.scrollBy(0,"+y+")");
					}
				}
				
				//METODO TIEMPO DE ESPERA
				public void imprimirConsola(Exception mensaje) throws InterruptedException
				{
					System.out.println("e");
				}
				
				// TOMA DE EVIDENCIAS CON SCREENSHOT
				
				public void captureScreenBasic(File rutaCarpeta) throws Exception
				{
					//tiempoEspera(1000);
					String hora = HoraSistema();
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
				}
				
				public void captureScreen(File rutaCarpeta, By locator, String evidencia, String mensaje) throws Exception
				{
					if(evidencia.equals("Si"))
					{
					String hora = HoraSistema();
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
					String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
					
					//INSTANCIAR CLASE GENERAR PDF
					GenerarReportePdf informePdf = new GenerarReportePdf();
					//SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
					informePdf.crearBody(locator, rutaImagen, mensaje);
					
					//ELIMINAR IMAGEN CREADA
					eliminarArchivo(rutaImagen);
					}
				}
				
				
				
				public File crearCarpeta(String nomTest)
				{
					//ALMECENAMOS LA FECHA DEL SISTEMA 
					String fecha = fechaHora();
					//CREAMOS EL NOMBRE DE LA CARPETA
					String nomCarpeta = nomTest+"-"+fecha;
					//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR 
					File directorio = new File("./output/"+nomCarpeta);
					//C:\Users\HP\eclipse-workspace\SemilleroToolsQa\output
					//CREAMOS LA CARPETA ./Properties/output
					directorio.mkdir();
					return directorio;
				}
				
				
				public static String  fechaHora() 
				{
					//TOMAR LA FECHA DEL SISTEMA 
					LocalDateTime fechaSistema = LocalDateTime.now();
					//DEFINIR FORMATO FECHA
					DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
					//DAR FORMATO A LA FECHA DEL SISTEMA 
					String formatFecha = fecha.format(fechaSistema);
					return formatFecha;
					
				}
				
				public static String  fechaHoraDos() 
				{
					//TOMAR LA FECHA DEL SISTEMA 
					LocalDateTime fechaSistema = LocalDateTime.now();
					//DEFINIR FORMATO FECHA
					DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					//DAR FORMATO A LA FECHA DEL SISTEMA 
					String formatFecha = fecha.format(fechaSistema);
					return formatFecha;
					
				}
				
				public void eliminarArchivo(String rutaImagen)
				{
					File fichero = new File(rutaImagen);
					fichero.delete();
				}
				
				
				public String  fechaHoraToolsQa() 
				{
					//TOMAR LA FECHA DEL SISTEMA 
					LocalDateTime fechaSistemaToolsQa = LocalDateTime.now();
					//DEFINIR FORMATO FECHA
					DateTimeFormatter fechaToolQa = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");
					//DAR FORMATO A LA FECHA DEL SISTEMA 
					String formatFechaToolsQa = fechaToolQa.format(fechaSistemaToolsQa);
					return formatFechaToolsQa;
					
				}
				
				public String HoraSistema ()
				{
					//TOMAR LA HORA DEL SISTEMA
					LocalTime horaSistema = LocalTime.now();
					//DEFINIR FORMATO HORA
					DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
					//DAR FORMATO A LA HORA DEL SISTEMA
					String hora = fecha.format(horaSistema);
					return hora;
				}
				
				//LOCALIZAR VARIABLE
				public By localizadorVariableXpath(By locator, String valor) throws Exception
				{
					String jj = locator.toString().replace("{0}", valor);
					String kk =jj.replace("By.xpath:", "");
					By localizador = By.xpath(kk);
					return localizador;
						}
				
				
				public void crearArray(String valor, By locator, File rutaCarpeta, String evidencia ) throws Exception
				{
					char [] numero = null;
					//CAPTURAR VALOR DEL EXCEL 
					numero = valor.toCharArray();
					for (int i=0; i<numero.length; i++)
					{
						String value = String.valueOf(numero[i]);
						String mensaje = ("Se escribe el numero: " + value);
						click(localizadorVariableXpath(locator, value),rutaCarpeta, evidencia, mensaje);
					}
				}
					
				public void tocarPantalla(int x, int y)
				{
					@SuppressWarnings("rawtypes")
					TouchAction touch = new TouchAction(driver);
					touch.press(PointOption.point(x,y)).release().perform();
				}
				
				 public void scrollVertical(File rutaCarpeta, int xini,int yini, int yfinal, int iteraciones) throws Exception
				    {
				        
				        for (int i = 1 ;i<=iteraciones;i++)
				        {
				            @SuppressWarnings("rawtypes")
				            TouchAction touch = new TouchAction(driver);
				            touch.press(PointOption.point(xini,yini))
				            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				            .moveTo(PointOption.point(xini,yfinal))
				            .release().perform();		            
				        }
				        //captureScreen(rutaCarpeta, null , evidencia);
				    }
				
				 
				// METODO ERROR AL CAPTURAR PANTALLA
				    public void captureScreenError(File rutaCarpeta, By locator, String evidencia, String msnError)
				            throws Exception {
				        if (evidencia.equals("Si")) {
				            String hora = HoraSistema();
				            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				            FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
				            String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

				           // INSTACIAMOS LA CLASE GENERAR PDF
				            GenerarReportePdf informePdf = new GenerarReportePdf();
				            // SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
				            informePdf.crearbodyError(locator, rutaImagen, msnError);
				            // ELIMINAR IMAGEN CREADA

				           eliminarArchivo(rutaImagen);
				        }
				    }
				 
				    
				    
				 
}

