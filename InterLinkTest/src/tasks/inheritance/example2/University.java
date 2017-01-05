package tasks.inheritance.example2;

import java.util.ArrayList;

public class University extends Building{
	
	private ArrayList<Department> universityDepartments;
	
	public University() {
		this.universityDepartments = new ArrayList<>();
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
		Department department = new Department(universityDepartment);
		universityDepartments.add(department);
	}

	@Override
	public String toString() {
		return super.toString()+"University [universityDepartments=" + universityDepartments + "]";
	}
	
}
