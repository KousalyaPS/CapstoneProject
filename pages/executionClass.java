package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class executionClass {
	
	WebDriver driver;
	HomePage homePage;
	AddtoCart addtoCart;
	//extentreport extentReport;
	Screenshots screenshot;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Kousi\\Capstone\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		addtoCart = new AddtoCart(driver);
		screenshot = new Screenshots();
	}
	
	@Test(priority=1)
	public void signupNew() {
		homePage.signupPage("test@123", "Pass1245");
		extentreport extentReport= new extentreport("SignUp");
		extentReport.logPass("Signup successful");
		extentReport.generateReport();
	}
	
	@Test(priority=2)
	public void login() {
		homePage.loginPage("test@123", "Pass1245");
		extentreport extentReport= new extentreport("Login");
		extentReport.logPass("Login successful");
		extentReport.generateReport();
	}
	
	@Test(priority=3)
	public void checkout() {
		addtoCart.productselection();
		addtoCart.checkout("Test", "USA", "Newyork", "12345678", "12", "2025");
		extentreport extentReport= new extentreport("Checkout");
		extentReport.logPass("Checkout successful");
		extentReport.generateReport();
	}
	
	
	@AfterMethod
	public void tearDown() {
	screenshot.captureScreenshot(driver, "screen");
	//extentReport.generateReport();
	driver.quit();
	}
	
}
