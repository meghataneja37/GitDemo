package MyWork.MyProject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Array_Ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String[] itemsNeeded= {"Cucumber", "Mushroom", "Beetroot", "Carrot", "Pumpkin"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<items.size();i++)
		{
			String[] productName = items.get(i).getText().split("-");
			String formattedName = productName[0].trim();
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			int j=0;
			
			if(itemsNeededList.contains(formattedName))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}
				
			}
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
}
