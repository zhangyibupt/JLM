package lessons.welcome;

public class LoopWhileEntity extends universe.bugglequest.SimpleBuggle {
	@Override
	public void forward(int i)  { 
		throw new RuntimeException("Pas le droit d'utiliser forward(int) dans cet exercice");
	}

	@Override
	public void backward(int i) {
		throw new RuntimeException("Pas le droit d'utiliser backward(int) dans cet exercice");
	}

	@Override
	public void run() { 
		/* BEGIN SOLUTION */
		while (!isFacingWall())
			forward();
		/* END TEMPLATE */
	}
}