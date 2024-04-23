package orangeHRM_AUTO;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	String driverPath = "C:\\Users\\Administrator\\OneDrive\\Documents\\Uncodemy\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	WebDriver driver = new ChromeDriver();

	@BeforeTest	
	void navigate_functionality() throws InterruptedException, IOException{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\OneDrive\\Documents\\Uncodemy\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@Test(priority=1)
	void username_functionality() throws InterruptedException, IOException {	
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='username']"));
		username.sendKeys("Admin");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("admin123");
		Thread.sleep(2000);

		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		Thread.sleep(2000);	
	}

	@Test(priority=2)
	void buzz_functionality() throws InterruptedException, IOException{

		WebElement buzz = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[12]"));
		buzz.click();
		Thread.sleep(2000);

		WebElement textfield = driver.findElement(By.xpath("//textarea[@placeholder=\"What's on your mind?\"]"));
		textfield.sendKeys("Neelam_Panwar");
		Thread.sleep(2000);
	}

	@Test(priority=3)
	void buzz_POST() throws InterruptedException, IOException {

		WebElement post = driver.findElement(By.xpath("//button[@type='submit']"));
		post.click();
		Thread.sleep(2000);
	}

	@AfterTest
	void quit_functionality() {
		driver.quit();
	}
}
