package tasks.inheritance.example2;

public abstract class Building {
	
	String name;
	int floors;

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}
	
	public Building() {
		
	}
	
	void breakDown(){
		name = null;
	}

	@Override
	public String toString() {
		return "Building [name=" + name + ", floors=" + floors + "]";
	}
	
}
