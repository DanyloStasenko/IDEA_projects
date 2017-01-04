package tasks.encapsulation.example2;

public class Person {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String initials;
	
	public Person() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInitials() {
		createInitials();
		return initials;
	}
	
	private void createInitials(){
		initials = String.format("%c.%c.%c.", getFirstName().charAt(0), 
				getMiddleName().charAt(0), getLastName().charAt(0));
	}
	
}
