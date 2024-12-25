package MyWork.MyProject;
import io.restassured.path.json.JsonPath;


public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js=new JsonPath(Payload.CoursePrice());
		int Count = js.getInt("courses.size()");
		System.out.println(Count);
		
		int TotalAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalAmount);
		
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println(titleFirstCourse);
		
		for (int i=0; i<Count; i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitles);
			
		}
		
		System.out.println("print no of copies sold by RPA course");
		
		for (int i=0; i<Count; i++)
		{
			String courseTitles= js.getString("courses["+i+"].title");
				if(courseTitles.equalsIgnoreCase("RPA"))
				{
					int copies =js.getInt("courses["+i+"].copies");
					System.out.println(copies);
					break;
			}
		}
	}
}

