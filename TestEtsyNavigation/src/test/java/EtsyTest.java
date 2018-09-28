import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class EtsyTest {
	WebDriver browser;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		browser = new ChromeDriver();
	}
	
    @Test public void testRegisterInEtsy() {
        EtsyMethods classUnderTest = new EtsyMethods();
        browser.get(Constants.URL);
        browser.manage().window().maximize();
        assertTrue("testRegisterInEtsy should return 'true'", classUnderTest.registerInEtsy(browser));
    } 
    
    @Test public void testGetStuffInEtsy() {
        EtsyMethods classUnderTest = new EtsyMethods();
        browser.get(Constants.URL);
        browser.manage().window().maximize();
        assertTrue("getStuffInEtsy should return 'true'", classUnderTest.searchForStuffInEtsy(browser));
    }
    
    @After
    public void tearDown() {
    	browser.close();
    }
}
