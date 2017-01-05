package tasks.inheritance.example2;

public class Professor {
	
	private int age;
	private String name;
	private String degree;
	
	public Professor() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Professor [age=" + age + ", name=" + name + ", degree=" + degree + "]";
	}
	
}
