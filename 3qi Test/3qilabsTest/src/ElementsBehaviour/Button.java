package ElementsBehaviour;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ReusableCode.Browsers;
import WaitForElements.Wait;

public class Button extends Browsers
{

	public static Wait wait=new Wait();
	
	public static void clickButton(WebElement element)
	{
		//wait for element visibility
		wait.explicitWait(element);
				
		element.click();	
	}
	
}
