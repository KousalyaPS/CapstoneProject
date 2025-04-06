package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login2") private WebElement login;
	@FindBy(id="signin2") private WebElement signup;
	
	public WebElement getLogin() {
		return login;
	}

	public WebElement getSignup() {
		return signup;
	}

	public void signupPage(String UN,String Pass)
	{
		getSignup().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1)) ;
		WebElement elementUserName = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
		elementUserName.sendKeys(UN);
		
		WebElement elementPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-password")));
		elementPassword.sendKeys(Pass);
		
		WebElement elementSignUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]")));
		elementSignUpButton.click();
		
	}
	
	public void loginPage(String UN,String Pass)
	{
		getLogin().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1)) ;
		WebElement elementUserName = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
		elementUserName.sendKeys(UN);
		
		WebElement elementPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
		elementPassword.sendKeys(Pass);
		
		WebElement elementLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")));
		elementLoginButton.click();

	}
}

