package my.RestfulBooker.APIs.TestNG.RestfulBookerAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import my.RestfulBooker.APIs.TestNG.RestfulBookerAPI.PostParams.BookingPostParams;

public class CreateBooking extends TestBase{
	
	String s= 	"{\r\n    \"firstname\" : \"hjg\",\r\n    \"lastname\" : \"jjj\",\r\n    \"totalprice\" : 12,\r\n    \"depositpaid\" : 34,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"40\",\r\n        \"checkout\" : \"68\"\r\n    },\r\n    \"additionalneeds\" : \"yes\"\r\n}";

	DateFormat formatter = null;
	Date convertedDate1 = null;
	Date convertedDate2 = null;


	   @Test(dataProvider = "bookingParameters")
	    public void setBooking(String firstname, String lastname, int totalprice, boolean depositpaid, String bookingdates_checkin, String bookingdates_checkout, String additionalneeds) throws ParseException {
	    	System.out.println("\nTest "+Thread.currentThread().getStackTrace()[1].getMethodName()+":\n");
	    	BookingPostParams bookingPostParams = new BookingPostParams(firstname,lastname,totalprice,depositpaid,bookingdates_checkin,bookingdates_checkout,additionalneeds);
	        given().
	        when().
	        spec(requestSpec).
	        contentType(ContentType.JSON).
	        header("Accept", "application/json").
	        body(bookingPostParams).
            post("/booking").
	        then().
	            assertThat().
	            spec(responseSpec).
	            body("isEmpty()", Matchers.is(false)).
	            body("booking.firstname", Matchers.equalTo(firstname)).
	            body("booking.lastname", Matchers.equalTo(lastname)).
	            body("booking.totalprice", Matchers.equalTo(totalprice)).
	            body("booking.depositpaid", Matchers.equalTo(depositpaid)).
	            body("booking.bookingdates.checkin", Matchers.not(Matchers.isEmptyOrNullString())).
	            body("booking.additionalneeds", Matchers.equalTo(additionalneeds));
	        
	        String yyyyMMdd1 = "1988-05-12";
	        String yyyyMMdd2 = "1754-01-25";

	        formatter =new SimpleDateFormat("yyyy-MM-dd");
	
	        convertedDate1 =(Date) formatter.parse(yyyyMMdd1);
	        convertedDate2 =(Date) formatter.parse(yyyyMMdd2);
	        System.out.println("Date from yyyyMMdd1 and yyyyMMdd2 Strings in Java : " + convertedDate1 + " "+convertedDate2);
	    }
	   
	   @DataProvider
	    public static Object[][] bookingParameters() {
	        return new Object[][] {
	            { "Sally", "Ericsson", 7, true, "1988-05-12", "1754-01-25", "" },
	        };
	    }   
	   
}


