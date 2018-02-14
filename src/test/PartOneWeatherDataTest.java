package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import munging.PartOneWeatherData;

class PartOneWeatherDataTest {

	@Test
	void test() {
		int day = PartOneWeatherData.getSmallestTempSpreadDay();
		assertEquals(day, 9);
	}

}
