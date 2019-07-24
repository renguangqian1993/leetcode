package algorithms.easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *  
 *
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E038_CountAndSay {
    /**
     * 执行用时:6 ms, 在所有 Java 提交中击败了62.87%的用户
     * 内存消耗:35 MB, 在所有 Java 提交中击败了85.02%的用户
     * @idea: 两重循环：1.从1开始到n不可免；2.从左到右遍历前一代字符串好像也不可避免
     */
    public String countAndSay(int n) {
        String preStr = "1";
        StringBuffer currentStr = null;
        for (int indexOfGeneration = 2; indexOfGeneration <= n; indexOfGeneration++) {
            currentStr = new StringBuffer();
            char charTmp = preStr.charAt(0);
            int duplicateCharCount = 1;
            
            for (int indexOfChar = 1; indexOfChar < preStr.length(); indexOfChar++) {
                if (charTmp == preStr.charAt(indexOfChar)) {
                    duplicateCharCount++;
                } else {
                    currentStr.append(duplicateCharCount).append(charTmp);
                    charTmp = preStr.charAt(indexOfChar);
                    duplicateCharCount = 1;
                }
            }
            currentStr.append(duplicateCharCount).append(charTmp);
            preStr = currentStr.toString();
        }
        
        return preStr;
    }
    
    public static void main(String[] args) {
        E038_CountAndSay instance = new E038_CountAndSay();
        
        for (int index = 1; index <= 5; index++) {
            System.out.println(index + ":" + instance.countAndSay(index));
        }
    }

}
