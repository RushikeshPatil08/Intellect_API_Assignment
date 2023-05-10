package com.intellect.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import org.testng.annotations.BeforeSuite;

import jxl.read.biff.BiffException;

public class TestBase {

	public static Properties properties;

	public void init() throws IOException {
		properties = new Properties();
		loadData("config.properties");

	}
	

	public void loadData(String PropertiesFileName) throws IOException {
		File file = new File(System.getProperty("user.dir") + "/" + PropertiesFileName);
		FileInputStream propertyFile = new FileInputStream(file);
		properties.load(propertyFile);
	}
	
	public void updateProperty(String key, String value) throws IOException
	{
		File file = new File(System.getProperty("user.dir") + "/" + "config.properties");
		FileOutputStream out = new FileOutputStream(file);
		properties.setProperty(key, value);
		properties.store(out, null);
		out.close();
	}
	

	public String[][] getData(String excelFilePath, int sheetNo) throws BiffException, IOException {
		ExcelReader read = new ExcelReader();
		String[][] data = read.readExcel(excelFilePath, sheetNo);
		return data;
	}
	
	public int getCurrentTimestamp()
	{
		int max = 9999;
		int min = 1;
		SimpleDateFormat currentTimestamp = new SimpleDateFormat("ssSSS");
		currentTimestamp.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateTime = currentTimestamp.format(new Date());
		Random rand = new Random();
		int randomNum = (rand.nextInt((max - min) + 1) + rand.nextInt((max - min) + 1)) / 2;
		String uniqueId = String.valueOf(randomNum)+dateTime;
		
		return (int)Integer.valueOf(uniqueId);
	}

}
