package ru.javabegin.training.spring.impls.toshiba;

import ru.javabegin.training.spring.interfaces.Hand;

public class ToshibaHand implements Hand{
	
	public void catchSomething(){
		System.out.println("Catched from Toshiba!");
	}

}
