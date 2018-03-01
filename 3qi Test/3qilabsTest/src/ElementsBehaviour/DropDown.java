package ElementsBehaviour;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import WaitForElements.Wait;

public class DropDown
{
public static Wait wait=new Wait();

	public static void selectByVisibleText(WebElement element, String str)
	{
		
		Select select = new Select(element);
		
		//wait for element visibility
		wait.explicitWait(element);
		
		select.selectByVisibleText(str);
		
	}
	
	public static void selectByVisibleValue(WebElement element,int num)
	{
		Select select=new Select(element);
		
		//wait for element visibility
		wait.explicitWait(element);
		
		String value=Integer.toString(num);
		select.selectByValue(value);
	}
	
	public static void selectByIndex(WebElement element,int index)
	{
		Select select= new Select(element);
		
		//wait for element visibility
		wait.explicitWait(element);
				
		select.selectByIndex(index);
					
	} 
}