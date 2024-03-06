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

	@ValueSource(strings = {
			"20:10:00:00",
			"20:09:60:00"
	})
		assertTrue("The seconds were not calculated properly", seconds==72600);
	@ValueSource(strings = {
			"01:30:10:00",
			"01:01:10:00"
	})
		assertTrue("The seconds were not calculated properly", seconds==10);
	@ValueSource(strings = {
			"21:34:40:00",
			"56:37:40:00"
	})
		assertTrue("The seconds were not calculated properly", seconds==40);
	@ValueSource(strings = {
			"01:50:60:00",
			"01:50:00:00"
	})
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes==50);
	@ValueSource(strings = {
			"14:34:47:00",
			"56:34:71:00"
	})
		assertTrue("The minutes were not calculated properly", minutes==34);
	@ValueSource(strings = {
			"01:00:60:00",
			"01:01:00:00"
	})
		assertTrue("The seconds were not calculated properly", hours==1);
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalHours("1");});
	@ValueSource(strings = {
			"01:25:24:00",
			"01:14:68:00"
	})
		assertTrue("The hours were not calculated properly", hours==1);
}