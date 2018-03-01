package ElementsBehaviour;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ReusableCode.Browsers;
import WaitForElements.Wait;

public class TextField extends Browsers
{
	public static Wait wait=new Wait();
	
  public static void FillText(WebElement element,String text) 
  {
	  wait.explicitWait(element);
	  element.sendKeys(text);
  }
  
public static void FillNumericValue(WebElement element, int num)
{
	wait.explicitWait(element);
	  String text=Integer.toString(num);
	  element.sendKeys(text);
}
  public static String getText(WebElement element)
  {
	  wait.explicitWait(element);
	  String text=element.getText();
	  return text;  
  }
  
  public static void clearText(WebElement element)
  {
	  wait.explicitWait(element);
	  element.clear();
  }
  
  }
