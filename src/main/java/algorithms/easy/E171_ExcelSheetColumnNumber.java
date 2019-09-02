package algorithms.easy;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了95.47%的用户
     * 内存消耗 :35.5 MB, 在所有 Java 提交中击败了38.40%的用户
     */
    public static int titleToNumber(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int column = 0;

        char[] chars = s.toCharArray();
        for (char charTmp : chars) {
            column *= 26;
            column += (charTmp - 'A' + 1);
        }

        return column;
    }
}
