package COM.appium.AndroidAutomation;

import org.testng.annotations.Test;

public class Script_001 extends Base {
	
	@Test
	public static void sanityTest()
	{
		AndroidDriverManager.waitTillAppiumServerStarts();
		AndroidDriverManager.getAndroidDriver();
		//AndroidDriverManager.quitAndroidDriver();
		
	}
	

}
