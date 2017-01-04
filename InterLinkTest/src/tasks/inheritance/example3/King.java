package tasks.inheritance.example3;

public class King extends ChessFigure {

	public King() {
		this.value = 10;
	}
	
	@Override
	public void changePosition(int xAxis, int yAxis) {
		System.out.print("King");
		super.changePosition(xAxis, yAxis);
	}
}
