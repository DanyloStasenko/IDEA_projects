package tasks.inheritance.example1;

public class Cat implements IPet{

	@Override
	public void feed() {
		System.out.println("Cat eating");
	}

	@Override
	public void sleep() {
		System.out.println("Cat sleeping");
	}

	@Override
	public void walk() {
		System.out.println("Cat walking");
	}
	
}
