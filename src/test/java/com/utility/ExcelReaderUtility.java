package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFileData(String fileName) {
	 	
		String excelsheetpath=System.getProperty("user.dir")+"//TestData//"+fileName;
		File filePath=new File(excelsheetpath);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		List<User> userList=new ArrayList<User>();
		XSSFSheet xssfSheet=xssfWorkbook.getSheet("LoginTestData");
		Iterator<Row> rowIterator = xssfSheet.iterator();
		rowIterator.next();
		Row row;
		Cell emailIDcell;
		Cell passwordcell;
		User userData;
		while(rowIterator.hasNext()) {
			row = rowIterator.next();
			emailIDcell=row.getCell(0);
			passwordcell=row.getCell(1);
			userData=new User(emailIDcell.toString(),passwordcell.toString());
			userList.add(userData);
			try {
				xssfWorkbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userList.iterator();
		
		
	}
     }
