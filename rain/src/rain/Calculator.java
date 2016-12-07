package rain;

public class Calculator {

	// get max value (height)
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
	public static int calculateResult(int[] levels) {
		boolean isFilling = false;
		int maxValue = getMaxValue(levels);
		int fillingCount = 0;
		int result = 0;

		// Checking 'rows' from the highest to the lowest / loop for "height" / Y axis
		for (int i = maxValue; i > 0; i--) {
			isFilling = false;
			fillingCount = 0;

			// Checking 'columns' from beginning to the end / loop for "width" / X axis
			for (int j = 0; j < levels.length; j++) {
				
				// water between two 'blocks' must be stored
				if ((levels[j] >= i) && isFilling) {
					result += fillingCount;
					fillingCount = 0;
					continue;
				}

				// if filling is started - increment count
				else if (isFilling) {
					fillingCount++;
				}

				// we will start filling, only if we can see 'block' in current row
				else if (levels[j] >= i) {
					isFilling = true;
				}
			}
		}
		return result;
	}
}