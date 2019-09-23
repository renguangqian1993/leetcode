package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 *
 * Note: If there is no valid move, return an empty list [].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E293_FlipGame {

    public static void main(String[] args) {
        String str = "++++";
        generatePossibleNextMoves(str);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.70%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (null == s || s.length() < 2) {
            return result;
        }

        for (int index = 0; index <= s.length() - 2; index++) {
            if (s.charAt(index) == '+' && s.charAt(index + 1) == '+') {
                result.add(s.substring(0, index) + "--" + s.substring(index + 2));
            }
        }

        return result;
    }
}
