package my.RestfulBooker.APIs.TestNG.RestfulBookerAPI.PostParams;

	
	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;






	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"firstname",
	"lastname",
	"totalprice",
	"depositpaid",
	"bookingdates",
	"additionalneeds"
	})
	
	public class BookingPostParams {

		@JsonProperty("firstname")
		private String firstname;
		@JsonProperty("lastname")
		private String lastname;
		@JsonProperty("totalprice")
		private Integer totalprice;
		@JsonProperty("depositpaid")
		private boolean depositpaid;
		@JsonProperty("bookingdates")
		private Bookingdates bookingdates;
		@JsonProperty("additionalneeds")
		private String additionalneeds;

		public BookingPostParams(String firstname, String lastname, int totalprice, boolean depositpaid, String bookingdates_checkin, String bookingdates_checkout, String additionalneeds ) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.totalprice = totalprice;
			this.depositpaid = depositpaid;
			this.bookingdates = new Bookingdates(bookingdates_checkin, bookingdates_checkout);
			this.additionalneeds = additionalneeds;
		}
		
		@JsonProperty("firstname")
		public String getFirstname() {
		return firstname;
		}
	
		@JsonProperty("firstname")
		public void setFirstname(String firstname) {
		this.firstname = firstname;
		}
	
		@JsonProperty("lastname")
			public String getLastname() {
			return lastname;
		}
	
		@JsonProperty("lastname")
			public void setLastname(String lastname) {
			this.lastname = lastname;
		}
	
		@JsonProperty("totalprice")
			public Integer getTotalprice() {
			return totalprice;
		}
	
		@JsonProperty("totalprice")
			public void setTotalprice(Integer totalprice) {
			this.totalprice = totalprice;
		}
	
		@JsonProperty("depositpaid")
			public boolean getDepositpaid() {
			return depositpaid;
		}
	
		@JsonProperty("depositpaid")
			public void setDepositpaid(boolean depositpaid) {
			this.depositpaid = depositpaid;
		}
	
		@JsonProperty("bookingdates")
			public Bookingdates getBookingdates() {
			return bookingdates;
		}
	
		@JsonProperty("bookingdates")
			public void setBookingdates(Bookingdates bookingdates) {
			this.bookingdates = bookingdates;
		}
	
		@JsonProperty("additionalneeds")
			public String getAdditionalneeds() {
			return additionalneeds;
		}
	
		@JsonProperty("additionalneeds")
			public void setAdditionalneeds(String additionalneeds) {
			this.additionalneeds = additionalneeds;
		}
	
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonPropertyOrder({
		"checkin",
		"checkout"
		})
		
	private static class Bookingdates {

		@JsonProperty("checkin")
		private String checkin;
		@JsonProperty("checkout")
		private String checkout;
		
		public Bookingdates(String checkin, String checkout){
			this.checkin = checkin;
			this.checkout = checkout;
		}
		
	
		@JsonProperty("checkin")
		public String getCheckin() {
		return checkin;
		}
	
		@JsonProperty("checkin")
		public void setCheckin(String checkin) {
		this.checkin = checkin;
		}
	
		@JsonProperty("checkout")
		public String getCheckout() {
		return checkout;
		}
	
		@JsonProperty("checkout")
		public void setCheckout(String checkout) {
		this.checkout = checkout;
		}
	}
}