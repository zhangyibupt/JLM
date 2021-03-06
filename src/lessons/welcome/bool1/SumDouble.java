package lessons.welcome.bool1;

import jlm.core.model.Game;
import jlm.core.model.lesson.Lesson;
import jlm.universe.bat.BatExercise;
import jlm.universe.bat.BatTest;
import jlm.universe.bat.BatWorld;

public class SumDouble extends BatExercise {

	public SumDouble(Lesson lesson) {
		super(lesson);

		BatWorld myWorld = new BatWorld("sumDouble");
		myWorld.addTest(VISIBLE,  1,2);
		myWorld.addTest(VISIBLE,  3,2);
		myWorld.addTest(VISIBLE,  2,2);

		myWorld.addTest(INVISIBLE, -1,0);
		myWorld.addTest(INVISIBLE, 0,0);
		myWorld.addTest(INVISIBLE, 0,1);

		langTemplate(Game.PYTHON, "sumDouble", 
				"def sumDouble(a, b):\n",
				"  if a==b:\n"+
				"    return (a+b)*2\n"+
				"  return a+b\n");
		setup(myWorld);
	}


	/* BEGIN SKEL */
	public void run(BatTest t) {
		t.setResult( sumDouble((Integer)t.getParameter(0),(Integer)t.getParameter(1)) );		
	}
	/* END SKEL */

	/* BEGIN TEMPLATE */
	int sumDouble(int a, int b) {
		/* BEGIN SOLUTION */
		if (a==b)
			return (a+b)*2;
		return a+b;
		/* END SOLUTION */
	}
	/* END TEMPLATE */
}
