package com.TYSS.Renaa_TMS_Hybrid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	/**
	 * This method gives the path of properties class
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String propertyFilePath(String file) throws IOException {
	FileInputStream fis= new FileInputStream("./src/test/resources/allPaths.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String filepath = pobj.getProperty(file).toString();
	return filepath;
}
	/**
	 * Used to get the value from the file
	 * @param path
	 * @param key
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String filePathValue(String path, String key) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream(path);
		Properties pobj=new Properties();
		pobj.load(fis1);
		String value = pobj.getProperty(key).toString();
		return value;
		
	}
	
}
