package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile 
{
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties p=new Properties();
		p.load(fis);
		
		String url=p.getProperty("url");
		System.out.println("URL:" + url);
		
		String browser=p.getProperty("browser");
		System.out.println("Browser:"+browser);
		
		String user_name=p.getProperty("uname");
		System.out.println("User Name:"+ user_name);
		
		String title=p.getProperty("title");
		System.out.println("Title:"+title);
		
		
	}

}
