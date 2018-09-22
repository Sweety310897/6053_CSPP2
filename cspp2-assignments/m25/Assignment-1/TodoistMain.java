import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class InvalidException extends Exception {
	InvalidException(final String s) {
		super(s);
	}
}
/**
 * Class for task.
 */
class Task{
	private String title;
	private String assignedTo;
	private String status;
	private int timeToComplete;
	private boolean important;
	private boolean urgent;
	public Task() {
		//construcor.
	}
	/**
	 * Constructs the object.
	 *
	 * @param      title           The title
	 * @param      assignedTo      The assigned to
	 * @param      timeToComplete  The time to complete
	 * @param      important       The important
	 * @param      urgent          The urgent
	 * @param      status          The status
	 */
	public Task(String title, String assignedTo,int timeToComplete,
		boolean important, boolean urgent, String status) {
			this.title = title;
			this.assignedTo = assignedTo;
			this.timeToComplete = timeToComplete;
			this.important = important;
			this.urgent = urgent;
			this.status = status;
			if(status != "todo" || status != "done") {
	    		System.out.println( "Invalid status dud");
	    	}
			
		
	}
	public String toString() {
		
		if (this.important == true && this.urgent == true) {
			return this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " +
			"Important" + ", " + "Urgent" + ", " + this.status;
		} else if (this.important == true && this.urgent == false){
			return this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " +
			"Important" + ", " + "Not Urgent" + ", " + this.status;
		} else if (this.important == false && this.urgent == true) {
			return this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " +
			"Not Important" + ", " + "Urgent" + ", " + this.status;	
		} else {
			return this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " +
			"Not Important" + ", " + "Not Urgent" + ", " + this.status;
		}
	}
}
/**
 * Class for todoist main.
 */
public class TodoistMain {
	/**
	 * Constructs the object.
	 */
	public TodoistMain() {
		//constrcutor.
	}
    /**
     * Starts a test.
     */
    public static void startTest() {
        TodoistMain todo = new TodoistMain();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            //System.out.println(Arrays.toString(tokens));
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                // case "add-task":
                //     testAddTask(todo, tokens);
                // break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    // public static void testAddTask(final Todoist todo,
    // final String[] tokens) {
    //     try {
    //         todo.addTask(createTask(tokens));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
    	final int three = 3;
    	final int four = 4;
    	final int five = 5;
    	final int six = 6;
    	String title = tokens[1];
	    String assignedTo = tokens[2];
	    int timeToComplete = Integer.parseInt(tokens[three]);
	    boolean important = tokens[four].equals("y");
	    boolean urgent = tokens[five].equals("y");
	    String status = tokens[six];
        return new Task(
        	title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
