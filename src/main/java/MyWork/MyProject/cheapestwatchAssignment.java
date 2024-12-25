package MyWork.MyProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cheapestwatchAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[text()='Watches']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Fossil Watches");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> watches = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		System.out.println("List size: "+watches.size());
	
	
	
		int cheapest=50000;
		for(int i=0;i<watches.size();i++)
		{
		if(!watches.get(i).getText().equalsIgnoreCase(""))
		{	
		String price=watches.get(i).getText();
		System.out.println(price);
		String finalprice = price.replace(",","");
		System.out.println(finalprice);
		
		int num= Integer.parseInt(finalprice);
		if(num<cheapest)
		{
			cheapest=num;
		}
		}
		}
		System.out.println("Cheapest watch price:"+cheapest);
		
	
		
		

		}
	}

	


