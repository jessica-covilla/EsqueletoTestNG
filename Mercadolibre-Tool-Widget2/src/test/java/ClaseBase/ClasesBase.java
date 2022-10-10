package ClaseBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import Utilidades.GenerarReportePdf;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class ClasesBase 
{
	
	protected static AppiumDriver<MobileElement> driver;
	
	//CONSTRUCTOR DE CLASE
	public ClasesBase (AppiumDriver<MobileElement> driver)
	{
		super();
	}
  
	//REALIZA EL METODO DE NAVEGADOR
		@SuppressWarnings("rawtypes")
		public static AppiumDriver appiumDriverConnetion(String platformName, String deviceName, 
				String platformVersion, String appPackage, String appActivity, String noReset, 
				String autoGrantPermissions)
		{
			AppiumDriver driver = null;
		
		try {
			
			//CREAR LAS CAPA BILITIES DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName",platformName);
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("platformVersion",platformVersion);
			caps.setCapability("appPackage", appPackage);
			caps.setCapability("appActivity",appActivity);
			caps.setCapability("noReset",noReset);
			caps.setCapability("autoGrantPermissions",autoGrantPermissions);
		
			//INSTANCIAR APPIUM DRIVER
			try {
				printConsola("Cargado Cability de appium, por favor espere...");
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
		
		private static void printConsola(String texto) {
 			System.out.println(texto);
 		
 	}

		//METODO CLICK 
		public void click1(By locator, File rutaCarpeta, String generarEvidencia, String msj) throws Exception
		{
				try {
					captureScreen(rutaCarpeta, locator, generarEvidencia, msj);
					driver.findElement(locator).click();
					tiempoEspera(1000);
				} catch (Exception e) {
					captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
					throw new InterruptedException();
				}
			
		}
				
		
		public void click(By locator, File rutaCarpeta, String generarEvidencia, String msj) throws Exception
		{
			try {
				driver.findElement(locator).click();
				captureScreen(rutaCarpeta, locator, generarEvidencia, msj);
				tiempoEspera(1000);
				
			} catch (Exception e) {
				captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
				throw new InterruptedException();
			}
			
		}
			
		//METODO BORRAR
		public void borrar (By locator, File rutaCarpeta, String generarEvidencia, String msj) throws Exception
				{
					try {
						driver.findElement(locator).clear();
						captureScreen(rutaCarpeta, locator, generarEvidencia, msj);
						
					} catch (Exception e) {
						captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
						throw new InterruptedException();
						
					}
					
				}
				
				
		//METODO ENVIAR TEXTO
		public void sendKey(String string, By locator, File rutaCarpeta, String generarEvidencia, String msj) throws Exception
				{
					try {
						driver.findElement(locator).sendKeys(string);
						captureScreen(rutaCarpeta, locator, generarEvidencia, msj);
						
					} catch (Exception e) {
						captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
						throw new InterruptedException();
					}
					
				}
				
			
				
		//METODO ENTER SUBMIT
		public void submit(By locator,  File rutaCarpeta, String generarEvidencia, String msj) throws Exception
				{
				try {
					driver.findElement(locator).submit();
					tiempoEspera(500);
					captureScreen(rutaCarpeta, locator, generarEvidencia, msj);
					
				} catch (Exception e) {
					captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
					throw new InterruptedException();
				}
					
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
				
		
				
		public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia, String msj) throws Exception
				{
					if(generarEvidencia.equals("Si"))
					{
					String hora = HoraSistema();
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
					String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
					
					//INSTANCIAR CLASE GENERAR PDF
					GenerarReportePdf informePdf = new GenerarReportePdf();
					//SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
					informePdf.crearBody(locator, rutaImagen, msj);
					
					//ELIMINAR IMAGEN CREADA
					eliminarArchivo(rutaImagen);
					}
				}
				
		
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
		
		public String fechaWidget()
		{
			String fecha = fechaSistema();
			String[] fechaVector= fecha.split("-");
			
			int dia =  Integer.parseInt(fechaVector[0]);
			int mes =  Integer.parseInt(fechaVector[1]);
			int year =  Integer.parseInt(fechaVector[2]);
			
			dia=dia-1;
			mes=mes-1;
			year=year-1;
			
			String fechaMenor = dia+"/"+mes+"/"+year;
			return fechaMenor;
			
		}
		
		public String fechaSistema()
		{
			//TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
		
		public String fechaWidget2()
		{
			String fecha2 = fechaSistema();
			String[] fechaVector= fecha2.split("-");
			
	
			int dia =  Integer.parseInt(fechaVector[0]);
			int mes =  Integer.parseInt(fechaVector[1]);        
			int year =  Integer.parseInt(fechaVector[2]);
			int hora = Integer.parseInt(fechaVector[3]);
		    int min =  Integer.parseInt(fechaVector[4]);
		    int seg =  Integer.parseInt(fechaVector[5]);
			
			
			mes=mes-1;
			dia=dia-1;
			year=year-1;
			hora = hora-1;
			
			Month mes1=LocalDate.now().minusMonths(1).getMonth();
			fecha2 = mes1+"/"+dia+"/"+year+" "+hora+":"+min+":"+seg;
			return fecha2;
			
			
		}
		
		public void scroll(int y)
		{
			//ENVIO DE LOS VALORES DE BUSQUEDA EN EL NAVEGADOR 
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	// This  will scroll down the page by  1000 pixel vertical        
			js.executeScript("window.scrollBy(0,"+y+")");
		}
		
		public void captureScreen(File rutaCarpeta) throws Exception
		{
			//
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			
		}
		
		
		
/*		public List<WebElement> listaElementos(By locator) throws Exception
        {
          
            List<WebElement> elemento=driver.findElements(locator);
            return elemento;
            
        }*/
		public void validacion(By localizador, File rutaCarpeta, String generarEvidencia, String msj) {
		    try {
		        driver.findElement(localizador).isEnabled();
		        click(localizador,rutaCarpeta,generarEvidencia, msj);
		    }catch (Exception e){
		        System.out.println(e);
		    }
		}
		
		//METODO BORRAR
        public void borrartxt (By locator, File rutaCarpeta, String evidencia, String msj) throws Exception
            {
                driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
                captureScreen(rutaCarpeta, locator, evidencia, msj);
            }
		
      //METODO PARA UN SELECT 
    	public void select(By locator, String pais, File rutaCarpeta) throws Exception
    	{
    		Select paisList = new Select(driver.findElement(locator));
    		paisList.selectByValue(pais);
    		
    	}
    	
    	public void numeroSeparados (String numeros, By locator, File rutaCarpeta, String generarEvidencia) throws Exception
		{
			String[] num= new String[numeros.length()] ;
		
			for (int i=0; i<numeros.length();i++) {
				 	num[i]=String.valueOf(numeros.charAt(i));
				 	String msj = ("Se escribe el número: "+num[i]);
				 	click(localizadorVariable(locator,num[i]),rutaCarpeta, generarEvidencia,msj);
				}		 
		}
    	 public By localizadorVariable(By locator, String valor)
  	    {
  	    	String jj = locator.toString().replace("{0}",valor);
  	    	String kk = jj.replace("By.xpath:", "");
  	    	By localizador=By.xpath(kk);
  			return localizador;
  	    	
  	    }
    	 
    	 public void scrollVertical( int xini,int yini, int yfinal, int iteraciones) throws Exception
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
		    }
 	 
 	 public void tocarPantalla(int x, int y)
		    {
		        @SuppressWarnings("rawtypes")
		        TouchAction touch = new TouchAction(driver);
		        touch.press(PointOption.point(x,y)).release().perform();
		        
		    }
 	public void enter(File rutaCarpeta, int time)throws Exception
    {
        @SuppressWarnings("unused")
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        tiempoEspera(time);
        //capturaPantalla(rutaCarpeta, locator, generarEvidencia);
    }
		
 	public String textoLocalizador(By locator)
 	{
 		return (driver.findElement(locator).getText());
 	}
		
}
