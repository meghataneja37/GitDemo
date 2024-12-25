package MyWork.MyProject;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;

@SuppressWarnings("deprecation")
public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	RestAssured.baseURI="http://localhost:8080";
	
	//login scenario
	SessionFilter session= new SessionFilter();
	
	
	String response=given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json").body("{\"username\": \"meghataneja13\", \"password\": \"23102017\"}")
	.log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
	String expectedMessage ="Hi, how are you?";
	//Add Comment
		String addCommentresponse=given().log().all().pathParam("key", "10102").header("Content-Type", "application/json").body("{\r\n"
				+ "    \"body\": \""+expectedMessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(addCommentresponse);
		String commentID=js.getString("id");

		
		//Add Attachment
		given().log().all().header("X-Atlassian-Token","no-check").filter(session)
		.pathParam("key", "10102").header("Content-Type", "multipart/form-data").multiPart("file", new File("Jira.txt"))
		.when().post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		String IssueDetails=given().log().all().filter(session).pathParam("key", "10102")
				.queryParam("fields", "comment")
				.when().get("rest/api/2/issue/{key}").then()
		.log().all().extract().response().asString();
			System.out.println(IssueDetails);
			
			JsonPath js1 = new JsonPath(IssueDetails);
			int commentCount = js1.getInt("fields.comment.comments.size()");
			for (int i=0; i<commentCount; i++)
			{
				String commentIDIssue= js1.get("fields.comment.comments["+i+"].id").toString();
				if (commentIDIssue.equalsIgnoreCase(commentID))
				{
					String message = js1.get("fields.comment.comments["+i+"].body").toString();
					System.out.println(message);
				Assert.assertEquals(expectedMessage, message);
				}
			}
	}

}
