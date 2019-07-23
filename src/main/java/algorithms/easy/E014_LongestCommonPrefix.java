package algorithms.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E014_LongestCommonPrefix {

    /**
     * 执行用时:4 ms, 在所有 Java 提交中击败了41.34%的用户
     * 内存消耗:35.7 MB, 在所有 Java 提交中击败了89.00%的用户
     *
     * @param strs
     * @return
     * @description: 从下标0开始，扫描比较所有字符串的下标，最坏情况下字符串全部相同
     * 时间复杂度为O(S)，S为字符总量；空间复杂度为O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length < 1 || null == strs[0] || "".equals(strs[0])) {
            return "";
        }
        StringBuffer prefixBuf = new StringBuffer("");

        int index = 0;
        while (index < strs[0].length()) {
            char charTmp = strs[0].charAt(index);

            for (String str : strs) {
                if (null == str || str.length() <= index || charTmp != str.charAt(index)) {
                    return prefixBuf.toString();
                }
            }
            prefixBuf.append(charTmp);
            index++;
        }

        return prefixBuf.toString();
    }

    /**
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * <p>
     * 最坏的情况下，n个字符串都是相同的。算法会将 S1 与其他字符串 [S2...Sn]都做一次比较。这样就会进行S次字符比较，其中S是输入数据中所有字符数量。
     * <p>
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 执行用时:2 ms, 在所有 Java 提交中击败了89.19%的用户
     * 内存消耗:37.1 MB, 在所有 Java 提交中击败了81.01%的用户
     *
     * @param strs
     * @return
     * @description: 官方暴力解法，以数组第一个字符串为基准，判断其他字符串是否以它开头，不是就将基准尾下标减一
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * 官方解法，分治算法
     * 将N多字符串两两匹配求最长公共前缀，最后合并。
     * <p>
     * 最坏情况下，我们有n个长度为m的相同字符串。
     * <p>
     * 时间复杂度：O(S)，S是所有字符串中字符数量的总和，S=m*n。
     * 时间复杂度的递推式为 T(n)=2*T(n/2)+O(m)，化简后可知其就是O(S)。
     * 最好情况下，算法会进行minLen*n次比较，其中minLen是数组中最短字符串的长度。
     * <p>
     * 空间复杂度：O(m*log(n))
     * 内存开支主要是递归过程中使用的栈空间所消耗的。 一共会进行log(n)次递归，每次需要m的空间存储返回结果，所以空间复杂度为O(m*log(n))。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }


    /**
     * leetcode官方，二分解法
     * 以数组第一个字符串为基准，与其他字符串进行比较
     * <p>
     * 最坏情况下，我们有n个长度为m的相同字符串。
     * 时间复杂度：O(S⋅log(n))，其中S所有字符串中字符数量的总和。
     * 算法一共会进行log(n)次迭代，每次一都会进行S=m*n次比较，所以总时间复杂度为O(S⋅log(n))。
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

}
