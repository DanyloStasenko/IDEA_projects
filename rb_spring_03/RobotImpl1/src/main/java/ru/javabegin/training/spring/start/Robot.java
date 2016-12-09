package ru.javabegin.training.spring.start;

import ru.javabegin.training.spring.objects.SonyHand;
import ru.javabegin.training.spring.objects.SonyHead;
import ru.javabegin.training.spring.objects.SonyLeg;

public class Robot {
	
	private SonyHand hand = new SonyHand();
	private SonyLeg leg = new SonyLeg();
	private SonyHead head = new SonyHead();
	
	public void action(){
		head.calc();
		hand.catchSomething();
		leg.go();
	}

}
