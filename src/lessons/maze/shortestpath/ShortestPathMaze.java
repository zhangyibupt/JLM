package lessons.maze.shortestpath;

import java.io.IOException;

import jlm.core.model.lesson.ExecutionProgress;
import jlm.core.model.lesson.ExerciseTemplated;
import jlm.core.model.lesson.Lesson;
import jlm.universe.BrokenWorldFileException;
import jlm.universe.Direction;
import jlm.universe.Entity;
import jlm.universe.World;
import jlm.universe.bugglequest.AbstractBuggle;
import jlm.universe.bugglequest.BuggleWorld;
import jlm.universe.bugglequest.exception.AlreadyHaveBaggleException;
import jlm.universe.bugglequest.exception.NoBaggleUnderBuggleException;

public class ShortestPathMaze extends ExerciseTemplated {

	public ShortestPathMaze(Lesson lesson) throws IOException, BrokenWorldFileException {
		super(lesson);
		tabName = "JediEscaper";
				
		setup(new World[] {
				BuggleWorld.newFromFile("lessons/maze/shortestpath/WallFollowerMaze"),
				BuggleWorld.newFromFile("lessons/maze/shortestpath/PledgeMaze")
		});
		//newSourceAliased("lessons.maze.Main","lessons.maze.WallFollowerMaze","Escaper");
	}

	// to shorten loading time	
	@Override
	protected void computeAnswer(){
		AbstractBuggle b = (AbstractBuggle)answerWorld.get(0).getEntities().get(0);
		b.setPosFromLesson(11, 5);
		b.setDirection(Direction.EAST);

		AbstractBuggle b2 = (AbstractBuggle)answerWorld.get(1).getEntities().get(0);
		b2.setPosFromLesson(19, 19);
		b2.setDirection(Direction.EAST);
		
		try {
			b.pickUpBaggle();
			b2.pickUpBaggle();
		} catch (NoBaggleUnderBuggleException e) {
			e.printStackTrace();
		} catch (AlreadyHaveBaggleException e) {
			e.printStackTrace();
		}		
	}
	
	
	@Override
	public void check() {
		lastResult = new ExecutionProgress();
		for (World w: this.getWorlds(WorldKind.CURRENT)) 
			for (Entity e:w.getEntities()) {
				lastResult.totalTests++;
				if (!((AbstractBuggle) e).isCarryingBaggle())
					lastResult.details += "Buggle "+e.getName()+" didn't find the baggle";
				else
					lastResult.passedTests++;
			}
	}

}
