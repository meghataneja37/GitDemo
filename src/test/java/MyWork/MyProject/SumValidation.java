package MyWork.MyProject;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public static void SumofCourses()
	{
		int Sum = 0;
		JsonPath js=new JsonPath(Payload.CoursePrice());
		int Count = js.getInt("courses.size()");
		for (int i=0; i<Count; i++)
		{
		int price=js.getInt("courses["+i+"].price");
		int copies=js.getInt("courses["+i+"].copies");
		int amount = price*copies;
		System.out.println(amount);
		Sum = Sum+amount;
		}
		System.out.println(Sum);
		int PurchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(Sum,PurchaseAmount);
		
	}

}
