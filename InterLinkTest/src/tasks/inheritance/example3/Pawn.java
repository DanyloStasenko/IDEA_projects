package tasks.inheritance.example3;

public class Pawn extends ChessFigure {

	public Pawn() {
		this.value = 1;
	}
	
	@Override
	public void changePosition(int xAxis, int yAxis) {
		System.out.print("Pawn");
		super.changePosition(xAxis, yAxis);
	}
}
