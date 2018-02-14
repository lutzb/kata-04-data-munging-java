package munging;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartOneWeatherData {
	
	public static int getSmallestTempSpreadDay() {
		InputStream inputStream = PartOneWeatherData.class.getResourceAsStream("weather.dat");
		Scanner scanner = new Scanner(inputStream);
		
		// Discard header and empty line (lines 1 and 2)
		String headers = scanner.nextLine();
		String emptyLine = scanner.nextLine();
		
		int day = 0;
		int largestSpread = 0;
		while(scanner.hasNext()) {
			String line1 = scanner.nextLine();
			
			String normalizedLine = line1.replaceAll("\\s+", " ");
			List<String> lineArray = Arrays.asList(normalizedLine.split(" "));
			
			String currentDay = lineArray.get(1);
			
			if (!currentDay.equals("mo")) {				
				int currentMax = sanitizeInput(lineArray.get(2));
				int currentMin = sanitizeInput(lineArray.get(3));
				int currentSpread = currentMax - currentMin;
				
				if (currentSpread > largestSpread) {
					largestSpread = currentSpread;
					day = Integer.parseInt(currentDay);
				}
			}
		}
		
		scanner.close();
		
		return day;
	}

	private static int sanitizeInput(String input) {
		String result = "";
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				result += c;
			}
		}
		return Integer.parseInt(result);
	}
}
