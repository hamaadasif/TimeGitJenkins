package time;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	@ParameterizedTest
	@ValueSource(strings = {
			"01:30:25:10",
			"01:01:42:10"
	})
	void testGetMillisecondsGood(String candidate) {
		int milliseconds = Time.getMilliseconds(candidate);
		assertTrue("The seconds were not calculated properly", milliseconds==10);
	}

	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliseconds("10:00:00");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"21:34:45:40",
			"56:37:15:40"
	})
	void testGetMillisecondsBoundary(String candidate) {
		int milliseconds = Time.getMilliseconds(candidate);
		assertTrue("The seconds were not calculated properly", milliseconds==40);
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = {
			"01:00:60:00",
			"01:01:00:00"
	})
	void testGetTotalSecondsGood(String candidate) {
		double seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==3660);
	}
	@Test	void testGetTotalSecondBad() {		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});	}		@ParameterizedTest
	@ValueSource(strings = {
			"20:10:00:00",
			"20:09:60:00"
	})	void testGetTotalSecondsBoundary(String candidate) {		double seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==72600);	} 	@ParameterizedTest
	@ValueSource(strings = {
			"01:30:10:00",
			"01:01:10:00"
	})	void testGetSecondsGood(String candidate) {		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==10);	}	@Test	void testGetSecondsBad() {		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getSeconds("10:00");});	}		@ParameterizedTest
	@ValueSource(strings = {
			"21:34:40:00",
			"56:37:40:00"
	})	void testGetSecondsBoundary(String candidate) {		int seconds = Time.getSeconds(candidate);
		assertTrue("The seconds were not calculated properly", seconds==40);	}		@ParameterizedTest
	@ValueSource(strings = {
			"01:50:60:00",
			"01:50:00:00"
	})	void testGetTotalMinutesGood(String candidate) {		
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes==50);	}		@Test	void testGetTotalMinutesBad() {		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("10:");});	}		@ParameterizedTest
	@ValueSource(strings = {
			"14:34:47:00",
			"56:34:71:00"
	})	void testGetTotalMinutesBoundary(String candidate) {		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes==34);	}	@ParameterizedTest
	@ValueSource(strings = {
			"01:00:60:00",
			"01:01:00:00"
	})	void testGetTotalHoursGood(String candidate) {		int hours = Time.getTotalHours(candidate);
		assertTrue("The seconds were not calculated properly", hours==1);	}	@Test	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalHours("1");});	}		@ParameterizedTest
	@ValueSource(strings = {
			"01:25:24:00",
			"01:14:68:00"
	})	void testGetTotalHoursBoundary(String candidate) {		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours==1);	}
}
