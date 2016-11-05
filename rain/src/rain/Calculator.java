package rain;

public class Calculator {

	// get max value
	public static int getMaxValue(int[] array) {
		int maxValue = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	// calculate result
	public static int calculateResult(int[] array) {
		boolean countStarted = false;
		int maxValue = getMaxValue(array);
		int tempCount = 0;
		int result = 0;

		// loop for "height"
		for (int i = maxValue; i > 0; i--) {
			countStarted = false;
			tempCount = 0;

			// loop for "width"
			for (int j = 0; j < array.length; j++) {

				if (array[j] >= i && countStarted) {
					result += tempCount;
					tempCount = 0;
					continue;
				}

				else if (countStarted) {
					tempCount++;
				}

				else if (array[j] >= i) {
					countStarted = true;
				}
			}
		}
		return result;
	}
}