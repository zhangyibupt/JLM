package lessons.bat.string1;
import jlm.core.model.Game;
import jlm.core.model.lesson.Lesson;
import jlm.universe.bat.BatExercise;
import jlm.universe.bat.BatTest;
import jlm.universe.bat.BatWorld;

public class StringYak extends BatExercise {
	public StringYak(Lesson lesson) {
		super(lesson);

		BatWorld myWorld = new BatWorld("stringYak");
		myWorld.addTest(VISIBLE, "yakpak") ;
		myWorld.addTest(VISIBLE, "pakyak") ;
		myWorld.addTest(VISIBLE, "yak123ya") ;
		myWorld.addTest(INVISIBLE, "yak") ;
		myWorld.addTest(INVISIBLE, "yakxxxyak") ;
		myWorld.addTest(INVISIBLE, "HiyakHi") ;
		myWorld.addTest(INVISIBLE, "xxxyakyyyakzzz") ;

		langTemplate(Game.PYTHON, "stringYak", 
				"def stringYak(str):\n",
				"  res = ''\n" +
				"  i=0\n" +
				"  while i<len(str):\n"+
				"    if i+2<len(str)  and str[i] == 'y' and str[i+2]=='k':\n" +
				"      i += 2\n" +
				"    else:\n" +
				"      res += str[i]\n" +
				"    i+=1\n"+
				"  return res\n");
		setup(myWorld);
	}

	/* BEGIN SKEL */
	public void run(BatTest t) {
		t.setResult( stringYak((String)t.getParameter(0)) );
	}
	/* END SKEL */

	/* BEGIN TEMPLATE */
	String stringYak(String str) {
		/* BEGIN SOLUTION */
		String result = "";

		for (int i=0; i<str.length(); i++) {
			// Look for i starting a "yak" -- advance i in that case
			if (i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+2)=='k') {
				i =  i + 2;
			} else { // Otherwise do the normal append
				result = result + str.charAt(i);
			}
		}

		return result;
		/* END SOLUTION */
	}
	/* END TEMPLATE */
}
