package algorithms.medium;

import java.util.Stack;

/**
 * 71. 简化路径
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *
 *
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M071_simplify_path {
    public static void main(String[] args) {
        M071_simplify_path instance = new M071_simplify_path();
        instance.test();
    }

    private void test() {
        Solution solution1 = new Solution();
        String[] array = new String[]{"/home/",
                "/../",
                "/home//foo/",
                "/a/./b/../../c/",
                "/a/../../b/../c//.//",
                "/a//b////c/d//././/.."};
        for (String s : array) {
            solution1.simplifyPath(s);
        }
    }

    private class Solution {

        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();

            StringBuilder buffer = new StringBuilder();
            char[] chars = path.toCharArray();
            for (char c : chars) {
                if (c == '/') {
                    if (buffer.length() == 0) {
                        buffer.append(c);
                    } else if (buffer.charAt(buffer.length() - 1) == '/') {
                        //忽略多余斜杠
                        continue;
                    } else {
                        //新起一个路径
                        stack.push(buffer.toString());
                        buffer = new StringBuilder();
                        buffer.append(c);
                    }
                } else {
                    buffer.append(c);
                }
            }
            //缓存区的路径（最后一个路径）入栈
            if (buffer.length() != 0) {
                stack.push(buffer.toString());
                buffer = new StringBuilder();
            }

            while (!stack.isEmpty()) {
                String currPath = stack.pop();
                if ("/.".equals(currPath)) {
                    //忽略当前路径
                    continue;
                } else if ("/..".equals(currPath)) {
                    int count = 1;
                    while (!stack.isEmpty() && count >= 1) {
                        String tmpPath = stack.pop();
                        if ("/..".equals(tmpPath)) {
                            count++;
                        } else if (!"/.".equals(tmpPath)) {
                            count--;
                        }
                    }
                } else {
                    buffer.insert(0, currPath);
                }
            }
            if (buffer.length() == 0) {
                buffer.append("/");
            }
            while (buffer.length() > 1 && buffer.charAt(buffer.length() - 1) == '/') {
                buffer.deleteCharAt(buffer.length() - 1);
            }

            return buffer.toString();
        }
    }
}


