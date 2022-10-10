package MapsObjets;

import org.openqa.selenium.By;


import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjectCalculadora  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjectCalculadora(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
		//ELEMENTOS DE LA CALCULADORA
		protected By btnNumero= By.xpath("//android.widget.TextView[@text='{0}']");
		protected By btnSuma= By.xpath("//android.widget.ImageView[@content-desc='{0}']");
		protected By btnIgual= By.id("com.miui.calculator:id/btn_equal_s");
		protected By resultado= By.xpath("//android.widget.TextView[@text='9']");
		//android.widget.TextView[@resource-id='com.miui.calculator:id/result']
		//android.widget.TextView[@resource-id='com.miui.calculator:id/result']
}