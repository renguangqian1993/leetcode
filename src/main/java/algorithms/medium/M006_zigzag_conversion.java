package algorithms.medium;

/**
 * 6. Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例2:
 * 输入: s = "LEETCODEISHIRING", numRows =4
 * 输出:"LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M006_zigzag_conversion {
    public static void main(String[] args) {
        String s = "abcdefghijklmno";
        int sLen = s.length();

        int sizePerGroup = 3 * 2 - 2;
        int groupSize = (sLen / sizePerGroup) + (sLen % sizePerGroup == 0 ? 0 : 1);

        System.out.println("s: " + s);
        System.out.println("sLen: " + sLen);
        System.out.println("sizePerGroup: " + sizePerGroup);
        System.out.println("groupSize: " + groupSize);



    }

    private class Solution {
        public String convert(String s, int numRows) {
            if (numRows <= 1) {
                return s;
            }
            final int sLen = s.length();

            int sizePerGroup = numRows * 2 - 2;
            int groupSize = (sLen / sizePerGroup) + (sLen % sizePerGroup == 0 ? 0 : 1);

            StringBuilder buffer = new StringBuilder();
            row: for (int indexOfRow = 0; indexOfRow < numRows; indexOfRow++) {
                group: for (int indexOfGroup = 0; indexOfGroup < groupSize; indexOfGroup++) {
                    int indexOfChar = indexOfGroup * sizePerGroup + indexOfRow;
                    if (indexOfChar >= sLen) {
                        continue group;
                    }

                    buffer.append(s.charAt(indexOfChar));
                    if (indexOfRow != 0 && indexOfRow != numRows - 1) {
                        indexOfChar = indexOfGroup * sizePerGroup + sizePerGroup - indexOfRow;
                        if (indexOfChar >= sLen) {
                            continue group;
                        }
                        buffer.append(s.charAt(indexOfChar));
                    }
                }
            }

            return buffer.toString();
        }
    }
}
