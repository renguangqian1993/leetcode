package algorithms.easy;

/**
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E463_IslandPerimeter {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{new int[]{1,2},new int[]{3,4}};
//        islandPerimeter(new int[][]{new int[]{0,1,0,0},new int[]{1,1,1,0},new int[]{0,1,0,0},new int[]{1,1,0,0}});
        islandPerimeter(new int[][]{new int[]{1,0}});
    }
    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                count += islandPerimeter(grid, x, y);
            }
        }
        return count;
    }

    public static int islandPerimeter(int[][] grid, int x, int y) {
        int count = 0;
        if (grid[x][y] == 0) {
            return count;
        }
        if (x <= 0 || grid[x - 1][y] == 0) {
            count++;
        }
        if (x >= grid.length - 1 || grid[x + 1][y] == 0) {
            count++;
        }
        if (y <= 0 || grid[x][y - 1] == 0) {
            count++;
        }
        if (y >= grid[x].length - 1 || grid[x][y + 1] == 0) {
            count++;
        }
        return count;
    }
}
