import java.util.HashMap;
import java.util.Map;
//import java.util.Iterator;
//import java.util.Set;
import java.util.Scanner;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
//import java.util.List;
import java.io.FileReader;
/**
 * Class for frequency.
 */
class Frequency {
    /**
     * Constructs the object.
     */
    protected Frequency() {
        //constructor.
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      filename  The filename
     *
     * @return     String representation of the object.
     */
    public static String toString(final File filename) {
        String s = "";
        try {
            Scanner input = new Scanner(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            while (input.hasNext()) {
                sb.append(input.next());
                sb.append(" ");
            }
            input.close();
            s = sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("no file");
        }
        return s;
    }
    /**
     * Removes all.
     *
     * @param      text  The text
     *
     * @return     Map values.
     */
    public static Map removeAll(final String text) {
        String[] wordList = text.replaceAll(
            "[^a-zA-Z. ]", "").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        int freq = 0;
        for (int i = 0; i < wordList.length; i++) {
            if (!map.containsKey(wordList[i])) {
                map.put(wordList[i], 1);
            } else {
                map.put(wordList[i], map.get(wordList[i]) + 1);
            }
        }
        return map;
    }
    /**
     * similarity function.
     *
     * @param      doc1  The document 1
     * @param      doc2  The document 2
     *
     * @return     int value.
     */
    public static int similarity(final String doc1, final String doc2) {
        double numerator = 0;
        double sum1 = 0;
        double sum2 = 0;
        final double hun = 100;
        Map<String, Integer> mapOne = removeAll(doc1);
        Map<String, Integer> mapTwo = removeAll(doc2);
        for (String element1:mapOne.keySet()) {
            for (String element2:mapTwo.keySet()) {
                if (element1.equals(element2)) {
                    numerator += mapOne.get(element1)
                    * mapTwo.get(element2);
                }
            }
        }
        for (String element1:mapOne.keySet()) {
            sum1 += Math.pow(mapOne.get(element1), 2);
        }
        for (String element2:mapTwo.keySet()) {
            sum2 += Math.pow(mapTwo.get(element2), 2);
        }
        double denominator = Math.sqrt(sum1) * Math.sqrt(sum2);
        return (int) ((((numerator / denominator) * hun) / hun) * hun);


    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Solution.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
        Frequency f = new Frequency();
        Scanner sc = new Scanner(System.in);
        File input = new File(sc.next());
        File[] listoffiles = input.listFiles();
        int maximum = 0;
        final int hundered = 100;
        String result1 = "";
        int length = listoffiles.length;
        int[][] result = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    result[i][j] = hundered;
                } else {
                result[i][j] = Frequency.similarity(
                    Frequency.toString(
                    listoffiles[i]), Frequency.toString(listoffiles[j]));
                if (maximum < result[i][j]) {
                    maximum = result[i][j];
                    result1 = "Maximum similarity is in between "
                    + listoffiles[i].getName() + " and "
                    + listoffiles[j].getName();
                }
            }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < length; i++) {
            System.out.print("\t" + listoffiles[i].getName());
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(listoffiles[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(result[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println(result1);
    } catch (Exception e) {
        System.out.println("empty directory");
    }
    }
}





