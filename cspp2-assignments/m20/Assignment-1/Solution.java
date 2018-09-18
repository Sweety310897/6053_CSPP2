import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
    	questiontext = question1;
    	choices = choices1;
    	correctAnswer = correctAnswer1;
    	maxMarks = maxMarks1;
    	penalty = penalty1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
    	if (choices[correctAnswer - 1].equals(choice)) {
    		return true;
    	}
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return Integer.toString(correctAnswer);
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
    	response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String showReport() {
        String s = "";
        s = s + getQuestionText();
        boolean eval = evaluateResponse(response);
        if (eval == true) {
        	s = s + "\n" + " Correct Answer! - Marks Awarded: " + getMaxMarks();
        } else {
        	s = s + "\n" + " Wrong Answer! - Penalty: " + getPenalty();
        }
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    private int flag = 0;
    private int flaglength = 0;
    /**
     * Sets the flag.
     *
     * @param      val   The value
     */
    public void setFlag(final int val) {
    	flag = val;
    }
    /**
     * Gets the flag.
     *
     * @return     The flag.
     */
    public int getFlag() {
    	return flag;
    }
    /**
     * flag length.
     *
     * @param      val   The value
     */
    public void flaglength(final int val) {
    	flaglength = val;
    }
    /**
     * flaglength.
     *
     * @return     returns flaglength.
     */
    public int flaglength() {
    	return flaglength;
    }
    /**
     * Constructs the object.
     */
    Quiz() {
    	questions = new Question[100];
    	size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public int getQuizSize() {
    	return size;
    }
    /**
     * Gets the questions.
     *
     * @return     The questions.
     */
    public Question[] getQuestions() {
    	return questions;
    }
    /**
     * Adds a question.
     *
     * @param      q     The quarter
     */
    public void addQuestion(final Question q) {
    	//System.out.println(Question + "ques");
    	questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    // public String showReport() {
    //     String s = "";
    //     return s;
    // }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        for (int temp = 0; temp < q; temp++) {
        	String input = scan.nextLine();
        	String[] tokens = input.split(":");
        	final int five = 5;
        	if (tokens.length != five) {
                System.out.println("Error! Malformed question");
                return;
            } else {
                for (String r : tokens) {
                    // System.out.println(r);
                    if (r.equals("")) {
                        System.out.println("Error! Malformed question");
                        return;
                    }
                }
            }
        	String text = tokens[0];
        	//System.out.println(tokens[0] + "tokens0");
        	//System.out.println(tokens[1] + "tokens1");
        	//System.out.println(text);
            String[] choices = tokens[1].split(",");
            //System.out.println(Arrays.toString(choices));
            final int four = 4;
            final int two = 2;
            if (choices.length > four) {
            	quiz.flaglength(1);
            	System.out.print("trick question  does not have ");
                System.out.println("enough answer choices");
                return;
            }
            if (choices.length < two) {
                System.out.print(text + " does not ");
                System.out.println("have enough answer choices");
                return;
            }
            int answer = Integer.parseInt(tokens[two]);
            final int four1 = 4;
            if (answer < 0 || answer > four1) {
                quiz.setFlag(1);
                System.out.print("Error! Correct answer choice ");
                System.out.println("number is out of range for " + text);
                return;
            }
            
            final int three = 3;
            int maxmarks = Integer.parseInt(tokens[three]);
            if (maxmarks < 0) {
                System.out.println("Invalid max marks for " + text);
                return;
            }
            final int four2 = 4;
            int penalty = Integer.parseInt(tokens[four2]);
            if (penalty > 0) {
                System.out.println("Invalid penalty for " + text);
                return;
            }
            Question q1 = new Question(text, choices, answer, maxmarks, penalty);
            quiz.addQuestion(q1);
        }
        if (quiz.getQuizSize() == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            System.out.println(q + " are added to the quiz");
        }
    }
    /**
     * Starts a quiz.
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        if (quiz.getQuizSize()==0) {
        	return;
        }
        if (quiz.getFlag() == 1) {
        	return;
        }
        Question[] ques = quiz.getQuestions();
            for (int j = 0; j < quiz.getQuizSize(); j++) {
                Question q1 = ques[j];
                System.out.println(q1.getQuestionText()
                    + "(" + q1.getMaxMarks() + ")");
                String[] chose = q1.getChoice();
                for (int i = 0; i < chose.length; i++) {
                    if (i == chose.length - 1) {
                        System.out.print(chose[i]);
                    } else {
                        System.out.print(chose[i] + "\t");
                    }
                }
                System.out.println("\n");
                String response = scan.nextLine();
                q1.setResponse(response);
            }
        // Scanner sc1 = scan;
        // Question[] ques = quiz.getQuestions();
        // for (int j = 0; j < quiz.getQuizSize(); j++) {
        // 	Question q1 = ques[j];
        // 	System.out.println(q1.getQuestionText() + 
        // 		"(" + q1.getMaxMarks() + ")");
        // 	String[] choose = q1.getChoice();
        // 	for (int i = 0; i < choose.length; i++) {
        // 		if (i == choose.length - 1) {
        // 			System.out.println(choose[i]);
        // 		} else {
        // 			System.out.println(choose[i] + "\t");
        // 		}
        // 	}
        // 	System.out.println("\n");
        // 	String response = scan.nextLine();
        // 	q1.setResponse(response);
        // }

    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
    	if (quiz.getQuizSize() == 0) {
    		return;
    	}
    	if (quiz.getFlag() == 1) {
    		return;
    	}
    	int total = 0;
        Question[] quest = quiz.getQuestions();
        for (int i = 0; i < quiz.getQuizSize(); i++) {
            Question q = quest[i];
            String ret = q.showReport();
            System.out.println(ret);
            if (ret.contains("Marks")) {
                total = total + q.getMaxMarks();
            } else {
                total = total + q.getPenalty();
            }
        }
        System.out.println("Total Score: " + total);
    }
}
