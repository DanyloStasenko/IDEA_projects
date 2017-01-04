package tasks.inheritance.example1;

public class Pegasus implements IPet, IFlyable {

	@Override
	public void fly() {
		System.out.println("Pegasus flying");
	}

	@Override
	public void feed() {
		System.out.println("Pegasus eating");
	}

	@Override
	public void sleep() {
		System.out.println("Pegasus sleeping");
	}

	@Override
	public void walk() {
		System.out.println("Pegasus walking");
	}
	
}
