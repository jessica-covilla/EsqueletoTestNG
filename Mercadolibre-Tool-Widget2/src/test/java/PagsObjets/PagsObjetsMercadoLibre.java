package PagsObjets;

import java.io.File;

import MapsObjets.MapsObjetsMercadoLibre;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



	
public class PagsObjetsMercadoLibre extends MapsObjetsMercadoLibre
 	{
 		//CREAR CONSTRUCTOR DE LA CLASE 
 		@SuppressWarnings("static-access")
		public PagsObjetsMercadoLibre(AppiumDriver<MobileElement> driver)
 		{
 			super(driver);
 			this.driver=driver;
 		}
 		
 
 		
 		//METODO PRIMERA PRUEBA
 		public void busquedaInicial(String url, String producto, File rutaCarpeta, String generarEvidencia) throws Exception
 	
 		{
 			//CLIC EN EL MENU DE OPCIONES DEL NAVEGADOR 
 			click(btnOpcion, rutaCarpeta,generarEvidencia, "Selecciona el Menú");
 			//CLIC EN ABRIR UNA PESTAÑA DEL NAVEGADOR 
 			click(txtNueva, rutaCarpeta,generarEvidencia, "Selecciona  una nueva pestaña");
 			//CLIC EN BUSQUEDA DEL NAVEGADOR
			click(txtBuscar,rutaCarpeta, generarEvidencia, "Clic en el cuadro de texto en el  buscador del navegador ");
			//TIEMPO DE ESPERA 
			tiempoEspera(2000);
			//ESCRIBE LA PAGINA DE MERCADO LIBRE DE MEXICO 
			sendKey(url,txtBuscar,rutaCarpeta,generarEvidencia, "Se agrega la url de mercado libre");
			//CLIC EN ENTER
			tocarPantalla(997,2123);
			// CLIC EN LA LUPA PARA SELECCIONAR LA CASILLA
			//TIEMPO DE ESPERA 
			tiempoEspera(2000);
			// CLIC EN EL PRIMER SELECCIONADO
			click(txtProducto,rutaCarpeta, generarEvidencia, "Selecciona la casilla de buscar el producto");
			//TIEMPO DE ESPERA 
			tiempoEspera(2000);
			//ESCRIBE EL NOMBRE DEL PRODUCTO
			sendKey(producto,txtProducto,rutaCarpeta, generarEvidencia, "Agrega el nombre del producto");
			tiempoEspera(2000);
			//CLIC EN ENTER
			tocarPantalla(995,2107);
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			//CLIC EN SELECCIONAR EL PRIMER PRODUCTO DE LA LISTA
			click(btnSeleccionar,rutaCarpeta, generarEvidencia, "Seleccionamos el primer producto");
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
			//BAJAR LA PANTALLA PARA QUE SE VISUALICE EL BOTON DEL CARRITO
			scrollVertical(602,1990,602,1);
			tiempoEspera(2000);
			//CLIC EN EL BOTON DEL CARRITO
			click(btnCarrito,rutaCarpeta, generarEvidencia, "Clic en agregar al carrito");
			//TIEMPO DE ESPERA
			tiempoEspera(2000);
 			
 		}	
		

		 
 	}