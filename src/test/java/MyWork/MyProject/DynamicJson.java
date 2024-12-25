package MyWork.MyProject;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

@Test(dataProvider="BooksData")
public class DynamicJson {

	//public static void main(String[] args)
	//{
		//addBook();
	//}
	public void addBook(String isbn, String aisle)
	{
	RestAssured.baseURI = "http://216.10.245.166";
	String response=given().log().all().header("Content-Type", "application/json")
	.body(Payload.addBook(isbn, aisle))
	.when().post("/Library/Addbook.php")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
	JsonPath js=new JsonPath(response);
	String ID = js.getString("ID");
	System.out.println(ID);
	}

	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"respect","321"},{"peace","731"},{"understanding","432"}};
	}
}
