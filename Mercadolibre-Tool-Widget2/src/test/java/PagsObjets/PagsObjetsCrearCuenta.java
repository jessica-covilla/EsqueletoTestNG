package PagsObjets;

import java.io.File;

import MapsObjets.MapsObjetsCrearCuenta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class PagsObjetsCrearCuenta extends MapsObjetsCrearCuenta
{
		
	
	
	public PagsObjetsCrearCuenta(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}

	public void crearCuenta(String correo, File rutaCarpeta, String generarEvidencia) throws Exception 
	{		
		//CLIC EN EL BOTON DE CRAR CUENTE
		click(btnCuenta,rutaCarpeta, generarEvidencia, "Clic en crear cuenta");
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//ACTIVAR EL CHECK 
		click(btnCheck,rutaCarpeta, generarEvidencia, "Activo el check, para aceptar terminos");
		//CLIC EN EL BOTON CONTINUAR
		click(btnContinuar,rutaCarpeta, generarEvidencia, "Clic en continuar");
		//TIEMPO DE ESPERA
		tiempoEspera(2000);
		//CLIC EN EL BOTON DE VALIDAR 
		click(btnValidar,rutaCarpeta, generarEvidencia, "Clic en validar correo");
		// CLIC EN EL CAMPO DONDE SE INGRESA EL CORREO
		click(txtCorreo,rutaCarpeta, generarEvidencia,"Selecciona el cuadro para ingresar el correo");
		//SE ESCRIBE EL CORREO 
		sendKey(correo,txtCorreo,rutaCarpeta, generarEvidencia,"Se ingresa el correo");	
				
	}
	
}
