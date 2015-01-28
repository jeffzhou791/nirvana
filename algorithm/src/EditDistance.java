/**
 * Created by Jeff on 1/24/15.
 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance s = new EditDistance();
        System.out.println(s.minDistance("hello", "fellow"));
    }
    private int[][] distances;
    public int minDistance(String word1, String word2) {
        int rows = word1.length()+1;
        int cols = word2.length()+1;
        distances = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            distances[i][0] = i;
        }
        for (int j = 0; j < cols; j++) {
            distances[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                distances[i][j] = -1;
            }
        }

        return minDistance(word1.toCharArray(), word1.length()-1, word2.toCharArray(), word2.length()-1);
    }

    private int minDistance(char[] w1, int i, char[] w2, int j) {
        if (distances[i+1][j+1] != -1) {
            return distances[i+1][j+1];
        }
        int min = min(minDistance(w1, i-1, w2, j)+1, minDistance(w1, i, w2, j-1)+1);
        if (w1[i] == w2[j]) {
            min = min(min, minDistance(w1, i-1, w2, j-1));
        } else {
            min = min(min, minDistance(w1, i-1, w2, j-1)+1);
        }
        distances[i+1][j+1] = min;
        return min;
    }

    private static int min(int x, int y) {
        return x < y ? x : y;
    }

}
