package MapsObjets;

import org.openqa.selenium.By;

import ClaseBase.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetTool  extends ClasesBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetTool(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	
		//ELEMENTOS DE LA PAGINA DEL TOOLQA ALERTS
	
		protected By btnAlertsFrame = By.xpath("//android.widget.TextView[@text='Alerts, Frame & Windows']");
		protected By btnAlerts= By.xpath("//android.widget.TextView[@text='Alerts']");
		//android.view.View/android.widget.TextView[@text='Alerts']
		protected By btnMe1= By.xpath("//android.widget.Button[@text='Click me'][@resource-id='alertButton']");
		protected By btnAceptar= By.xpath("//android.widget.Button[@text='Aceptar'][@resource-id='com.android.chrome:id/positive_button']");
		protected By btnMe2= By.xpath("//android.widget.Button[@text='Click me'][@resource-id='timerAlertButton']");

		protected By btnMe3= By.xpath("//android.widget.Button[@text='Click me'][@resource-id='confirmButton']");
		protected By btnCancelar= By.xpath("//android.widget.Button[@text='Cancelar'][@resource-id='com.android.chrome:id/negative_button']");
		protected By btnMe4= By.xpath("//android.widget.Button[@text='Click me'][@resource-id='promtButton']");
		protected By txtname= By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/js_modal_dialog_prompt']");

	
}