/**
 * Created by Jeff on 1/17/15.
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        paths[m-1][n-1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            paths[i][n-1] = obstacleGrid[i][n-1] == 1 ? 0 : paths[i+1][n-1];
        }
        for (int j = n - 2; j >= 0; j--) {
            paths[m-1][j] = obstacleGrid[m-1][j] == 1 ? 0 : paths[m-1][j+1];
        }
        if (m == 1 || n == 1) {
            return paths[0][0];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i+1][j] + paths[i][j+1];
                }
            }
        }

        return paths[0][0];

    }

    public static void main(String[] args) {
        UniquePaths2 paths = new UniquePaths2();
        System.out.println(paths.uniquePathsWithObstacles(new int[][] {
                {0,0,0,0,0,0},
                {0,0,1,0,0,0},
                {0,1,0,0,0,0},
                {0,0,0,0,1,0}
        }));
    }
}
