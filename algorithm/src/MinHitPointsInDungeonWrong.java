import java.util.Random;

/**
 * Created by Jeff on 1/9/15.
 */
public class MinHitPointsInDungeonWrong {
    private static int[][] testDungeon1 = {
            {-5, -10, 9},
            {10, 9, 10},
            {-20, -5, -15},
            {-10, -15, 5}
    };

    private static int[][] testDungeon2 = {
            {1}
    };

    private static int[][] testDungeon3 = {
            {-10},
            {-20},
            {-30}
    };

    private static int[][] testDungeon4 = {
            {3,-20,30},
            {-3,4,0}
    };

    public static void main(String[] args) {
        Solution s = new MinHitPointsInDungeonWrong().getSolution();
        System.out.println(s.calculateMinimumHP(testDungeon1));
        System.out.println(s.calculateMinimumHP(testDungeon2));
        System.out.println(s.calculateMinimumHP(testDungeon3));
        System.out.println(s.calculateMinimumHP(testDungeon4));
//        System.out.println(s.calculateMinimumHP(getRandomMatrix()));
    }

    private final Solution s = new Solution();
    private Solution getSolution() {
        return s;
    }

    public class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null) {
                return 1;
            }
            final int rows = dungeon.length;
            final int cols = dungeon[0].length;
            int[][] maxGains = new int[rows][cols];
            maxGains[0][0] = dungeon[0][0];
            boolean[][] fromLeft = new boolean[rows][cols];
            for (int i = 1; i < rows; i++) {
                maxGains[i][0] = maxGains[i-1][0] + dungeon[i][0];
                fromLeft[i][0] = false;
            }
            for (int i = 1; i < cols; i++) {
                maxGains[0][i] = maxGains[0][i-1] + dungeon[0][i];
                fromLeft[0][i] = true;
            }

            if (rows > 1 && cols > 1) {
                for (int i = 2; i <= rows + cols - 2; i++) {
                    for (int j = 1; j < i; j++) {
                        if (j > rows - 1) {
                            break;
                        }
                        if (i - j > cols - 1) {
                            j = i - cols + 1;
                        }
                        if (maxGains[j-1][i-j] > maxGains[j][i-j-1]) {
                            maxGains[j][i-j] = maxGains[j-1][i-j] + dungeon[j][i-j];
                            fromLeft[j][i-j] = false;
                        } else {
                            maxGains[j][i-j] = maxGains[j][i-j-1] + dungeon[j][i-j];
                            fromLeft[j][i-j] = true;
                        }
                    }
                }
            }
            return calcMinHealth(maxGains, fromLeft);
        }

        private int calcMinHealth(int[][] maxGains, boolean[][] fromLeft) {
//            printMatrix(maxGains);
//            printMatrix(fromLeft);
            int i = maxGains.length - 1;
            int j = maxGains[0].length - 1;
            int min = 0;
            while (i >= 0 && j >= 0) {
                if (maxGains[i][j] < min) {
                    min = maxGains[i][j];
                }
                if (fromLeft[i][j]) {
                    j--;
                } else {
                    i--;
                }
            }
            if (min == 0) {
                return 1;
            }
            return -min + 1;
        }
    }



    private void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void printMatrix(boolean[][] fromLeft) {
        int rows = fromLeft.length;
        int cols = fromLeft[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (fromLeft[i][j]) {
                    System.out.print("<");
                } else {
                    System.out.print("^");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int[][] getRandomMatrix() {
        Random rand = new Random();
        int rows = rand.nextInt(100);
        int cols = rand.nextInt(100);
        int[][] randomMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                randomMatrix[i][j] = rand.nextInt(100) - 90;
            }
        }
        return randomMatrix;
    }
}
