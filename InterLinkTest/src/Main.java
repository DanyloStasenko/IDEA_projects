/*	Принципы ООП:
	
	Инкапсуляция:
		Сокрытие деталей реализации и поведения объекта от его клиентов
		Проекция правил взаимодействия с объектами в реальном мире на проектируемый объект

	Наследование:
		Устранение дублирования спецификации классов
		Отражение типа связи “является” (иерархии)
		Наследование интерфейса

	Полиморфизм:
		Разное поведение объектов поддерживающих общий интерфейс в зависимости от их реальных типов
		Ключевым в использовании полиморфизма является работа клиентского кода с интерфейсом
		не имея информации о реально использованных классах реализующих этот интерфейс
*/

import java.util.ArrayList;

import tasks.encapsulation.example1.Barbell;
import tasks.encapsulation.example2.Person;
import tasks.inheritance.example1.Cat;
import tasks.inheritance.example1.Pegasus;
import tasks.inheritance.example2.Department;
import tasks.inheritance.example2.Professor;
import tasks.inheritance.example2.University;
import tasks.inheritance.example3.King;
import tasks.inheritance.example3.Pawn;
import tasks.inheritance.example3.Queen;
import tasks.inheritance.example3.Rook;
import tasks.polymorphism.Officer;
import tasks.polymorphism.Soldier;

public class Main {

	public static void main(String[] args) {
		
		// Encapsulation:	
		System.out.println("\tEncapsulation:");
		Person person = new Person();
		person.setFirstName("Danylo");
		person.setMiddleName("Wolodymyrowych");
		person.setLastName("Stasenko");
		System.out.println("Example 1: My initials: " + person.getInitials());
		
		Barbell barbell = new Barbell();
		barbell.setWeight(14);
		barbell.setWeight(-3);
		System.out.println("Example 2: Current weight: " + barbell.getWeight());
		System.out.println();
			
		
		// Inheritance:
		System.out.println("\tInheritance:");
		Pegasus pegasus = new Pegasus();
		pegasus.feed();
		pegasus.sleep();
		pegasus.walk();
		pegasus.fly();
		
		Cat cat = new Cat();
		cat.feed();
		cat.sleep();
		cat.walk();
		System.out.println();
		
		// University IS Building (inheritance)
		// University HAS Departments (composition, because Departments cannot exist separately from University)
		// Department HAS Professors (aggregation, because Professors may exist separately from Departments)
		Professor professor = new Professor();
		professor.setName("Roman Ivanowych");
		professor.setAge(55);
		professor.setDegree("Professor of Engineering");
		
		Department department = new Department();
		department.setName("Computer Engineering Department");
		department.addProfessor(professor);
		
		University university = new University();
		university.setName("Lviv Polytechnics");
		university.setFloors(4);
		university.addDepartment(department);
		System.out.println(university);
		System.out.println();
		
		King king = new King();
		king.changePosition(1,1);
		Queen queen = new Queen();
		queen.changePosition(3, 2);
		Rook rook = new Rook();
		rook.changePosition(8, 8);
		Pawn pawn = new Pawn();
		pawn.changePosition(6, 2);
		System.out.println();
		
		
		// Polymorphism:
		System.out.println("\tPolymorphism:");
		Soldier soldier = new Soldier();
		soldier.setAttack(35);
		Soldier soldier2 = new Soldier();
		soldier2.setAttack(65);
		Soldier soldier3 = new Soldier();
		soldier3.setAttack(95);
		Officer officer = new Officer();
		officer.setSpeed(999);
		
		ArrayList<Soldier> army = new ArrayList<>();
		army.add(soldier);
		army.add(soldier2);
		army.add(soldier3);
		army.add(officer);
		
		for(Soldier armyUnit : army ){
			armyUnit.shoot();
		}
	}
}
