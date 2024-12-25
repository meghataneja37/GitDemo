package MyWork.MyProject;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*; 
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;



public class basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\megha\\MT.json")))).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	
		System.out.println(response);
		
	JsonPath js=new JsonPath(response);
	String placeId=js.getString("place_id");
	
	System.out.println(placeId);
	
	String newAddress ="70 winter walk, USA";
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
.body("{\r\n"
		+ "	\"place_id\":\""+placeId+"\",\r\n"
		+ "	\"address\":\""+newAddress+"\",\r\n"
		+ "	\"key\":\"qaclick123\"\r\n"
		+ "	}")
.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
.body("msg", equalTo("Address successfully updated"));

	
	String getPlaceResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
	.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200)
	.extract().response().asString();
	
	JsonPath js1= new JsonPath(getPlaceResponse);
	String actualAddress= js1.getString("address");
	System.out.println(actualAddress);
	Assert.assertEquals(actualAddress, newAddress);
	}
}