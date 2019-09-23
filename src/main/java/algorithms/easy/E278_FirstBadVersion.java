package algorithms.easy;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version. 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E278_FirstBadVersion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.firstBadVersion(2126753390);
    }

    private static class Solution extends VersionControl {
        /**
         * 二分法，注意int约界
         * 执行用时 :12 ms, 在所有 Java 提交中击败了99.87%的用户
         * 内存消耗 :33 MB, 在所有 Java 提交中击败了67.69%的用户
         */
        public int firstBadVersion(int n) {
            int indexL = 0;
            int indexR = n;
            while (indexL <= indexR) {
                if (indexL == indexR) {
                    return indexL;
                }

                int index = (int) (indexL / 2.0D + indexR / 2.0D);
                boolean badVersion = this.isBadVersion(index);

                if (badVersion) {
                    indexR = index;
                } else {
                    indexL = index + 1;
                }
            }
            return 0;
        }
    }
    private static class VersionControl {
        boolean isBadVersion(int version) {
            if (version >= 1702766719) {
                return true;
            }
            return false;
        }
    }

}

