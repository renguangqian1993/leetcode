package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * 我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 *
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
 * 扩张操作定义如下：选择一个字母组（包含字母c），然后往其中添加相同的字母c使其长度达到 3 或以上。
 *
 * 例如，以"hello" 为例，我们可以对字母组"o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于3。
 * 此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得"helllllooo"。
 * 如果S = "helllllooo"，那么查询词"hello" 是可扩张的，因为可以对它执行这两种扩张操作使得query = "hello" -> "hellooo" ->"helllllooo" = S。
 *
 * 输入一组查询单词，输出其中可扩张的单词数量。
 *
 *
 * 示例：
 *
 * 输入：
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 *
 * 说明：
 *
 * 0 <= len(S) <= 100。
 * 0 <= len(words) <= 100。
 * 0 <= len(words[i]) <= 100。
 * S和所有在words中的单词都只由小写字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expressive-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class M809_expressive_words {


    /**
     * 参考官方，将字符串解析为【无重复字符的key，字符的数量】
     * 然后匹配S与word
     */
    public int expressiveWords(String S, String[] words) {
        int count = 0;

        ParseWordDto dto = new ParseWordDto(S);
        rematch : for (String word : words) {
            ParseWordDto wordDto = new ParseWordDto(word);
            if (!dto.key.equals(wordDto.key)) {
                continue;
            }
            for (int index = 0; index < dto.countList.size(); index++) {
                int countOfW = wordDto.countList.get(index);
                int countOfEW = dto.countList.get(index);
                if ((countOfW > countOfEW)
                        || (countOfW != countOfEW && (countOfEW < 3))) {
                    continue rematch;
                }
            }
            count++;
        }
        return count;
    }
    private class ParseWordDto{
        String key;
        List<Integer> countList = new ArrayList<>();

        public ParseWordDto(String word) {
            StringBuilder stringBuilder = new StringBuilder();

            int preIndex = -1;
            for (int index = 0; index < word.length(); index++) {
                if (index == word.length() -1 || word.charAt(index) != word.charAt(index + 1)) {
                    stringBuilder.append(word.charAt(index));
                    countList.add(index - preIndex);
                    preIndex = index;
                }
            }

            this.key = stringBuilder.toString();
        }
    }

    /**
     * 主要逻辑与解析DTO一致，只是没有使用DTO，而是通过遍历字符串
     */
    public int expressiveWords2(String S, String[] words) {
        int count = 0;
        for (int index = 0; index < words.length; index++) {
            if (expressiveWordMatched(S, words[index])) {
                count++;
            }
        }
        return count;
    }
    private boolean expressiveWordMatched(String expressiveWord, String word) {
        int indexOfEW = 0;
        int indexOfW = 0;
        int countOfRepeatCharOfW = 0;
        int countOfRepeatCharOfEW = 0;

        int lenOfEW = expressiveWord.length();
        int lenOfW = word.length();

        while (indexOfEW < lenOfEW && indexOfW < lenOfW) {
            if (expressiveWord.charAt(indexOfEW) != word.charAt(indexOfW)) {
                return false;
            }

            countOfRepeatCharOfW = 1;
            while ((indexOfW < word.length() - 1) && (word.charAt(indexOfW) == word.charAt(indexOfW + 1))) {
                indexOfW++;
                countOfRepeatCharOfW++;
            }

            countOfRepeatCharOfEW = 1;
            while ((indexOfEW < expressiveWord.length() - 1)
                    && (expressiveWord.charAt(indexOfEW) == expressiveWord.charAt(indexOfEW + 1))) {
                indexOfEW++;
                countOfRepeatCharOfEW++;
            }
            if ((countOfRepeatCharOfW > countOfRepeatCharOfEW)
                    || (countOfRepeatCharOfW != countOfRepeatCharOfEW && (countOfRepeatCharOfEW < 3))) {
                return false;
            }
            indexOfW++;
            indexOfEW++;
        }

        return indexOfEW == lenOfEW && indexOfW == lenOfW;
    }

}
