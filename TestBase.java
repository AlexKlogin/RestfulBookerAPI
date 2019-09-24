package my.RestfulBooker.APIs.TestNG.RestfulBookerAPI;


import org.apache.logging.log4j.io.IoBuilder;

import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestBase {
	
	public static  RequestSpecification  requestSpec;
	public   ResponseSpecification  responseSpec;
	Logger logger;
	RestAssuredConfig restAssuredConfig;
	PrintStream logStream;
	
	@BeforeClass
    public void createRequestSpecification() {
		 logger = Logger.getLogger(this.getClass());
		 logStream = IoBuilder.forLogger( ).buildPrintStream();
		 restAssuredConfig = new RestAssuredConfig();
		 LogConfig logConfig = restAssuredConfig.getLogConfig(); 
		 logConfig
		 .defaultStream(logStream)
		 .enablePrettyPrinting(true);
		 
		 //new RequestLoggingFilter();
        requestSpec = new RequestSpecBuilder().
            setBaseUri("http://192.168.99.100:3001").
            addFilter(new RequestLoggingFilter().logRequestTo(logStream)).
            addFilter(new ResponseLoggingFilter().logResponseTo(logStream)).
            log(LogDetail.ALL).
            setConfig(restAssuredConfig).
            build();
    }
	
	@BeforeClass
	    public  void createResponseSpecification() {
     	        responseSpec = new ResponseSpecBuilder().
	            expectStatusCode(200).
	            expectContentType(ContentType.JSON).
	            log(LogDetail.ALL).
	            build();
	    }

}
