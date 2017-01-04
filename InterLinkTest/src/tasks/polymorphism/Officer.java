package tasks.polymorphism;

public class Officer extends Soldier {

	int speed;
	
	public Officer() {
		
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void shoot(){
		System.out.println("Officer instead of shooting is running away with speed: " + speed);
	}
	
}
