package algorithms.easy;

import java.util.*;
import java.util.stream.Collectors;

public class E401_BinaryWatch {
    public static void main(String[] args) throws Exception {
        String[] src = new String[]{"0:15", "0:23", "0:27", "0:29", "0:30", "0:39", "0:43", "0:45", "0:46", "0:51", "0:53", "0:54", "0:57", "0:58", "1:07", "1:11", "1:13", "1:14", "1:19", "1:21", "1:22", "1:25", "1:26", "1:28", "1:35", "1:37", "1:38", "1:41", "1:42", "1:44", "1:49", "1:50", "1:52", "1:56", "2:07", "2:11", "2:13", "2:14", "2:19", "2:21", "2:22", "2:25", "2:26", "2:28", "2:35", "2:37", "2:38", "2:41", "2:42", "2:44", "2:49", "2:50", "2:52", "2:56", "3:03", "3:05", "3:06", "3:09", "3:10", "3:12", "3:17", "3:18", "3:20", "3:24", "3:33", "3:34", "3:36", "3:40", "3:48", "4:07", "4:11", "4:13", "4:14", "4:19", "4:21", "4:22", "4:25", "4:26", "4:28", "4:35", "4:37", "4:38", "4:41", "4:42", "4:44", "4:49", "4:50", "4:52", "4:56", "5:03", "5:05", "5:06", "5:09", "5:10", "5:12", "5:17", "5:18", "5:20", "5:24", "5:33", "5:34", "5:36", "5:40", "5:48", "6:03", "6:05", "6:06", "6:09", "6:10", "6:12", "6:17", "6:18", "6:20", "6:24", "6:33", "6:34", "6:36", "6:40", "6:48", "7:01", "7:02", "7:04", "7:08", "7:16", "7:32", "8:07", "8:11", "8:13", "8:14", "8:19", "8:21", "8:22", "8:25", "8:26", "8:28", "8:35", "8:37", "8:38", "8:41", "8:42", "8:44", "8:49", "8:50", "8:52", "8:56", "9:03", "9:05", "9:06", "9:09", "9:10", "9:12", "9:17", "9:18", "9:20", "9:24", "9:33", "9:34", "9:36", "9:40", "9:48", "10:03", "10:05", "10:06", "10:09", "10:10", "10:12", "10:17", "10:18", "10:20", "10:24", "10:33", "10:34", "10:36", "10:40", "10:48", "11:01", "11:02", "11:04", "11:08", "11:16", "11:32"};
        String[] dest = new String[]{"0:15", "0:23", "0:39", "0:27", "0:43", "0:51", "0:29", "0:45", "0:53", "0:57", "0:30", "0:46", "0:54", "0:58", "0:60", "1:07", "1:11", "1:19", "1:35", "1:13", "1:21", "1:37", "1:25", "1:41", "1:49", "1:14", "1:22", "1:38", "1:26", "1:42", "1:50", "1:28", "1:44", "1:52", "1:56", "2:07", "2:11", "2:19", "2:35", "2:13", "2:21", "2:37", "2:25", "2:41", "2:49", "2:14", "2:22", "2:38", "2:26", "2:42", "2:50", "2:28", "2:44", "2:52", "2:56", "4:07", "4:11", "4:19", "4:35", "4:13", "4:21", "4:37", "4:25", "4:41", "4:49", "4:14", "4:22", "4:38", "4:26", "4:42", "4:50", "4:28", "4:44", "4:52", "4:56", "8:07", "8:11", "8:19", "8:35", "8:13", "8:21", "8:37", "8:25", "8:41", "8:49", "8:14", "8:22", "8:38", "8:26", "8:42", "8:50", "8:28", "8:44", "8:52", "8:56", "3:03", "3:05", "3:09", "3:17", "3:33", "3:06", "3:10", "3:18", "3:34", "3:12", "3:20", "3:36", "3:24", "3:40", "3:48", "5:03", "5:05", "5:09", "5:17", "5:33", "5:06", "5:10", "5:18", "5:34", "5:12", "5:20", "5:36", "5:24", "5:40", "5:48", "9:03", "9:05", "9:09", "9:17", "9:33", "9:06", "9:10", "9:18", "9:34", "9:12", "9:20", "9:36", "9:24", "9:40", "9:48", "6:03", "6:05", "6:09", "6:17", "6:33", "6:06", "6:10", "6:18", "6:34", "6:12", "6:20", "6:36", "6:24", "6:40", "6:48", "10:03", "10:05", "10:09", "10:17", "10:33", "10:06", "10:10", "10:18", "10:34", "10:12", "10:20", "10:36", "10:24", "10:40", "10:48", "7:01", "7:02", "7:04", "7:08", "7:16", "7:32", "11:01", "11:02", "11:04", "11:08", "11:16", "11:32"};

        Set<String> srcSet = new HashSet<>();
        Set<String> destSet = new HashSet<>();


        for (String srcStr : src) {
            if (srcSet.contains(srcStr)) {
                throw new Exception("有重复");
            }
            srcSet.add(srcStr);
        }

        for (String descStr : dest) {
            if (destSet.contains(descStr)) {
                throw new Exception("有重复");
            }
            destSet.add(descStr);
        }

        System.out.println();
//        readBinaryWatch(2);
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> hourAndMinuteList = new ArrayList<>();
        if (num > 10) {
            return hourAndMinuteList;
        }

        for (int hourNum = Math.min(0, Math.abs(num - 6)); hourNum <= 4; hourNum++) {
            if (num - hourNum < 0) {
                continue;
            }
            List<String> hourList = readHour(hourNum);
            List<String> minuteList = readMinute(num - hourNum);
            for (String hour : hourList) {
                for (String minute : minuteList) {
                    hourAndMinuteList.add(hour + ":" + minute);
                }
            }
        }

        return hourAndMinuteList;
    }

    /**
     * @param hourNum 最大为4
     * @return
     */
    public static List<String> readHour(int hourNum) {
        if (hourNum <= 0) {
            return Collections.singletonList("0");
        }

        List<Integer> hourListByInt = getHour(hourNum, 0, 0);

        return hourListByInt.stream().map(String::valueOf).collect(Collectors.toList());
    }

    /**
     * @param digitRemain 当前遗留需补充二进制个数
     * @param currCarry   当前二进制位
     * @param currVal     当前值
     * @return
     */
    public static List<Integer> getHour(int digitRemain, int currCarry, int currVal) {
        List<Integer> hourList = new ArrayList<>();

        if (currVal >= 12) {
            return hourList;
        } else if (digitRemain <= 0) {
            hourList.add(currVal);
        } else if (currCarry < 4) {
            List<Integer> hourListSelectCurr = getHour(digitRemain - 1, currCarry + 1,
                    (int) (currVal + Math.pow(2, currCarry)));
            List<Integer> hourListNotSelectCurr = getHour(digitRemain, currCarry + 1, currVal);

            hourList.addAll(hourListSelectCurr);
            hourList.addAll(hourListNotSelectCurr);

        }
        return hourList;
    }

    /**
     * @param minuteNum 最大为6
     * @return
     */
    public static List<String> readMinute(int minuteNum) {
        if (minuteNum <= 0) {
            return Collections.singletonList("00");
        }

        List<Integer> hourListByInt = getMinute(minuteNum, 0, 0);

        return hourListByInt.stream().map(minute -> String.format("%02d", minute)).collect(Collectors.toList());
    }

    public static List<Integer> getMinute(int digitRemain, int currCarry, int currVal) {
        List<Integer> minuteList = new ArrayList<>();

        if (currVal >= 60) {
        } else if (digitRemain <= 0) {
            minuteList.add(currVal);
        } else if (currCarry < 6) {
            List<Integer> hourListSelectCurr = getMinute(digitRemain - 1, currCarry + 1,
                    (int) (currVal + Math.pow(2, currCarry)));
            List<Integer> hourListNotSelectCurr = getMinute(digitRemain, currCarry + 1, currVal);

            minuteList.addAll(hourListSelectCurr);
            minuteList.addAll(hourListNotSelectCurr);

        }
        return minuteList;
    }

    /**
     * TODO 别人的解法
     */
    private class Solution {
        private final int[] binaryTime = new int[10];
        private List<String> results = new ArrayList<>();

        public List<String> readBinaryWatch(int num) {
            backTrackTime(0, num);
            return results;
        }

        private void backTrackTime(int index, int num) {
            if (num <= 0) {
                //输出时间
                String time = outputTime(binaryTime);
                if (time != null) {
                    results.add(time);
                }
                return;
            }

            if (index < binaryTime.length) {
                binaryTime[index] = 1;
                num--;
                backTrackTime(index + 1, num);
                binaryTime[index] = 0;
                num++;
                backTrackTime(index + 1, num);
            }

        }

        private String outputTime(int[] binaryTime) {
            String hour;
            int hourValue = 0;
            for (int i = 0; i < 4; i++) {
                hourValue += (1 << (3 - i)) * binaryTime[i];
            }
            if (hourValue >= 12) {
                return null;
            } else {
                hour = String.valueOf(hourValue);
            }

            String minutes;
            int minutesValue = 0;
            for (int i = 4; i < 10; i++) {
                minutesValue += (1 << (9 - i)) * binaryTime[i];
            }

            if (minutesValue < 10) {
                minutes = "0" + minutesValue;
            } else if (minutesValue > 59) {
                return null;
            } else {
                minutes = String.valueOf(minutesValue);
            }

            return hour + ":" + minutes;
        }
    }
}
