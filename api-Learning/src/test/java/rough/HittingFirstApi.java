package rough;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bold.common.Utility;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HittingFirstApi {

	@Test
	public void exportToDoc() throws IOException {

		Response response = given().queryParam("use_aspose", "true").contentType(ContentType.JSON)
				.body(Utility.getJsonFile("DOCX"))
				.post("https://api-sandbox-rex.livecareer.com/v2/documents/export").then().extract().response();
		// System.out.println(response.asString());

		response.prettyPrint();

		// JSONObject jsonObj = new JSONObject(response.body().asString());
		// System.err.println(jsonObj.get("BinaryData"));

		JsonPath jsp = response.jsonPath();

		String binaryData = (jsp.get("BinaryData"));

		//System.out.println("Binary data in response " + binaryData);

		int numOfPages = jsp.getInt("NumOfPages");

		System.out.println("Number of pages in resume :" + numOfPages);

		if (response.getStatusCode() == 200) {
			FileOutputStream file = new FileOutputStream(new File("test.docx"));
			file.write(Base64.decodeBase64(binaryData));
			file.close();
		} else
			Assert.fail();
	}
	
	
	

	@Test
	public void exportTopdf() throws IOException
	{
		
		Response response = given().contentType(ContentType.JSON)
				.body(Utility.getJsonFile("pdf"))
				.post("https://api-sandbox-rex.livecareer.com/v2/documents/export").then().extract().response();
		
		System.out.println(response.prettyPrint());
		JsonPath jsonpath = response.jsonPath();
		
		String binarydata =	jsonpath.get("BinaryData");
		
		int numofpages = jsonpath.getInt("NumOfPages");
		
		System.out.println("Number of pages in pdf "+numofpages);
		
		
		if(response.getStatusCode()==200)
		{
			FileOutputStream file = new FileOutputStream(new File("test.pdf"));
			Files.write(Paths.get("test.pdf"),Base64.decodeBase64(binarydata ));
			file.close();
		} else
			Assert.fail();
			
			
		}
				
		
	

	/*
	 * @Test public void verfyApiApache() {
	 * 
	 * String postUrl =
	 * "https://api-sandbox-rex.livecareer.com/v2/documents/export"; HttpPost
	 * postObj = new HttpPost(postUrl);
	 * postObj.setHeader("accept","application/json"); postObj.setEntity(new
	 * StringEntity(""));
	 * 
	 * 
	 * Response response = given().queryParam("use_aspose",
	 * "true").contentType(ContentType.JSON).body(new File
	 * (".\\src\\test\\resources\\inputJsonFiles\\SampleData.json"))
	 * .when().post("https://api-sandbox-rex.livecareer.com/v2/documents/export").
	 * then().extract().response(); //response.prettyPrint();
	 * 
	 * JSONObject jsonObj = new JSONObject(response.body().asString()); //
	 * System.err.println(jsonObj.get("BinaryData"));
	 * 
	 * JsonPath jsp = response.jsonPath(); String binaryData =
	 * (jsp.get("BinaryData"));
	 * 
	 * int numOfPages = jsp.getInt("NumOfPages");
	 * 
	 * Assert.assertEquals(response.getStatusCode(), 200);
	 * 
	 * 
	 * }
	 */

}

