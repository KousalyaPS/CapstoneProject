package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart {
	
	WebDriver driver;
	
	public AddtoCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
			
	public void productselection()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1)) ;
		WebElement getProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'prod.html?idp_=2')]")));
		getProduct.click();
		
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Add to cart')]")));
		addToCart.click();
	}
	
	public void checkout(String name, String country, String city, String card, String month, String year)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1)) ;
		WebElement getProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Cart')]")));
		getProduct.click();
		
		WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Place Order')]")));
		placeOrder.click();
		
		wait = new WebDriverWait(driver, Duration.ofMinutes(1)) ;
		WebElement CName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
		CName.sendKeys(name);
		
		WebElement CCountry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='country']")));
		CCountry.sendKeys(country);
		
		WebElement CCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
		CCity.sendKeys(city);
		
		WebElement CCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card']")));
		CCard.sendKeys(card);
		
		WebElement CMonth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='month']")));
		CMonth.sendKeys(card);
		
		WebElement CYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='year']")));
		CYear.sendKeys(card);
		
		WebElement purchase = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Purchase')]")));
		purchase.sendKeys(card);
		
	}

}

