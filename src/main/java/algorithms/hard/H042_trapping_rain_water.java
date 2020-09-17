package algorithms.hard;

/**
 * 42. 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class H042_trapping_rain_water {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution.trap(height);
    }

    /**
     * 粗暴解法
     * 遍历每个index，获取【左侧最高】、【右侧最高】，取两者最小值，与当前index的高度差即为容量
     */
    private static class Solution {
        public static int trap(int[] height) {
            int result = 0;
            for (int index = 0; index < height.length; index++) {
                int maxLeft = getMaxLeft(height, index);
                if (maxLeft <= height[index]) {
                    continue;
                }

                int maxRight = getMaxRight(height, index);
                if (maxRight <= height[index]) {
                    continue;
                }

                int minMaxHeight = Math.min(maxLeft, maxRight);
                result += (minMaxHeight - height[index]);
            }
            return result;
        }

        private static int getMaxLeft(int[] height, int fromIndex) {
            if (fromIndex >= height.length || fromIndex < 0) {
                return 0;
            }
            return Math.max(height[fromIndex], getMaxLeft(height, fromIndex - 1));
        }
        private static int getMaxRight(int[] height, int fromIndex) {
            if (fromIndex >= height.length || fromIndex < 0) {
                return 0;
            }
            return Math.max(height[fromIndex], getMaxRight(height, fromIndex + 1));
        }
    }
}
