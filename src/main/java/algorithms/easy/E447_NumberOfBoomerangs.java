package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs.
 * You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E447_NumberOfBoomerangs {
    public static void main(String[] args) {
//        numberOfBoomerangs(new int[][]{new int[]{0,0},new int[]{1,0},new int[]{2,0}});
        numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}});
    }

    /**
     * TODO 题目标签是hashmap，需要思考考察啥？
     * 参考别人解法，求的是从某一个节点，到其余节点，长度相同的所有节点之间双向连线
     *
     * @param points
     * @return
     */
    public static int numberOfBoomerangs(int[][] points) {
        int totalCount = 0;
        for (int index1 = 0; index1 < points.length; index1++) {
            Map<Integer, Integer> distanceMap = new HashMap<>();

            for (int index2 = 0; index2 < points.length; index2++) {
                if (index1 == index2) {
                    continue;
                }

                int distance = (points[index1][0] - points[index2][0]) * (points[index1][0] - points[index2][0])
                        + (points[index1][1] - points[index2][1]) * (points[index1][1] - points[index2][1]);
                if (distanceMap.containsKey(distance)) {
                    distanceMap.put(distance, distanceMap.get(distance) + 1);
                } else {
                    distanceMap.put(distance, 1);
                }
            }

            for (Integer count : distanceMap.values()) {
                totalCount += count * (count - 1);
            }
        }

        return totalCount;
    }
}
