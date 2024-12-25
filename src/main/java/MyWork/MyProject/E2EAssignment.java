package MyWork.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class E2EAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Riya");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("riya@test.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test123");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='Female']")).click();
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("15-11-1988");
		driver.findElement(By.className("btn")).click();
		driver.close();
		
	}

}
