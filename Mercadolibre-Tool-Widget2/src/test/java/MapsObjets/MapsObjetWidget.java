package MapsObjets;

import org.openqa.selenium.By;

import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetWidget  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetWidget(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	//ELEMENTOS DE LA PAGINA TOOLQA LA SECCIÓN DE WIDGETS
			protected By btnWidgets= By.xpath("//android.widget.TextView[@text='Widgets']");
			protected By btnDataPicker= By.xpath("//android.widget.TextView[@text='Date Picker']");
			protected By txtDate= By.xpath("//android.widget.EditText[@resource-id='datePickerMonthYearInput']");
			protected By txtDateTime= By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");



	
}