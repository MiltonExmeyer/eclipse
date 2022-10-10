package mapsObject;
import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMercadoLibreCuenta extends  ClaseBase 
{

	public MapObjectMercadoLibreCuenta(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}
	//ELEMENTOS DE LA PAG
	//BTN CREAR CUENTA
	protected By btnCrearCuenta=By.xpath("//android.view.View[@content-desc='Crear cuenta']");
	//CAMPOS DE TEXTO DEL FORMULARIO DE REGISTRO
	protected By txtNombre=By.xpath("(//android.widget.EditText)[1]");
	protected By txtApellido=By.xpath("(//android.widget.EditText)[2]");
	protected By txtDocumento=By.xpath("(//android.widget.EditText)[3]");
	protected By txtEmail=By.xpath("(//android.widget.EditText)[4]");
	protected By txtClave=By.xpath("(//android.widget.EditText)[5]");
	
	//BTN DE ACEPTAR TERMINOS Y CAPCHA
	protected By checkboxAceptarTerm=By.xpath("//android.widget.CheckBox[@text='Acepto los Términos y condiciones (abrirá una nueva ventana) y autorizo el uso de mis datos de acuerdo a la Declaración de Privacidad (abrirá una nueva ventana) .']");
	protected By btnCatcha=By.xpath("//android.widget.CheckBox[@text='No soy un robot']");
	
	//BTN DE OPCIONES MERCADO LIBRE
	protected By btnOptions= By.xpath("//android.widget.Button[@text='Menú de usuario']");
	//BTN CREAR CUENTA DIRECTO
	protected By btnCrearCuentaDirect= By.xpath("//android.view.View[@content-desc='Crea tu cuenta']");
	//BTN DE COOKIES
	protected By btnEntendido= By.xpath("//android.widget.Button[@text='Entendido']");
	//BTN DE CONFIRMAR EL PAIS PARA REGISTRO
	protected By btnPeru = By.xpath("//android.widget.Button[@text='Registrarme en Peru']");
}
