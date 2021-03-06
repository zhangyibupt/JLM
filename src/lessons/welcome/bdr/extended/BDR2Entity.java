package lessons.welcome.bdr.extended;

import java.util.Stack;

import jlm.universe.bugglequest.SimpleBuggle;

public class BDR2Entity extends SimpleBuggle {
	public char getIndication() { 
		if (isOverMessage()) { 
			return readMessage().charAt(0); 
		} else { 
			return ' '; 
		} 
	}

	/* This is not really part of the solution to this exercise, but more an exercise checker 
	 * (because we want all buggle to follow the same relative trajectory).
	 * It is intended to help the process of board creation. */
	boolean checking = false;
	Stack<Character> todoList = new Stack<Character>();
	public void addTODO(String s) {
		checking = true;
		for (int i=s.length()-1; i>=0; i--) {
			todoList.push(s.charAt(i));
		}
	}

	boolean complained = false;
	private void complain(String msg) {
		if (!complained)
			System.out.println("XXX "+msg);
		complained = true;
	}
	private String fmt(char c) {
		String func="";
		switch (c) {
		case 'R': func="right"; break;
		case 'L': func="left";  break;
		case 'I': func="back";  break;

		case 'A': func="plus1";  break;
		case 'B': func="plus2";  break;
		case 'C': func="plus3";  break;
		case 'D': func="plus4";  break;
		case 'E': func="plus5";  break;
		case 'F': func="plus6";  break;

		case 'Z': func="minus1";  break;
		case 'Y': func="minus2";  break;
		case 'X': func="minus3";  break;
		case 'W': func="minus4";  break;
		case 'V': func="minus5";  break;
		case 'U': func="minus6";  break;
		default: throw new RuntimeException("Unknown code: '"+c+"'");
		}
		return func+"("+getX()+","+getY()+")";
	}


	/* BEGIN TEMPLATE */
	boolean moreMusic = true;

	public void danceOneStep() {
		/* BEGIN SOLUTION */
		char read = getIndication();
		if (checking) {
			char todo = ' ';
			if (todoList.size() == 0) { 
				if (read != ' ')
					complain(name+" reads "+fmt(read)+", but it's supposed to be done.");
			} else
				todo = todoList.pop();

			if (todo != read) {
				complain(name+" reads "+fmt(read)+", but it was supposed to do "+fmt(todo)+". Invalid TODO.");			
			}
		}

		switch (read) {
		case 'R': turnRight(); forward(); break;
		case 'L': turnLeft();  forward(); break;
		case 'I': turnBack();  forward(); break;

		case 'A': forward(1); break;
		case 'B': forward(2); break;
		case 'C': forward(3); break;
		case 'D': forward(4); break;
		case 'E': forward(5); break;
		case 'F': forward(6); break;

		case 'Z': backward(1); break;
		case 'Y': backward(2); break;
		case 'X': backward(3); break;
		case 'W': backward(4); break;
		case 'V': backward(5); break;
		case 'U': backward(6); break;

		default: moreMusic = false;
		}
		/* END SOLUTION */
	}

	public void run() { 
		/* BEGIN HIDDEN */
		addTODO((String) world.getParameter(0));			
		/* END HIDDEN */
		
		while (moreMusic)
			danceOneStep();
		/* BEGIN HIDDEN */
		if (checking && todoList.size() != 0) 
			complain(name+"I'm done, but I was supposed to do "+fmt(todoList.pop())+";");
		/* END HIDDEN */
	}
	/* END TEMPLATE */
}
