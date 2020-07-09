package leetcode.easy;

/**
 * 463. Island Perimeter
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 */
public class LandPerimeter {

    public static void main(String[] args) {

        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(islandPerimeter(grid));
    }

    /**
     * 4 x 方块 - 2 x 相连的边
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {

        int k = grid.length;
        int m = grid[0].length;
        // 方块数
        int s = 0;
        // 关连边数
        int side = 0;
        int[] temp = new int[m];
        for (int i = 0; i < k; i++){
            for (int j = 0; j < m; j++){
                // 方块加一
                if (grid[i][j] == 1){
                    s++;
                    // 与上一个相连的位置
                    if (temp[j] == 1 ){
                        side++;
                    }
                    // 与前以为相连
                    if (j > 0 && grid[i][j - 1] == 1){
                        side++;
                    }
                }
            }
            temp = grid[i];
        }
        return s * 4 - side * 2;
    }
}
