package MapsObjets;

import org.openqa.selenium.By;


import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetHome  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetHome(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
		//ELEMENTOS DE LA PAGINA TOOLQA
	
		protected By txtBuscar= By.xpath("//android.widget.EditText[@text='Busca o escribe la dirección web']");
		protected By txtOpcion= By.xpath("//android.widget.ImageButton[@resource-id='com.android.chrome:id/menu_button']");
		protected By txtNueva= By.xpath("//android.widget.TextView[@text='Nueva pestaña']");

	
}