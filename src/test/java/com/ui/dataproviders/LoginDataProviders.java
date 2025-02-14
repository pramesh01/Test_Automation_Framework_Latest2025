package com.ui.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.constants.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProviders {
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginTest.csv");
		
	}
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFileData("loginTest.xlsx");
		
	}

}
