import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class DownloadPopUp {

	public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		try {
			System.setProperty("webdriver.chrome.driver","H:\\SeleniumFolder\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.naukri.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//Return a string of window handle
			String window = driver.getWindowHandle();
			System.out.println("Main Window:"+window);
			Set<String> handle= driver.getWindowHandles();
			System.out.println(handle);
			Iterator< String> it = handle.iterator();

			while(it.hasNext()) {
				String windowchild = it.next();
				if(!windowchild.equals(window)) {
					driver.switchTo().window(windowchild);
					driver.close();
				}
			}
			driver.switchTo().window(window);


			driver.findElement(By.id("login_Layer")).click();
			driver.findElement(By.xpath("//span[text()='Google']")).click();
			Iterator<String> it2 = driver.getWindowHandles().iterator();
			while(it2.hasNext()) {
				String child = it2.next();
				if(!child.equals(window)) {
					driver.switchTo().window(child);
				}
			}

			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("modisam26@gmail.com");
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234samb");
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			driver.switchTo().window(window);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[text()='Sambhaw Jain']")).click();
			Thread.sleep(15000);
			System.out.println(driver.getTitle());

			WebElement icon = driver.findElement(By.xpath(".//i[@class='icon']"));

			System.out.println("is displayed:"+icon.isDisplayed()+" is enabled:"+icon.isEnabled());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  300 pixel vertical
			if(icon.isDisplayed()&&icon.isEnabled()) {
				js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",icon);
			}
			Thread.sleep(3000);
		}

		catch( Exception e) {

			e.printStackTrace();

		}

		finally {

			driver.quit();
		}

	}

}


