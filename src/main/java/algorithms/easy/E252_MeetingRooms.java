package algorithms.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * <p>
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E252_MeetingRooms {
    /**
     * 真恶心，空间与时间扩大了不知道多少倍，
     * 执行用时 :239 ms, 在所有 Java 提交中击败了7.84%的用户
     * 内存消耗 :173.9 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        Set<Integer> set = new HashSet<>();

        for (int[] interval : intervals) {
            for (int time = interval[0]; time < interval[1]; time++) {
                if (set.contains(time)) {
                    return false;
                } else {
                    set.add(time);
                }
            }
        }

        return true;
    }

    /**
     * 排序法
     * 执行用时 :17 ms, 在所有 Java 提交中击败了53.92%的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static boolean canAttendMeetings2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int index = 0; index < intervals.length - 1; index++) {
            if (intervals[index][1] > intervals[index + 1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[2][];
        intervals[1] = new int[]{5, 8};
        intervals[0] = new int[]{6, 8};

        canAttendMeetings2(intervals);
    }
}
