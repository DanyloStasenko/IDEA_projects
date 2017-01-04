package tasks.inheritance.example3;

public class Queen extends ChessFigure{

	public Queen() {
		this.value = 9;
	}
	
	@Override
	public void changePosition(int xAxis, int yAxis) {
		System.out.print("Queen");
		super.changePosition(xAxis, yAxis);
	}
}
