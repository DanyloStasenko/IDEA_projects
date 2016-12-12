package helpers;

public class BinaryFormatter {
	
	public static String getFormattedString(String unformattedString)
	{
		StringBuilder result = new StringBuilder(unformattedString);
		
		if (unformattedString.length() % 4 != 0) {
			
			int tempZeros = 4 - unformattedString.length()%4;
			
			System.out.println("Need " + tempZeros + " values to complete tetrad");
			
			for (int i = 0; i < tempZeros; i++) {
				result.insert(0, " ");
			}
			
			int count = 0;
			for (int i = unformattedString.length(); i >= 0; i--) {
				count++;
				if (count %4 == 0) {
					result.insert(i, " ");
				}
			}
		}
		
		return result.toString();
	}
}