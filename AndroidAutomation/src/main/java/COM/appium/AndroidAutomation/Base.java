package COM.appium.AndroidAutomation;

import org.apache.log4j.Logger;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	protected static AndroidDriver driver;
	
	protected static String appPath= System.getProperty("user.dir")+"/src/main/App/demo.apk";
	protected static int portappium=4723;
	protected static String appiumurl= "http://localhost:4723/wd/hub";

}
