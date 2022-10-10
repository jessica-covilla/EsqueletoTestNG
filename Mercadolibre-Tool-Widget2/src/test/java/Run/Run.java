package Run;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


import org.testng.annotations.AfterClass;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ClaseBase.ClasesBase;
import PagsObjets.PagsObjetHome;
import PagsObjets.PagsObjetCalculadora;
import PagsObjets.PagsObjetTool;
import PagsObjets.PagsObjetWidget;
import PagsObjets.PagsObjetsCrearCuenta;
import PagsObjets.PagsObjetsMercadoLibre;

import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;
import io.appium.java_client.AppiumDriver;







public class Run 
{	
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	
	 PagsObjetsCrearCuenta crearCuenta;
	 PagsObjetsMercadoLibre paginas;
	 ClasesBase clasesBase;
	 GenerarReportePdf generarReportePdf;
	 String rutaImagen;
	 PagsObjetHome home;
	 PagsObjetTool tool;
	 PagsObjetWidget widget;
	 PagsObjetCalculadora calculadora;
	 String rutaImgDemo;
	 String rutaImgCalculadora;
	 String platformName;
	 String deviceName;
	 String platformVersion;
	 String noReset ;
	 String autoGrantPermissions;
	 
	 @BeforeClass
		
		@Parameters({"platformName","deviceName","platformVersion","noReset","autoGrantPermissions",
			"rutaImagenReporte","rutaImagenReportedemo","rutaImagenReporteCalculadora", "Output"})
		  public void beforeClass(
				  					@Optional("default") String platformName1,
				  					@Optional("default") String deviceName1,
				  					@Optional("default") String platformVersion1,
									@Optional("default") String noReset1,
									@Optional("default") String autoGrantPermissions1,					
									@Optional("default") String rutaImagenReporte, 
				  					@Optional("default") String rutaImagenReportedemo,
				  					@Optional("default") String rutaImagenReporteCalculadora,	
		  							@Optional("default") String Output) throws IOException
		 
		 
		{	
			
		 	// INSTANCIAR LA CLASE
			generarReportePdf =new GenerarReportePdf();
			//
			rutaImagen = rutaImagenReporte;
			rutaImgDemo = rutaImagenReportedemo;
			rutaImgCalculadora =rutaImagenReporteCalculadora;
			
			platformName = platformName1;
			deviceName = deviceName1;
			platformVersion = platformVersion1;
			noReset = noReset1;
			autoGrantPermissions = autoGrantPermissions1;
			
			
		}	
		

	 	@DataProvider(name = "datosCalculadora")
		public Object[][] datosCalculadora() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Calculadora");
			return arreglo;
}
	 @SuppressWarnings("unchecked")
	@Test(dataProvider = "datosCalculadora", priority = 1)
		
		
		public void calculadora( String operacion, String num1, String num2,String ejecutar, String generarEvidencia, 
				String appPackage, String appActivity) throws Exception 
		{		
		 		//SE CONFIGURA E NAVEGADOR A LA VARIABLE DRIVER
		 		driver = ClasesBase.appiumDriverConnetion(platformName, deviceName, platformVersion, 
				appPackage, appActivity, noReset, autoGrantPermissions);
		{
		if (ejecutar.equals("Si")) 
		{
			// INSTANCIAR TODAS LAS CLASE
			clasesBase = new ClasesBase(driver);
			calculadora = new PagsObjetCalculadora(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
			//VALIDAR SI SE GENERA EVIDENCIA
			if (generarEvidencia.equals("Si"))
			{
				try {
					generarReportePdf.setRutaImagen(rutaImgCalculadora);
					// INICIAR GRABACION EN VIDEO
					MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
					// INICIA CREACION DE REPORTE PDF
					generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);	
					// ACCEDE A LA CALCULADORA DEL CELULAR
					calculadora.operaciones(operacion,num1, num2, rutaCarpeta, generarEvidencia);
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// FINALILZAR CREACION DEL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
					
					
				} catch (Exception e) {
					System.out.println(e);
					// FINALIZAR GRABACION DE VIDEO
					MyScreenRecorder.stopRecording();
					// TERMINA EL REPORTE PDF
					generarReportePdf.cerrarPlantilla();
					
				}
			
		}else {
			
			// ACCEDE A LA CALCULADORA DEL CELULAR
			calculadora.operaciones(operacion,num1, num2, rutaCarpeta, generarEvidencia);
		}
		
	} else 
	{
		System.out.println("La automatización no se ejecura");
	}
		}
	}

		@DataProvider(name = "datosMercadolibre")
		public Object[][] datosMercadolibre() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Mercadolibre");
			return arreglo;
		}

		@SuppressWarnings("unchecked")
		@Test(dataProvider = "datosMercadolibre", priority = 2)
		
		
		public void test(String url, String ejecutar, String generarEvidencia,String producto, 
				String correo, String appPackage, String appActivity) throws Exception 
		{		
				//SE CONFIGURA E NAVEGADOR A LA VARIABLE DRIVER
				driver = ClasesBase.appiumDriverConnetion(platformName, deviceName, platformVersion, 
					appPackage, appActivity, noReset, autoGrantPermissions);
			
			if (ejecutar.equals("Si")) 
				{
				// INSTANCIAR TODAS LAS CLASE
				clasesBase = new ClasesBase(driver);
				paginas = new PagsObjetsMercadoLibre(driver);
				crearCuenta = new PagsObjetsCrearCuenta(driver);
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				// SE GENERA LA EVIDENCIA
				if (generarEvidencia.equals("Si"))
				{
						try {
							generarReportePdf.setRutaImagen(rutaImagen);
							// COMIENZA LAGRABACION EN VIDEO
							MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
							// COMIENZA EL REPORTE PDF
							generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
							// ACCEDER A LA PAGINA DE MERCADO LIBRE
							paginas.busquedaInicial(url,producto,rutaCarpeta, generarEvidencia);
							//INGRESA A CREAR CUENTA
							crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
							// FINALIZAR GRABACION DE VIDEO
							MyScreenRecorder.stopRecording();
							// TERMINA EL REPORTE PDF
							generarReportePdf.cerrarPlantilla();
							
						} catch (Exception e) {
							System.out.println(e);
							// FINALIZAR GRABACION DE VIDEO
							MyScreenRecorder.stopRecording();
							// TERMINA EL REPORTE PDF
							generarReportePdf.cerrarPlantilla();
						}
					
				}else 
				{
					
					// INGRESA A MERCADO LIBRE
					paginas.busquedaInicial(url, producto, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		
	
		
		
		@DataProvider(name = "datosTool")
		public Object[][] datosTool() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Tool");
			return arreglo;
		}
		
		
		@SuppressWarnings("unchecked")
		@Test(dataProvider = "datosTool",priority = 3)
		
		
		public void Tool(String url, String ejecutar, String generarEvidencia, 
				String name,String appPackage, String appActivity) throws Exception 
		{	
			//SE CONFIGURA E NAVEGADOR A LA VARIABLE DRIVER
			driver = ClasesBase.appiumDriverConnetion(platformName, deviceName, platformVersion, 
					appPackage, appActivity, noReset, autoGrantPermissions);
			
			if (ejecutar.equals("Si")) 
			{	
				// INSTANCIAR TODAS LAS CLASE
				clasesBase = new ClasesBase(driver);
				home = new PagsObjetHome(driver);
				tool = new PagsObjetTool(driver);
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				
				//SE GENERA LA EVIDENCIA
				
				if (generarEvidencia.equals("Si"))
				{
						try {
							
							generarReportePdf.setRutaImagen(rutaImgDemo);
							// COMIENZA LAGRABACION EN VIDEO
							MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
							// COMIENZA EL REPORTE PDF
							generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);	
							// INGRESA A LA PAGINA DEMOQA
							home.PaginaToolQA(url, rutaCarpeta, generarEvidencia);
							//INGRESA A LA OPCIÓN DE ALERTAS
							tool.BotonesTool(name, rutaCarpeta, generarEvidencia);
							// FINALIZAR GRABACION DE VIDEO
							MyScreenRecorder.stopRecording();
							// FINALILZAR CREACION DEL REPORTE PDF
							generarReportePdf.cerrarPlantilla();
						} catch (Exception e) {
							System.out.println(e);
							// FINALIZAR GRABACION DE VIDEO
							MyScreenRecorder.stopRecording();
							// TERMINA EL REPORTE PDF
							generarReportePdf.cerrarPlantilla();
						}
					
				}else 
				{
					
					// INGRESA AL LINK CREAR CUENTA
					home.PaginaToolQA(url, rutaCarpeta, generarEvidencia);
					//INGRESA A CREAR CUENTA
					tool.BotonesTool(name, rutaCarpeta, generarEvidencia);
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		
	 	@DataProvider(name = "datoswidget")
		public Object[][] datoswidget() throws Exception {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba.xlsx","Widget");
			return arreglo;
		}
		
		
		@SuppressWarnings("unchecked")
		@Test(dataProvider = "datoswidget",priority = 4)
		
		
		public void Widget(String url, String ejecutar, String generarEvidencia,
				String appPackage, String appActivity) throws Exception 
		{
				//SE CONFIGURA E NAVEGADOR A LA VARIABLE DRIVER
				driver = ClasesBase.appiumDriverConnetion(platformName, deviceName, platformVersion, 
					appPackage, appActivity, noReset, autoGrantPermissions);
			if (ejecutar.equals("Si")) 
			{
				// INSTANCIAR TODAS LAS CLASE 
				clasesBase = new ClasesBase(driver);
				home = new PagsObjetHome(driver);
				widget = new PagsObjetWidget(driver);
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
				File rutaCarpeta = clasesBase.crearCarpeta(nomTest);
				//SE GENERA LA EVIDENCIA
				if (generarEvidencia.equals("Si"))
				{
					try {
						generarReportePdf.setRutaImagen(rutaImgDemo);
						// COMIENZA LAGRABACION EN VIDEO
						MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
						// COMIENZA EL REPORTE PDF
						generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
						
						/// INGRESA A LA PAGINA DEMOQA
						home.PaginaToolQA(url, rutaCarpeta, generarEvidencia);
						//INGRESA A  LA OPCIÓN DE WIDGETS
						widget.PaWidgets(rutaCarpeta, generarEvidencia);
						// FINALIZAR GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						// FINALILZAR CREACION DEL REPORTE PDF
						generarReportePdf.cerrarPlantilla();
						
					} catch (Exception e) {
						System.out.println(e);
						// FINALIZAR GRABACION DE VIDEO
						MyScreenRecorder.stopRecording();
						// TERMINA EL REPORTE PDF
						generarReportePdf.cerrarPlantilla();
					}
					
				}else 
				{
					
					// INGRESA A LA PAGINA DEMOQA 
					home.PaginaToolQA(url, rutaCarpeta, generarEvidencia);
					//INGRESA A  LA OPCIÓN DE WIDGETS
					widget.PaWidgets(rutaCarpeta, generarEvidencia);
					
				}
				
			} else 
			{
				System.out.println("No se ejecutara la automatización");
			}
		}
		

		
		@AfterClass
		public void afterClass() 
		{
			
			driver.quit();
		}
	}