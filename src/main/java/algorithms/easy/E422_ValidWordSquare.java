package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sequence of words, check whether it forms a valid word square.
 * <p>
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * <p>
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crmy",
 * "dtye"
 * ]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crmy".
 * The fourth row and fourth column both read "dtye".
 * <p>
 * Therefore, it is a valid word square.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [
 * "abcd",
 * "bnrt",
 * "crm",
 * "dt"
 * ]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The first row and first column both read "abcd".
 * The second row and second column both read "bnrt".
 * The third row and third column both read "crm".
 * The fourth row and fourth column both read "dt".
 * <p>
 * Therefore, it is a valid word square.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * [
 * "ball",
 * "area",
 * "read",
 * "lady"
 * ]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * The third row reads "read" while the third column reads "lead".
 * <p>
 * Therefore, it is NOT a valid word square.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E422_ValidWordSquare {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
//        words.add("abc");
//        words.add("b");

        words.add("ball");
        words.add("asee");
        words.add("let");
        words.add("lep");

        validWordSquare(words);
    }

    public static boolean validWordSquare(List<String> words) {
        if (null == words || words.size() < 1) {
            return false;
        }
        int[][] map = new int[words.size()][500];
        for (int indexOfWord = 0; indexOfWord < words.size(); indexOfWord++) {
            String word = words.get(indexOfWord);
            if (word.length() > words.size()) {
                return false;
            }
            char[] chars = word.toCharArray();
            for (int indexOfChar = 0; indexOfChar < chars.length; indexOfChar++) {
                map[indexOfWord][indexOfChar] = chars[indexOfChar] - 'a' + 1;
            }

        }

        for (int indexL = 0; indexL < map.length; indexL++) {
            for (int indexR = indexL + 1; indexR < map.length; indexR++) {
                if (map[indexL][indexR] != map[indexR][indexL]) {
                    return false;
                }
            }
        }

        return true;
    }
}
