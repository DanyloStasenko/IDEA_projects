package tasks.polymorphism;

public class Soldier {
	
	protected int healthLevel;
	protected int attack;
	
	public Soldier() {
		
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attackPower) {
		this.attack = attackPower;
	}

	public void shoot(){
		System.out.println("Soldier shooting with power: " + attack);
	}
}
