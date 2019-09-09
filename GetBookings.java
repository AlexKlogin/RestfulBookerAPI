package my.RestfulBooker.APIs.TestNG.RestfulBookerAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class GetBookings extends TestBase{
	
    @Test
    public void getAllBookings() {
    	System.out.println("\nTest "+Thread.currentThread().getStackTrace()[1].getMethodName()+":\n");
        given().
        when().
        spec(requestSpec).
            get("/booking").
        then().
            assertThat().
            spec(responseSpec).
            body("isEmpty()", Matchers.is(false));
    }
    
    @Test(dataProvider = "searchParameters")
    public void searchByFirstName(String firstname, String lastname) {
    	System.out.println("\nTest "+Thread.currentThread().getStackTrace()[1].getMethodName()+":\n");
        given().
        when().
        spec(requestSpec).
            get("/booking?firstname="+firstname).
        then().
            assertThat().
            spec(responseSpec).
            body("bookingid", Matchers.hasItems(8));
    } 
    
	@DataProvider
    public static Object[][] searchParameters() {
        return new Object[][] {
            { "Sally", "Ericsson" },
        };
    }
}
