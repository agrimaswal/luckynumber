import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();

        int m = matrix.length; // Number of rows
        int n = matrix[0].length; // Number of columns

        // Find minimum elements in each row
        int[] minRowValues = new int[m];
        for (int i = 0; i < m; i++) {
            int minRowValue = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minRowValue = Math.min(minRowValue, matrix[i][j]);
            }
            minRowValues[i] = minRowValue;
        }

        // Find maximum elements in each column
        int[] maxColValues = new int[n];
        for (int j = 0; j < n; j++) {
            int maxColValue = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                maxColValue = Math.max(maxColValue, matrix[i][j]);
            }
            maxColValues[j] = maxColValue;
        }

        // Check if an element is a lucky number and add it to the list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRowValues[i] && matrix[i][j] == maxColValues[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}
