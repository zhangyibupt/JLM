package lessons.welcome.loop.dowhileloop;

import java.awt.Color;

import jlm.core.model.lesson.ExerciseTemplated;
import jlm.core.model.lesson.Lesson;
import jlm.universe.Direction;
import jlm.universe.bugglequest.Buggle;
import jlm.universe.bugglequest.BuggleWorld;

public class LoopDoWhile extends ExerciseTemplated {

	public LoopDoWhile(Lesson lesson) {
		super(lesson);
		tabName = "Program";
				
		BuggleWorld myWorld = new BuggleWorld("Yellow Submarine",13,7);
		for (int i=0;i<7;i++) {
			new Buggle(myWorld, "Beatles"+(i+1), i, 6, Direction.NORTH, Color.black, Color.lightGray);
		    for (int j=6; j>i; j--)
		    	myWorld.setColor(i, j,Color.yellow);
		}
		for (int i=7;i<13;i++) {
			new Buggle(myWorld, "Beatles"+(i+1), i, 6, Direction.NORTH, Color.black, Color.lightGray);
		    for (int j=0; j<i-6; j++)
		    	myWorld.setColor(i, 6-j,Color.yellow);
		}

    	setup(myWorld);
	}
}
