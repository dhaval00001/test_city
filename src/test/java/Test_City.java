import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test_City {
	
	@Test(priority = 1)
	public void  TestCityData()
	{
		//base url
		RestAssured.baseURI = "https://restcountries.com/v3.1/capital/";
		
		//Request object
		RequestSpecification httprequest= RestAssured.given();
		
	    
		while(true)
	    {

			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			System.out.println("Enter city capital");

			String city = myObj.nextLine().toLowerCase();  // Read user input
			if (city.equals("quit"))
			{
				break;
			}
		    System.out.println("capital is: " + city);  // Output user input
		    
			//response object
			Response response = httprequest.request(Method.GET,city);
			
			//print response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response body is: "+ responseBody);
					//status code
			int statusCode = response.getStatusCode();
			System.out.println("status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
			//status line
			String statusLine= response.getStatusLine();
			System.out.println(statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			Assert.assertTrue(responseBody.contains("Russia"));
			
	    }
	}
	@Test(priority = 2)
	public void  Limaa()
	{
		String city = "limaa";
		//base url
		RestAssured.baseURI = "https://restcountries.com/v3.1/capital/";
				
		//Request object
		RequestSpecification httprequest= RestAssured.given();
		//response object
		Response response = httprequest.request(Method.GET,city);
		//print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: "+ responseBody);
		
		//status code
		int statusCode = response.getStatusCode();
		System.out.println("status code is: "+ statusCode);
		if(statusCode<=400) {
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		
	}
}
	@Test(priority = 3)
	public void  Moscow()
	{
		String city = "moscow";
		//base url
		RestAssured.baseURI = "https://restcountries.com/v3.1/capital/";
				
		//Request object
		RequestSpecification httprequest= RestAssured.given();
		//response object
		Response response = httprequest.request(Method.GET,city);
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(responseBody.contains("Russia"),true);
		
	
}
}
