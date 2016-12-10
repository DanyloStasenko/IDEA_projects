/* 1) Comments:
 * class
 * version
 * author
 * etc.
 */

// packages
package conventions;

// imports
import javax.swing.*;

//before class - documentation comments, which are starting with /**

/**
 * @author Admin
 *
 *	Alt + Shift + J = generate javadoc comment
 */
public class Main {
	// 	comments (class aim)
		
	// static fields
		
	// instance
		
	// constant values:
	public static final String NAME_CONST = "value";
	
	// constructors
	
	// methods
	
	/** Javadoc commentary
	 * 
	 * @param args
	 */
 public static void main(String[] args) {
		
	}
}

// About '//' comments - must be tabulated
// int a = 5; 		// end line comment
// int a = 5; 		// end line comment
// standtard = 8 spaces
/*

	// TODO: smth
	// HACK: what is wrong
	// XXX: little bugs
	// FIXME: problem must be fixed
	// REVIEW: review this part of code and refactor it
	  	
	  	
	  	standard: 8 spaces
	  	code: 80 characters
	  	comment: 70 characters
	  	strings: < 2 000
	  	
	  	max: 2 loops
	  	or refactor
	  	
	  	int a; 	// + comment
	  	int b;
	  	
	  	int a, b, c; = BETTER
	 
	 	if too long name = brake string
	 	1) 8 spaces
	 	2) where parameters started
	 
	 	int a = (4 + 5 + 9) + 6 + 7
	 			- (7 + 8) + 2 + 3
	 			
	 			BREAK before operator
	 			dont break braces!
	 			
	 			double d = xxx ? ttt
	 						   : fff
	 
	 
	 --------------------------- CLASSES ---------------------------
	 
		1) fields
			1.1) static
		
		2) constructors
		
		3) methods
	 
	 	ORDER BY ACESS LEVEL
	 1) public static static final
	 2) protected 
	 3) private
	 
	 private A a;
	 
	 public Class(){
	 }
	 
	 methods ordered by functionality
	 
	 --------------------------- CONDITIONS ---------------------------
	 
	 one condition per 1 string
	 
	 if(true){
	         System.out.println("ggg")
	 }else if(false){
			Sout(xxx)
	 }
	 
	 for(int i = 0, j = 10, k = 10; i < 10; i ++){
	 
	 }
	 
	 return aa ? bb : cc
	 
	 
	 
	 switch()
	 case 1:
	 default: must be
	 
	 try {
	 		smth
	 } catch (Exception e) {
	 
	 }
	 
	 
	 before class / interface - 2 empty strings
	 
	 spaces \/ here  and  here \/
	 for (int i = 0; i < 10; i++) {
	 
	 }
	 
	 spaces before/after braces!
	 spaces before/after operators
	 
	 concat - space
	 
	 while (i < 10) {
	 
	 }
	 
	 increment/decrement - 1 space
	 
	 double res = (double) a;
	 double res = (double) (a / b);
	 
	 --------------------------- NAMING ---------------------------
	 class = ClassGoodNamed
	 XmlDatasourceConnection
	 
	 variables:
	 	start with lower case:
		 	width
		 	height
		 	mainFrame
		 	widthFrame
		 	
	 	loops:
	 		i, j, k, m, n
	 		
	 		char: c d e
	 		
	 		public class Clazz{
	 		static int p;
	 		
	 		Clazz.p
	 	
	 
	 
 */