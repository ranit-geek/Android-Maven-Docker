package COM.appium.AndroidAutomation;

import io.appium.java_client.android.AndroidDriver;

public class Base {
	@SuppressWarnings("rawtypes")
	protected static AndroidDriver driver;
	
	protected static String appPath= System.getProperty("user.dir")+"/app/demo.apk";
	protected static int portappium=4723;
	protected static String appiumurl= "http://localhost:4723/wd/hub";

}
