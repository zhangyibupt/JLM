package lessons.welcome.loop.whileloop;

import java.io.IOException;

import jlm.core.model.lesson.ExerciseTemplated;
import jlm.core.model.lesson.Lesson;
import jlm.universe.BrokenWorldFileException;
import jlm.universe.World;
import jlm.universe.bugglequest.BuggleWorld;

public class WhileMoria extends ExerciseTemplated {

	public WhileMoria(Lesson lesson) throws IOException, BrokenWorldFileException {
		super(lesson);
		tabName = "Balin";
		
		/* Create initial situation */
		World[] myWorlds = new World[] {
				BuggleWorld.newFromFile("lessons/welcome/loop/forloop/moria"),
		};
		for (World w: myWorlds)
			w.setDelay(50); // moving a bit faster than usual
		
		setup(myWorlds);
	}
}
