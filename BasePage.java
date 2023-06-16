package BasePage;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {


	private static final CharSequence ExpirationDate = null;
	public WebDriver driver;
	public Properties prop;
	
	 public void setbrowser(String browsertype , String amazonurl) {
		 try {
		// String amazonurl = prop.getProperty("url");
//		 String browsertype = prop.getProperty("browser");
		 if(browsertype.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 driver.get(amazonurl);
		 }catch(Exception e) {
			 System.out.println("Error ="+e.getMessage());
		 }
	 }
	
	 public void login(String username , String password) {
		 try {
		 driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@id='continue']")).click();
		 driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		 
		 }catch(Exception e) {
			 System.out.println("Error ="+e.getMessage());
		 }
	 }
	 
	 public void SearchProduct(String productName) {
		 try {
		 // Searching ProductName
			 
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(productName);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 
		 // Select the Product Name
		 driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		 
		 System.out.println("Print to ProductName"+productName);
		  
		 //Switch to New Window
		   String window= driver.getWindowHandle();
		         
		   Set<String> handles = driver.getWindowHandles();
		   for(String handle : handles)
		   {
			   if(!handle.equals(window))
			   {
				   driver.switchTo().window(handle);
			   }
		   }
		   
		   System.out.println("Switch to new window");
		 
		 }catch(Exception e) {
			 
			 System.out.println("Error ="+e.getMessage());
		 }
		 
	 }
	 public void AddtoCart(String CardNumber , String NameOfCard , String ExpirationDate , String ExpirationYear , String SecurityCode ) throws InterruptedException{
		 // Click on Add to Cart
		 String xpath = "(//h3[@class='a-color-secondary']//span[2])[1]";
		 driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
		 
		 System.out.println("Print to Add to Cart");
		 
		 // Click on Proceed
		 driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")).click();
		 
		 System.out.println("Print to Proceed");
		 
		 // Click on choose the card lookup image
		 WebElement paymentbtn =  driver.findElement(By.xpath(xpath));
		 System.out.println("pppppppppppppppppp"+paymentbtn.getText());
		 JavascriptExecutor j = (JavascriptExecutor) driver;
		 j.executeScript("arguments[0].click();", paymentbtn);
		 System.out.println("Print to click on payment");
		 
		 // Use this Address 
		 driver.findElement(By.xpath("(//input[@type='submit' and @class='a-button-input'])[2]")).click();
		 Thread.sleep(5000);
		 
		 System.out.println("Print the Address");
		 
		// Enter the save Quantites
		 driver.findElement(By.xpath("//input[@name='continue-bottom']")).click();
				 
		 System.out.println(" Print the Save Quantites");
		 
		 //payment Check box Radio Button
		 driver.findElement(By.xpath("//input[@value='SelectableAddCreditCard']")).click();
		 
		 System.out.println("Click on Box Radio ");
		 
		 Thread.sleep(3000);
		 
		
		 
		 // Enter the Card Details
		 WebElement cardNumberTxtBox =  driver.findElement(By.xpath("//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link']"));
		 WebElement btnClick;
		 WebDriverWait wait=new WebDriverWait(driver, 20);
		 
		 btnClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link']")));
		 cardNumberTxtBox.click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@id='pp-uwaQcB-15']")).sendKeys(CardNumber);
		 
		 System.out.println("Print the Crad Details");
		 
		 // Enter the lookup Image
		 driver.findElement(By.xpath("(//img[@class='apx-add-pm-trigger-common-image'])[1]")).click();
		 
		 System.out.println("Print the Lookup Image");
		 
		 
		 // Enter the Card Number
		 driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div/input")).sendKeys(CardNumber);
				 
		 
		 System.out.println("Print the Card Number");
		 
		 //Enter the Expiry Moth
		 driver.findElement(By.xpath("//select[@name='ppw-expirationDate_month']")).sendKeys(ExpirationDate);
		 
		 System.out.println("Print the Expiry Month");
		 
		 //Enter the Expiry Year
		 driver.findElement(By.xpath("//select[@name='ppw-expirationDate_year']")).sendKeys(ExpirationYear);
		 
		 System.out.println("Print The Expiry Year");
		 
		 //Enter the Enter the Card Details Button
		 driver.findElement(By.xpath("//*[@name='ppw-widgetEvent:AddCreditCardEvent']")).click();
		 
		 System.out.println("Print the Card Details");
		 
		 //Enter the CCV 
		 driver.findElement(By.xpath("//input[@id='field']\r\n")).sendKeys(SecurityCode);
		 
		 System.out.println("Print The CCV");
		 
		 // Enter the use this payment (  )
		 driver.findElement(By.xpath("(//input[@class='a-button-input' and @type='submit'])[7]"));
		 
		 System.out.println("Print the use this Payment");
		 
		 //Enter the save card and pay
		 driver.findElement(By.xpath("(//input[@class='a-button-input' and @type='submit'])[7]")).click();
		 
		 System.out.println("Print The Save Card and Pay");
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
}
