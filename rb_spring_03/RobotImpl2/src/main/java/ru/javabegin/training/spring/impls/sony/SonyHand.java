package ru.javabegin.training.spring.impls.sony;

import ru.javabegin.training.spring.interfaces.Hand;

public class SonyHand implements Hand{
	
	public void catchSomething(){
		System.out.println("Catched from Sony!!");
	}

}
