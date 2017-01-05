/*	Encapsulation: 
 * 	Example 1:
 * 	When user attempts to change the weight using 'setWeight' method 
 *  - program will check whether the following value is valid (positive).
 */
package tasks.encapsulation.example1;

public class Barbell {
	
	private double weight;
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}
}
