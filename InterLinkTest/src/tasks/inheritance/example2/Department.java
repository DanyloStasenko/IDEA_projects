package tasks.inheritance.example2;

import java.util.ArrayList;

public class Department {
	
	String name;
	ArrayList<Professor> professors = new ArrayList<>();
	
	public Department() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addProfessor(Professor professor){
		professors.add(professor);
	}
	
	public void deleteProfessor(Professor professor){
		professors.remove(professor);
	}
	
	public ArrayList<Professor> getProfessors(){
		return professors;
	}
}
