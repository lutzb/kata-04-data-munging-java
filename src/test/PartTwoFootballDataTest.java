package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import munging.PartTwoFootballData;

class PartTwoFootballDataTest {

	@Test
	void test() {
		String team = PartTwoFootballData.getSmallestGoalDifference();
		assertEquals(team, "Aston_Villa");
	}

}
