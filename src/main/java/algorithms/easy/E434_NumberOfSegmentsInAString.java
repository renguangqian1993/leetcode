package algorithms.easy;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int count = 0;
        boolean alphabetFlag = false;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == ' ') {
                if (alphabetFlag) {
                    count++;
                }
                alphabetFlag = false;
            } else {
                alphabetFlag = true;
            }
        }

        count += alphabetFlag ? 1 : 0;
        return count;
    }

    /**
     * 官方优雅的写法
     *
     * @param s
     * @return
     */
    public int countSegmentss(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
