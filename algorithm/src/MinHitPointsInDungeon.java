/**
 * Created by Jeff on 1/11/15.
 */
public class MinHitPointsInDungeon {
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

    private static int[][] testDungeon5 = {
            {1,-3,3},
            {0,-2,0},
            {-3,-3,-3}
    };

    public static void main(String[] args) {
        System.out.println(solve(testDungeon1));
        System.out.println(solve(testDungeon2));
        System.out.println(solve(testDungeon3));
        System.out.println(solve(testDungeon4));
        System.out.println(solve(testDungeon5));
    }

    public static int solve(int[][] dungeon) {
        return new Solution().calculateMinimumHP(dungeon);
    }
    public static class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int rows = dungeon.length;
            int cols = dungeon[0].length;
            int[][] healthNeeded = new int[rows][cols];

            healthNeeded[rows-1][cols-1] = max(1, -dungeon[rows - 1][cols - 1] + 1);
            for (int i = rows-2; i >= 0; i--) {
                healthNeeded[i][cols-1] = max(1, healthNeeded[i+1][cols-1] - dungeon[i][cols-1]);
            }
            for (int j = cols-2; j >=0; j--) {
                healthNeeded[rows-1][j] = max(1, healthNeeded[rows-1][j+1] - dungeon[rows-1][j]);
            }

            for (int i = rows-2; i >=0; i--) {
                for (int j = cols-2; j >=0; j--) {
                    int health1 = max(1, healthNeeded[i+1][j] - dungeon[i][j]);
                    int health2 = max(1, healthNeeded[i][j+1] - dungeon[i][j]);
                    healthNeeded[i][j] = min(health1, health2);
                }
            }

            return healthNeeded[0][0];

        }

        private int min(int i, int j) {
            return i < j ? i : j;
        }

        private int max(int i, int j) {
            return i < j ? j : i;
        }

    }
}
