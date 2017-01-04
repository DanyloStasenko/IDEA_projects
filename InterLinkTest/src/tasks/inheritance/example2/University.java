package tasks.inheritance.example2;

import java.util.ArrayList;

public class University extends Building{
	
	private ArrayList<Department> universityDepartments;
	
	public University() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Department> getUniversityDepartments() {
		return universityDepartments;
	}

	public void addDepartment(Department universityDepartment) {
		universityDepartments.add(universityDepartment);
	}
}
