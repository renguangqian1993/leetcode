package algorithms.easy;

/**
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 * <p>
 * A string such as "word" contains only the following valid abbreviations:
 * <p>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word".
 * Any other string is not a valid abbreviation of "word".
 * <p>
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 * <p>
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 * <p>
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * Return false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E408_ValidWordAbbreviation {
    public static void main(String[] args) {
//        String word = "internationalization";
//        String abbr = "i12iz4n";
        String word = "a";
        String abbr = "01";
        validWordAbbreviation(word, abbr);
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int slowIndex = 0;
        int fastIndex = 0;
        int offset = 0;
        while (slowIndex + offset != word.length() || fastIndex != abbr.length()) {
            if (slowIndex + offset >= word.length() || fastIndex >= abbr.length()) {
                return false;
            }

            if (word.charAt(slowIndex + offset) != abbr.charAt(fastIndex)) {
                if (offset == 0 && '0' == abbr.charAt(fastIndex)) {
                    return false;
                }
                offset = offset * 10 + (abbr.charAt(fastIndex) - '0');
                fastIndex++;
            } else {
                fastIndex++;
                slowIndex++;
                slowIndex += offset;
                offset = 0;
            }

        }
        return slowIndex + offset == word.length() && fastIndex == abbr.length();
    }

}
