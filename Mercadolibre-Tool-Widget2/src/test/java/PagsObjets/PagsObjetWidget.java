package PagsObjets;

import java.io.File;
import MapsObjets.MapsObjetWidget;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;




	
public class PagsObjetWidget extends MapsObjetWidget {
	
	// SE GENERA EL CONSTRUCTOR
	public PagsObjetWidget(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	

	public void PaWidgets(File rutaCarpeta, String generarEvidencia) throws Exception  {
		
		
		String fecha = fechaSistema();
		String[] fechaVector= fecha.split("-");
		
		int dia =  Integer.parseInt(fechaVector[0]);
		int mes =  Integer.parseInt(fechaVector[1]);
		int year = Integer.parseInt(fechaVector[2]);
		int hora = Integer.parseInt(fechaVector[3]);
	    int min =  Integer.parseInt(fechaVector[4]);
	    int seg =  Integer.parseInt(fechaVector[5]);
		
	    		
	    dia=dia-1;
		mes=mes-1;
		year=year-1;
		hora = hora-1;
		
		String fechamenor = dia+"/"+mes+"/"+year;
		String fechaMenorHora = mes+"/"+dia+"/"+year+" "+hora+":"+min+":"+seg;
		//BAJA LA PANTALLA CONUN SCROLL
		scrollVertical(570,1923,570,3);
		tiempoEspera(2000);
		//CLIC EN ENTER
		tocarPantalla(540,1303);
		tiempoEspera(5000);
		//CLIC EN DATAPICKER
		click1(btnDataPicker,rutaCarpeta, generarEvidencia, "Selecciona la opción de Date Picker");
		tiempoEspera(3000);
		//LIMPIA EL CUADRO DONDE SE ENCUENTRA LA FECHA
		borrar(txtDate,rutaCarpeta, generarEvidencia, "Borra la fecha que se genera Date");
		tiempoEspera(1000);
		//LE ENVIO LA FECHA CORRESPONDIENTE
		sendKey(fechamenor, txtDate , rutaCarpeta, generarEvidencia, "Se ingresa la fecha seleccionada");
		tiempoEspera(1000);
		//LIMPIA EL CUADRO DONDE SE ENCUENTRA LA FECHA
		borrar(txtDateTime,rutaCarpeta, generarEvidencia, "Se borra la fecha que se genera en DateTime");
		tiempoEspera(1000);
		//LE ENVIO LA FECHA CORRESPONDIENTE
		sendKey(fechaWidget2(), txtDateTime , rutaCarpeta, generarEvidencia, "Se ingresa la fecha seleccionada");
		tiempoEspera(2000);
		enter(rutaCarpeta,0);
	

	}


	


}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	    		
	   
