package munging;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartTwoFootballData {

	public static String getSmallestGoalDifference() {
		InputStream input = PartTwoFootballData.class.getResourceAsStream("football.dat");
		Scanner scanner = new Scanner(input);
		
		// Discard header line
		String headers = scanner.nextLine();
		
		String team = "";
		int smallestGoalDifference = Integer.MAX_VALUE;
		while (scanner.hasNext()) {
			String currentLine = scanner.nextLine();
			String normalizedLine = currentLine.replaceAll("\\s+", " ");
			List<String> lineArray = Arrays.asList(normalizedLine.split(" "));
			
			if (lineArray.size() > 2) {				
				int currentGoalsFor = Integer.parseInt(lineArray.get(7));
				int currentGoalsAgainst = Integer.parseInt(lineArray.get(9));
				int currentGoalDifference = Math.abs(currentGoalsFor - currentGoalsAgainst);
				
				if (currentGoalDifference < smallestGoalDifference) {
					smallestGoalDifference = currentGoalDifference;
					team = lineArray.get(2);
				}
			}
		}
		
		scanner.close();
		
		return team;
	}
}
