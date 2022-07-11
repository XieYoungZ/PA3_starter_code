import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	@Test
	public void simpleTestQueue() {
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		SearchWorklist wl = new QueueWorklist();
		String[] answer = new String[] {
            "#___",
            "**F_",
            "S##_",
            "____"
        };
		checkMaze(wl, m, answer);
	}

	@Test
	public void hardTestQueue() {
		Maze m = new Maze(new String[] {
            "#____F",
            "#___##",
            "S##___",
            "__###_",
			"______"
        });
		SearchWorklist wl = new QueueWorklist();
		String[] answer = new String[] {
            "#__**F",
            "#__*##",
            "S##***",
            "*_###*",
			"******"
        };
		checkMaze(wl, m, answer);
	}

	@Test
	public void simpleTestQueueNoPath() {
		Maze m = new Maze(new String[] {
            "#___",
            "_#F_",
            "S##_",
            "___#"
        });
		SearchWorklist wl = new QueueWorklist();
		String[] answer = new String[] {
            "#___",
            "_#F_",
            "S##_",
            "___#"
        };
		checkMaze(wl, m, answer);
	}

	@Test
	public void simpleTestStack() {
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		SearchWorklist wl = new StackWorklist();
		String[] answer = new String[] {
            "#___",
            "__F*",
            "S##*",
            "****"
        };
		checkMaze(wl, m, answer);

	}
	
}



