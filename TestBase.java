package my.RestfulBooker.APIs.TestNG.RestfulBookerAPI;


import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestBase {
	
	public static RequestSpecification requestSpec;
	public static ResponseSpecification responseSpec;
	
	
	@BeforeClass
    public static void createRequestSpecification() {
    
        requestSpec = new RequestSpecBuilder().
            setBaseUri("http://192.168.99.100:3001").
            
            log(LogDetail.ALL).
            build();
    }
	
	@BeforeClass
	    public static void createResponseSpecification() {
     	        responseSpec = new ResponseSpecBuilder().
	            expectStatusCode(200).
	            expectContentType(ContentType.JSON).
	            log(LogDetail.ALL).
	            build();
	    }

}
