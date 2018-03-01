package ObjectRepository;

import org.openqa.selenium.By;

import ReusableCode.Browsers;

public class SearchPage extends Browsers{
  
   //SearchBy Filters
	public static By filterTypeDropDown =By.id("filterType");
	public static By filterCondDropDown =By.id("filterCond");
	public static By filterValueTextBox =By.name("filterValue");
	
	
	//Primary Service Filters	
	public static By serviceTypeDropDown =By.id("ServiceType");			
	public static By statusDropDown =By.name("status");
	
	//Secondary Service	
	public static By secondarySvcTypeDropDown =By.id("secondarySvcType");	
	public static By secondarySvcStatusDropDown = By.xpath("//select[@class='secondarySvc']");
	
	//Date Range	
	public static By dateRangeDropDown=By.id("DateRange");
	
	//Results Per Page	
	public static By resultsperPageDropDown=By.id("ResultsPerPage");
	
	//Search	
	public static By searchButton=By.id("search");
	
	//SearchResults
	public static By searchResultText=By.xpath("//span[@class='result']");
			
}
