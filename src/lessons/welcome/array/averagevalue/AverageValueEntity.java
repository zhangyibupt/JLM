package lessons.welcome.array.averagevalue;

import jlm.universe.array.ArrayEntity;

public class AverageValueEntity extends ArrayEntity {

	@Override
	public void run() {
		setResult( average(getValues()) );
	}

	/* BEGIN TEMPLATE */
	// computes the average value of the values contained in tab variable
	public int average(int[] tab) {
		/* BEGIN SOLUTION */
		int sum = 0;
		for (int i=0; i<tab.length; i++) {
			sum += tab[i];
		}
		return sum / tab.length;
		/* END SOLUTION */
	}

	/* END TEMPLATE */

}
