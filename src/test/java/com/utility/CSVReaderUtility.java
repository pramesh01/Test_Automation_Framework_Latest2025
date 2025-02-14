package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.constants.User;
import com.opencsv.CSVReader;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSVFile(String fileName) {
		FileReader filereader;
		CSVReader csvreader;
		String[] data;
		List<User> listUser=null;
		
		File f=new File(System.getProperty("user.dir")+"//TestData//"+fileName);
		try {
		filereader=new FileReader(f);
		csvreader=new CSVReader(filereader);
		csvreader.readNext(); //1st row columns
		//data=csvreader.readNext(); //2nd row of actual data starts. if no data it will show u null;
		listUser=new ArrayList<User>();
		User userData;
		while((data=csvreader.readNext())!=null){
			userData=new User(data[0],data[1]);
			listUser.add(userData);
		}
		//System.out.println(Arrays.toString(data));
		for(User user:listUser) {
			System.out.println(user);
		}
		}catch(Exception e){
			e.getMessage();
		}
		return listUser.iterator();
		
	}

}
