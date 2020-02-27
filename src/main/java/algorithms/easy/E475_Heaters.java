package algorithms.easy;

import java.util.Arrays;

/**
 * Winter is coming!
 * Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line,
 * find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately,
 * and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * <p>
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2,
 * and if we use the radius 1 standard,
 * then all the houses can be warmed.
 *  
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4.
 * We need to use radius 1 standard, then all the houses can be warmed.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E475_Heaters {
    public static void main(String[] args) {
        /*int[] houses = new int[]{1,2,3,4};
        int[] heaters = new int[]{1,4};*/
        int[] houses = new int[]{1, 5};
        int[] heaters = new int[]{2};
        findRadius(houses, heaters);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int maxMinDist = 0;

        for (int indexOfHouse = 0, indexOfHeater = 0;
             indexOfHouse < houses.length & indexOfHeater < heaters.length;
             indexOfHouse++) {
            int minDist = Integer.MAX_VALUE;
            while (true) {
                int distOfCurrHeater = Math.abs(houses[indexOfHouse] - heaters[indexOfHeater]);
                if (indexOfHeater + 1 < heaters.length && distOfCurrHeater >= Math.abs(houses[indexOfHouse] - heaters[indexOfHeater + 1])) {
                    //下一个heater更优
                    indexOfHeater++;
                } else {
                    minDist = Math.min(minDist, distOfCurrHeater);
                    break;
                }
            }

            maxMinDist = Math.max(maxMinDist, minDist);
        }

        return maxMinDist;
    }

}
