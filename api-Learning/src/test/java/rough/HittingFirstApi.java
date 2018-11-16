package rough;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class HittingFirstApi {
	
	
	@Test
	public void verfyApiRestAssured() {
		
		Response response = given().queryParam("use_aspose", "true").contentType(ContentType.JSON).body(new File (".\\src\\test\\resources\\inputJsonFiles\\SampleData.json"))
		.post("https://api-sandbox-rex.livecareer.com/v2/documents/export").then().extract().response();
		//System.out.println(response.asString());
		
		response.prettyPrint();
		
		JSONObject jsonObj = new JSONObject(response.body().asString());
//		System.err.println(jsonObj.get("BinaryData"));
		
		JsonPath jsp = response.jsonPath();
		String binaryData = (jsp.get("BinaryData"));
		
		int numOfPages = jsp.getInt("NumOfPages");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	
		}
	
	/*@Test
	public void verfyApiApache() {
		
		String postUrl = "https://api-sandbox-rex.livecareer.com/v2/documents/export";
		HttpPost postObj = new HttpPost(postUrl);
		postObj.setHeader("accept","application/json");
		postObj.setEntity(new StringEntity(""));
		
		
		Response response = given().queryParam("use_aspose", "true").contentType(ContentType.JSON).body(new File (".\\src\\test\\resources\\inputJsonFiles\\SampleData.json"))
		.when().post("https://api-sandbox-rex.livecareer.com/v2/documents/export").then().extract().response();
		//response.prettyPrint();
		
		JSONObject jsonObj = new JSONObject(response.body().asString());
//		System.err.println(jsonObj.get("BinaryData"));
		
		JsonPath jsp = response.jsonPath();
		String binaryData = (jsp.get("BinaryData"));
		
		int numOfPages = jsp.getInt("NumOfPages");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	
		}*/
		
		
}
