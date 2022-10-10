package PagsObjets;

import java.io.File;


import MapsObjets.MapsObjetHome;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;




	
public class PagsObjetHome extends MapsObjetHome
{
	String busquedas = null;
	//CREAR EL CONSTRUCTOR DE LA CLASE
	@SuppressWarnings("static-access")
	public PagsObjetHome(AppiumDriver<MobileElement> driver)
	{
		super (driver);
		this.driver=driver;
	}
	
	
	
	//METODO DE LA PRUEBA PAGINA PRINCIPAL TOOLQA
	
	public void PaginaToolQA(String url, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		
		
	
				//CLIC EN OPCIONES
				click(txtOpcion,rutaCarpeta, generarEvidencia, "Selecciona el Menú");
				//CLIC EN NUEVA PESTAÑA
				click(txtNueva,rutaCarpeta, generarEvidencia, "Abre una nueva pestaña");
				//CLIC EN BUSQUEDA DEL NAVEGADOR
				click(txtBuscar,rutaCarpeta, generarEvidencia,"Clic en el cuadro de texto en el  buscador del navegador ");
				//ESCRIBE LA PAGINA DE DEMOQA
				sendKey(url,txtBuscar,rutaCarpeta, generarEvidencia, "Escribe la url de DemoQA");
				tocarPantalla(997,2123);
				//ESPERA UN TIEMPO
				tiempoEspera(2000);
	
			
			
		
	
	}

/*	public void PaginaWidgets(String producto, File rutaCarpeta, String generarEvidencia) throws Exception 
	{
		

		scroll(300);
    	tiempoEspera(1000);
		//INGRESA A Widgets
		click(linkWidget,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		tiempoEspera(3000);
		//SE SELECCIONA ALERTS
		//js.executeScript("window.scrollBy(0,200)");
		scroll(300);
		click(linkPicker,rutaCarpeta, generarEvidencia);
		//TIEMPO DE ESPERA
		
		
	}*/

	

}
