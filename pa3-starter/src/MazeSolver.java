/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		Square current = maze.start;
		wl.add(maze.start);
		maze.start.visit();
		while (!wl.isEmpty()) {
			current = wl.remove();
			if (current.getRow() == maze.finish.getRow()
			&&  current.getCol() == maze.finish.getCol()) {
				return current;
			} else {
				int curRow = current.getRow();
				int curCol = current.getCol();
				Square North = null;
				Square South = null;
				Square East = null;
				Square West = null;
				if (curRow > 0) {
					North = maze.contents[curRow - 1][curCol];
				}
				if (curRow < (maze.rows - 1)) {
					South = maze.contents[curRow + 1][curCol];
				}
				if (curCol < (maze.cols - 1)) {
					East = maze.contents[curRow][curCol + 1];
				}
				if (curCol > 0) {
					West = maze.contents[curRow][curCol - 1];
				}
				if (North != null) {
					if (!North.isVisited() && !North.getIsWall()) {
						North.visit();
						North.setPrevious(current);
						wl.add(North);
					}
				}
				if (South != null) {
					if (!South.isVisited() && !South.getIsWall()) {
						South.visit();
						South.setPrevious(current);
						wl.add(South);
					}
				}
				if (East != null) {
					if (!East.isVisited() && !East.getIsWall()) {
						East.visit();
						East.setPrevious(current);
						wl.add(East);
					}
				}
				if (West != null) {
					if (!West.isVisited() && !West.getIsWall()) {
						West.visit();
						West.setPrevious(current);
						wl.add(West);
					}
				}	
			}
		}
		return null;
	}

	/* Add any helper methods you want */
}
