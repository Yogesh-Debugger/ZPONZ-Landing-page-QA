package blog;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Blog_1 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yogesh M\\Downloads\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		 
		 try {
			 
		 
		 // Maximize the window
            driver.manage().window().maximize();

         // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         
            driver.get("https://zponz.com/us/en");
		 
		    System.out.println("Page Title: " + driver.getTitle());
		    
		 // Create Actions object
	        Actions actions = new Actions(driver);
	        
		 // Send PAGE_DOWN key to scroll down
	     // actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
	        
	        actions.sendKeys(org.openqa.selenium.Keys.END).perform();// Scroll to bottom
		    
	        Thread.sleep(5000); // Wait for 5 seconds
	        
		    WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/footer/div/div[1]/div[1]/ul/li[3]"));
		    element.click();
		    
		    WebElement element2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/section[2]/section/div[1]/a[2]"));
		    element2.click();
		    
		 // Get all visible text from the webpage
	        String pageText = driver.findElement(By.tagName("body")).getText();

	     // Normalize all variations of "Zponz" for checking
	        boolean containsZponz = pageText.toLowerCase().contains("zponz");
	        boolean containsAllCapsZponz = pageText.contains("ZPONZ");

	        if (containsZponz) {
	            if (containsAllCapsZponz && !pageText.matches("(?i).*\\b(?!ZPONZ)ZPONZ\\b.*")) {
	                System.out.println("PASS: Only 'ZPONZ' is used in capital letters.");
	            } else {
	                System.out.println("FAIL: 'ZPONZ' is found in lowercase or mixed case.");
	            }
	        } else {
	            System.out.println("INFO: 'ZPONZ' not found on the page.");
	        }
		   
	     } catch (InterruptedException e) {
           e.printStackTrace();
         
   
     }

         
	}
	
}
	
	
