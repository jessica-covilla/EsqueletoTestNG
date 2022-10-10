package PagsObjets;

import java.io.File;

import org.junit.Assert;

import MapsObjets.MapsObjetTool;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;




	
public class PagsObjetTool extends 	MapsObjetTool
{
	// SE GENERA EL CONSTRUCTOR
	@SuppressWarnings("static-access")
	public PagsObjetTool(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=driver;
		 
	}
	 
	//METODO DE LA PRUEBA PAGINA PRINCIPAL TOOLQA
	public void BotonesTool(String name, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		
	
		
				//REALIZA UN SCROLL HACIA BAJO
				scrollVertical(390,1945,390,2);
			//	scrollVertical(rutaCarpeta,544,2100,600,3);
				tiempoEspera(3000);
				tocarPantalla(540,1303);

				//CLIC EN ALERTS
//				tocarPantalla(268,386);
				click1(btnAlerts,rutaCarpeta, generarEvidencia, "Se selecciona  Alerta");
				tiempoEspera(2000);
				
				//CLIC EN EL PRIMER BOTON
				click1(btnMe1,rutaCarpeta, generarEvidencia, "Clic en el primer button para ver la alerta");
				tiempoEspera(2000);
				//CLIC EN ACEPTAR
				click1(btnAceptar,rutaCarpeta, generarEvidencia, "Clic en Acepta");
				
				//CLIC EN EL SEGUNDO BOTON
				click1(btnMe2,rutaCarpeta, generarEvidencia, "Clic en el segundo button para ver la alerta");
				tiempoEspera(5000);
				//CLIC EN EL BOTON ACEPTAR
				click1(btnAceptar,rutaCarpeta, generarEvidencia, "Clic en aceptar");
				
				//CLIC EN EL TERCER BOTON
				click1(btnMe3,rutaCarpeta, generarEvidencia, "Clic en el tercer button para ver la alerta");
				tiempoEspera(2000);
				//CLIC EN ACEPTAR
				click1(btnAceptar,rutaCarpeta, generarEvidencia, "Clic en aceptar");
				
				//CLIC EN EL TERCER BOTON
				click1(btnMe3,rutaCarpeta, generarEvidencia, "Clic en el tercer button para cancelar la alerta");
				//CLIC EN CANCELAR
				tiempoEspera(2000);
				click1(btnCancelar,rutaCarpeta, generarEvidencia, "Clic en cancelar");
				
				//CLIC EN EL CUARTO BOTON		
				click1(btnMe4,rutaCarpeta, generarEvidencia, "Clic en el cuarto button para cancelar la alerta");
				//AGREGO EL CORREO
				sendKey(name,txtname,rutaCarpeta, generarEvidencia, "Se ingresa el nombre");	
				tiempoEspera(1000);
				//CLIC EN EL BOTON ACEPTAR
				click1(btnAceptar,rutaCarpeta, generarEvidencia, "clic en aceptar");
				Assert.assertEquals(txtname.toString(),name, "Se confirma nombre");
		}
}
	