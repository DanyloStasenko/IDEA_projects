package tasks.inheritance.example3;

public class Rook extends ChessFigure {

	public Rook() {
		this.value = 5;
	}
	
	@Override
	public void changePosition(int xAxis, int yAxis) {
		System.out.print("Rook");
		super.changePosition(xAxis, yAxis);
	}
	
}
