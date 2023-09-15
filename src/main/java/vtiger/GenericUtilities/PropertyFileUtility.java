package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author texan
 *
 */

public class PropertyFileUtility 
{
	/**
	 * This method is used to read data from property file and return value to caller
	 * @param PropertyFileKey
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String PropertyFileKey) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(PropertyFileKey);
		return data;
		
		
	}
	
}
