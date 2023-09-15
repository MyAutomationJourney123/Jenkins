package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * This class is used to write Java utilities
 * @author texan
 *
 */
public class JavaUtility 
{
	/**This method will return random number for every execution
	 * 
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(1000);
				
	}
	
	/**
	 * This method will generate and return the current system date in specified format
	 * @return
	 */
	public String getSystemDate()
	{
		
	//Note there is java.sql.date and java.util.date - we shud use Util
	Date d=new Date();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	
	String date = formatter.format(d);
	return date;
	}
	
	
}
