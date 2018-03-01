package MainScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import ElementsBehaviour.Button;
import ElementsBehaviour.DropDown;
import ElementsBehaviour.TextField;
import ObjectRepository.SearchPage;
import ReusableCode.Browsers;

public class SearchContacts extends Browsers{
	
  @Test
  public void searchContactsCount() throws IOException 
  {
	  
	 //Launch URL
	 driver.get("https://www.google.co.in");
	  
	 //Read data from Excel  
	 String fileName=TestData.ExcelData.excelInfo;	    
	 File file=new File(fileName);
	 FileInputStream fis=new FileInputStream(file);
	  
	 //Read data from Excel(.xlsx)		 
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);	  
	  XSSFSheet sheet=workbook.getSheet("master");
	  
	  int recordsCount=sheet.getLastRowNum()- sheet.getFirstRowNum();

	for(int i=1;i<=recordsCount;i++)
	{
		//Search By Elements
		
		String filterTypeValue=sheet.getRow(i).getCell(13).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.filterTypeDropDown),filterTypeValue);
		
		String filterCondValue = sheet.getRow(i).getCell(14).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.filterCondDropDown),filterCondValue);
		
		double filterValue=sheet.getRow(i).getCell(15).getNumericCellValue();
		
		int value=(int) filterValue;
		
		TextField.FillNumericValue(driver.findElement(SearchPage.filterValueTextBox), value);
		
		//Primary Service Elements
		
		String serviceTypeValue=sheet.getRow(i).getCell(16).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.serviceTypeDropDown), serviceTypeValue);
		
		String statusValue=sheet.getRow(i).getCell(17).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.statusDropDown), statusValue);
		
		//Secondary Service Elements
		
		String secondarySvcTypeValue=sheet.getRow(i).getCell(18).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.secondarySvcTypeDropDown), secondarySvcTypeValue);
		
		String secondaySvcStatus=sheet.getRow(i).getCell(19).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.secondarySvcStatusDropDown), secondaySvcStatus);
		
		//DateRange
		
		String dateRangeValue=sheet.getRow(i).getCell(20).getStringCellValue();
		DropDown.selectByVisibleText(driver.findElement(SearchPage.dateRangeDropDown), dateRangeValue);
		
		//Results per page
		
		double rangeValue=sheet.getRow(i).getCell(23).getNumericCellValue();
		
		int range=(int) rangeValue;
		
		DropDown.selectByVisibleValue(driver.findElement(SearchPage.dateRangeDropDown), range);
		
		//Click on Search
		
		Button.clickButton(driver.findElement(SearchPage.searchButton));
		
		//Get search results text
		
		double expected=sheet.getRow(i).getCell(27).getNumericCellValue();
		
		int expectedResult=(int)expected;
		
		String result=driver.findElement(SearchPage.searchResultText).getText();
		
		String actual[]=result.split("");
		
		int actualResult=Integer.parseInt(actual[0]);
		
		Assert.assertEquals(expectedResult, actualResult);
		
		
		
								
	} 
  }
}
