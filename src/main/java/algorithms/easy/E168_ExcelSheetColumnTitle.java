package algorithms.easy;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 * Input: 701
 * Output: "ZY"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E168_ExcelSheetColumnTitle {
    public static void main(String[] args) {
        for (int index = 1; index < 100; index++) {
            System.out.println(index + " : " + convertToTitle(index));
        }
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.9 MB, 在所有 Java 提交中击败了83.37%的用户
     */
    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        while (n > 0) {
            if (n % 26 == 0) {
                stringBuilder.append('Z');
                n = (n - 1) / 26;
            } else {
                stringBuilder.append(chars[(n % 26) - 1]);
                n = n / 26;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
