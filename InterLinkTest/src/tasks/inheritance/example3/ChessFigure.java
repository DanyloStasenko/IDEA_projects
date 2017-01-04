package tasks.inheritance.example3;

public abstract class ChessFigure {
	
	protected int value;
	protected int currentXPosition;
	protected int currentYPosition;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCurrentXPosition() {
		return currentXPosition;
	}

	public void setCurrentXPosition(int currentXPosition) {
		this.currentXPosition = currentXPosition;
	}

	public int getCurrentYPosition() {
		return currentYPosition;
	}

	public void setCurrentYPosition(int currentYPosition) {
		this.currentYPosition = currentYPosition;
	}

	void changePosition(int xAxis, int yAxis){
		System.out.println(" changing position to: " + xAxis + yAxis);
	}
}
