/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

class StackWorklist implements SearchWorklist {

	Stack<Square> stack = new Stack<Square>();

	@Override
	public void add(Square c) {
		stack.push(c);
	}

	@Override
	public Square remove() {
		return stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return stack.empty();
	}
	
}

class QueueWorklist implements SearchWorklist {
	
	Queue<Square> queue = new LinkedList<Square>();

	@Override
	public void add(Square c) {
		queue.add(c);
	}

	@Override
	public Square remove() {
		return queue.remove();
	}

	@Override
	public boolean isEmpty() {
		if (queue.peek() == null) {
			return true;
		} else {
			return false;
		}
	}

}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
