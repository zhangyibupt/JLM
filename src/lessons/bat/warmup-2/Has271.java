package lessons.bat.bool;
import jlm.lesson.Lesson;
import jlm.universe.World;
import universe.bat.BatExercise;
import universe.bat.BatWorld;

public class Has271 extends BatExercise {
  public Has271(Lesson lesson) {
    super(lesson);
    
    World[] myWorlds = new BatWorld[13];
    myWorlds[0] = new BatWorld(VISIBLE, {1, 2, 7, 1}) ;
    myWorlds[1] = new BatWorld(VISIBLE, {1, 2, 8, 1}) ;
    myWorlds[2] = new BatWorld(VISIBLE, {2, 7, 1}) ;
    myWorlds[3] = new BatWorld(INVISIBLE, {3, 8, 2}) ;
    myWorlds[4] = new BatWorld(INVISIBLE, {2, 7, 3}) ;
    myWorlds[5] = new BatWorld(INVISIBLE, {2, 7, 4}) ;
    myWorlds[6] = new BatWorld(INVISIBLE, {2, 7, -1}) ;
    myWorlds[7] = new BatWorld(INVISIBLE, {2, 7, -2}) ;
    myWorlds[8] = new BatWorld(INVISIBLE, {4, 5, 3, 8, 0}) ;
    myWorlds[9] = new BatWorld(INVISIBLE, {2, 7, 5, 10, 4}) ;
    myWorlds[10] = new BatWorld(INVISIBLE, {2, 7, -2, 4, 9, 3}) ;
    myWorlds[11] = new BatWorld(INVISIBLE, {2, 7, 5, 10, 1}) ;
    myWorlds[12] = new BatWorld(INVISIBLE, {2, 7, -2, 4, 10, 2}) ;

    setup(myWorlds,"has271");
  }

  /* BEGIN SKEL */
  public void run(World w) {
    BatWorld bw = (BatWorld) w;
    bw.result = has271((Integer[])w.getParameter(0));
  }
  /* END SKEL */

  /* BEGIN TEMPLATE */
boolean has271(int[] nums) {
  /* BEGIN SOLUTION */
  // Iterate < length-2, so can use i+1 and i+2 in the loop.
  // Return true immediately when seeing 271.
  for (int i=0; i < (nums.length-2); i++) {
    int val = nums[i];
    if (nums[i+1] == (val + 5) &&
      Math.abs(nums[i+2] - (val-1)) <= 2)  return true;
  }
  
  // If we get here ... none found.
  return false;
  /* END SOLUTION */
}
  /* END TEMPLATE */
}