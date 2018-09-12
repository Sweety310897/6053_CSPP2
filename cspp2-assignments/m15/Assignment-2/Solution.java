import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Exception for signaling invalidsubset errors.
 */
class InvalidsubsetException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     string parameter.
     */
    InvalidsubsetException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling empty errors.
 */
class EmptyException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     String parameter.
     */
    EmptyException(final String s) {
        super(s);
    }
}
/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * sort function.
     *
     * @param      array  The array
     */
    public void sort(final int[] array) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    /**
     * add function.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            set[size++] = item;
        }
        sort(set);
    }
    /**
     * subset.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     from start to end returns elements.
     */
    /**
     * subset.
     *
     * @param      start                   The start
     * @param      end                     The end
     *
     * @return     returns list of elements.
     *
     * @throws     InvalidsubsetException  exception.
     */
    public int[] subSet(final int start, final int end) throws
    InvalidsubsetException {
        if (start > end) {
            throw new InvalidsubsetException(
                "Invalid Arguments to Subset Exception");
            //return null;
        }
        int[] result = new int[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= start) {
                for (int j = i; j < size; j++) {
                    if (set[j] < end) {
                        result[k++] = set[i];
                    }
                    break;
                }
            }
        }
        return Arrays.copyOf(result, k);
    }
    /**
     * headset function.
     *
     * @param      end   The end
     *
     * @return     returms elements.
     */
    public int[] headSet(final int end) throws EmptyException {
        int[] result = new int[size];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < end) {
                result[i] = set[i];
                temp++;
            }
        }
        if (temp == 0) {
            throw new EmptyException("Set Empty Exception");
        }
        return Arrays.copyOf(result, temp);
    }
    /**
     * last function.
     *
     * @return     returns list of elements.
     */
    /**
     * last function.
     *
     * @return     set of elements.
     *
     * @throws     EmptyException  Emptyset exception.
     */
    public int last() throws EmptyException {
        if (size == 0) {
            throw new EmptyException("Set Empty Exception");
            //return -1;
        }
        return set[size - 1];
    }
    /**
     * Adds all.
     *
     * @param      element  The element
     */
    public void addAll(final int[] element) {
        for (int i : element) {
            this.add(i);
        }
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new SortedSet();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSet();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            case "subSet":
            try {
                if (tokens.length != 2) {
                    break;
                }
                String[] arrstring3 = tokens[1].split(",");
                int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(Arrays.toString(object).replace("[",
                        "{").replace("]", "}"));
                }
            } catch (InvalidsubsetException e) {
                System.out.println(e.getMessage());
            }
                break;
            case "headSet":
            try {
                if (tokens.length != 2) {
                    break;
                }
                int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                if (obj != null) {
                    System.out.println(Arrays.toString(obj).replace("[",
                        "{").replace("]", "}"));
                }
            } catch (EmptyException e) {
                System.out.println(e.getMessage());

            }
                break;
            case "last":
            try {
                if (tokens.length != 1) {
                    break;
                }
                int temp = s.last();
                System.out.println(temp);
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }
            break;
            case "addAll":
                int[] intArr = intArray(tokens[1]);
                if (intArr.length == 1) {
                    s.add(intArr[0]);
                } else {
                    s.add(intArr);
                }
                break;
            default:
                break;
            }
        }
    }
}





