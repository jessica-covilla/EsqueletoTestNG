package PagsObjets;

import java.io.File;

import org.junit.Assert;
import org.junit.Assert.*;
import MapsObjets.MapsObjectCalculadora;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;




	
public class PagsObjetCalculadora extends 	MapsObjectCalculadora
{
	// SE GENERA EL CONSTRUCTOR
	@SuppressWarnings("static-access")
	public PagsObjetCalculadora(AppiumDriver<MobileElement> driver) {
		super(driver);
		
		this.driver=driver;
	}
	
	
	 
	//METODO DE LA PRUEBA PAGINA PRINCIPAL TOOLQA


	public void operaciones(String operacion, String num1, String num2, File rutaCarpeta, String generarEvidencia) throws Exception {
		
				//CLIC AL PRIMER NUMERO
				numeroSeparados(num1,btnNumero,rutaCarpeta, generarEvidencia);	
				// CLICK EN EL OPERADOR SELECCIONADO
				click(localizadorVariable(btnSuma,operacion),rutaCarpeta, generarEvidencia, "Clic en la operación seleccionada");
				//CLIC AL SEGUNDO NUMERO
				numeroSeparados(num2, btnNumero,rutaCarpeta, generarEvidencia);
				//CLIC EN EL SIGNO IGUAL
				click(btnIgual,rutaCarpeta, generarEvidencia, "Clic en signo igual para que muestre el resultado");
							
				
	}



}