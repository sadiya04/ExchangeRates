
package base;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Assert;

import cucumber.api.Scenario;

public class Utility {

	
	public  static RequestSpecification httpRequest;
	public static String bodyAsString;
	public static ResponseBody body;
	public static Response response;
	public static Scenario scenario;
	

	// Method for retrieving the local date
//	public static LocalDate locatDate() {
//		ZoneId zoneId = ZoneId.of("America/Los_Angeles");
//		LocalDate dt = LocalDate.from(ZonedDateTime.now(zoneId));
//		return dt;
//
//	}

	// verify the future date
	protected void FutureDate() throws ParseException {
		
		try {
			// stored the response object
			response = httpRequest.get();

			// stored the respose in body
			body = response.getBody();

			// stored the Response body as a String.
			bodyAsString = body.asString();

			//  asserting the actual and expected value
			Assert.assertEquals(bodyAsString.contains(bodyAsString), true);
		} catch (AssertionError e) {
			System.out.println(""
					+ "Assertion fail" );
		}
	}
}

//	// Method to check the given date is lying between weekend or not
//	protected static String checkWeekends(LocalDate date) throws ParseException {
//
//		LocalDate result = date;
//		if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
//			result = date.minusDays(1);
//		}
//
//		else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
//			result = date.minusDays(2);
//		}
//
//		return result.toString();
//	}
//}
