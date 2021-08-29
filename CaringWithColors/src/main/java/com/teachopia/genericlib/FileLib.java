package com.teachopia.genericlib;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** This class contains all external files to extract the data
 * 
 * @author Gowtham N U
 *
 */
public class FileLib 
{
	/******
	 * this method returns all the values of a key present in a propery file
	 * @return String
	 */
	public String getDataFromPrpoertyFile(String key)
	{
		Properties pop = null;
		try 
		{
			FileInputStream fip = new FileInputStream("D:\\d\\gowtham 1\\Appium\\CaringWithColors\\src\\main\\java\\com\\commonData\\commonData.Properties");
			
			pop = new Properties();
			
			pop.load(fip);
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return pop.getProperty(key);
	}
	
	/**This method returns specific value from excel file.
	 * 
	 * @param sh
	 * @param row
	 * @param cell
	 * @return String
	 */
	public String getSpecifiedDataFromExcelFile(String sheetname, int row, int cell)
	{
		Sheet sh = null;
		try 
		{
			FileInputStream fip = new FileInputStream("D:\\d\\gowtham 1\\Appium\\CaringWithColors\\src\\main\\java\\com\\commonData\\Teachopia_Datasheet.xlsx");
			
			Workbook wb = WorkbookFactory.create(fip);
			
			sh = wb.getSheet(sheetname);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return sh.getRow(row).getCell(cell).getStringCellValue();
	}
	
	/****This method returns all the data from Excel file
	 * 
	 * @param sheetname
	 * @return Object[][]
	 */
	public Object[][] getAllDataFromExcelFile(String sheetname)
	{
		Sheet sh = null;
		Object[][] data = null;
		try 
		{
			FileInputStream fip = new FileInputStream("D:\\d\\gowtham 1\\Appium\\CaringWithColors\\src\\main\\java\\com\\commonData\\Teachopia_Datasheet.xlsx");
		
			Workbook wb = WorkbookFactory.create(fip);
			
			sh = wb.getSheet(sheetname);
			
			int rownum = sh.getLastRowNum();
			int cellnum = sh.getRow(0).getLastCellNum();
			
			data = new Object[rownum][cellnum];
			
			for (int i = 0; i < rownum; i++) 
			{
				for (int j = 0; j < cellnum; j++) 
				{
					data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
}
