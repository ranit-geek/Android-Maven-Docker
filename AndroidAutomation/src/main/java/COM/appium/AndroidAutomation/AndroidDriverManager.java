package COM.appium.AndroidAutomation;

import java.net.Socket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverManager extends Base {
	
	
	

	
	@SuppressWarnings("rawtypes")
	public static void getAndroidDriver() 
	{
        try {
        	
        		
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
	            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
	            capabilities.setCapability(MobileCapabilityType.UDID, "bb35dad7");
	            capabilities.setCapability(MobileCapabilityType.APP, appPath);
	            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 0);    // Never timeout.

	            
	            URL appiumur=new URL(appiumurl);

	            driver = new AndroidDriver(appiumur, capabilities);
	            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	          

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	
	public static void quitAndroidDriver()
	{
	
		driver.quit();;
		
	}
	
	public static boolean serverListening(String host, int port)
	{
	    Socket s = null;
	    try
	    {
	        s = new Socket(host, port);
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	    finally
	    {
	        if(s != null)
	            try {s.close();}
	            catch(Exception e){}
	    }
	}
	    
	 public static boolean waitTillAppiumServerStarts()
	    {
		 long i=0;
	    	while(serverListening("localhost",portappium)!=true && i<500)
	    	{
	    		i++;  //wait
	    	}
	    	
	    	return true;
	    	
	    	
	    }
	    
	}

