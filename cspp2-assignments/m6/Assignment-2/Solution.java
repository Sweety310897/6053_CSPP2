import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
        final int rows, final int columns) {
        final int z = 500;
        final int y = 550;
        final int x = 450;
        final int w = 400;
        final int p = 350;
        final int q = 300;
        final int r = 250;
        final int s = 200;
        final int t = 150;
        final int g = 100;
        final int h = 50;
        final int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] <= h) {
                    a[i][j] = k;
                }
                if (a[i][j] > h && a[i][j] <= t) {
                    a[i][j] = g;
                }
                if (a[i][j] > t && a[i][j] < r) {
                    a[i][j] = s;
                }
                if (a[i][j] > r && a[i][j] < p) {
                    a[i][j] = q;
                }
                if (a[i][j] > p && a[i][j] < x) {
                    a[i][j] = w;
                }
                if (a[i][j] > x && a[i][j] < y) {
                    a[i][j] = z;
                }

            }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
