package MapsObjets;

import org.openqa.selenium.By;

import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetsMercadoLibre  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetsMercadoLibre(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	//ELEMENTOS DE LA PAGINA DEL NAVEGADOR Y DE MERCADO LIBRE
		protected By btnOpcion= By.xpath("//android.widget.ImageButton[@resource-id='com.android.chrome:id/menu_button']");
		protected By txtNueva= By.xpath("//android.widget.TextView[@text='Nueva pestaña']");
		protected By txtBuscar= By.xpath("//android.widget.EditText[@text='Busca o escribe la dirección web']");
		protected By txtProducto= By.xpath("//android.widget.EditText[@text='']");
		//android.widget.EditText[@text='']
		protected By btnLupa= By.xpath("//android.widget.Button[@text='Buscar']");
		protected By btnSeleccionar= By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.widget.ListView[2]/android.view.View[1]/android.view.View");
		protected By btnCarrito= By.xpath("//android.widget[@text='Agregar al carrito']");
		//android.widget.Button[@text='Agregar al carrito']
	
	
}