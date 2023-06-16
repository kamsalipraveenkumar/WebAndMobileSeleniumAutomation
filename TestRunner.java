package Runner;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import BasePage.BasePage;

public class TestRunner {
public static Properties proop;
public static FileInputStream fis;
@Test(priority =1)
public void Login() {
	try{
		String filepath = System.getProperty("user.dir")+"\\src\\main\\java\\Pages\\qaframework.properties";
             System.out.println("file path ="+filepath);
		proop = new Properties();
		fis = new FileInputStream(filepath);
		proop.load(fis);
		System.out.println("**********LOGIN*******************");
		String user = proop.getProperty("username");
		String pass =proop.getProperty("password");
		String browserName = proop.getProperty("browser");
		String appurl = proop.getProperty("url");
		String prod = proop.getProperty("productName");
		String cradnuber = proop.getProperty("CardNumber");
		String cardname = proop.getProperty("NameOfCard");
		String expd =proop.getProperty("ExpirationDate");
		String Expy = proop.getProperty("ExpirationYear");
		String secur = proop.getProperty("SecurityCode");
		
			
	BasePage bb = new BasePage();
	bb.setbrowser( browserName , appurl);
	bb.login(user, pass);
	bb.SearchProduct(prod);
	
	bb.AddtoCart(cradnuber ,cardname , expd , Expy , secur );
	}catch(Exception e) {
		System.out.println("Error "+e.getMessage());
	}
}

}
