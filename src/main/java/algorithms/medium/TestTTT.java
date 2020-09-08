package algorithms.medium;

import java.util.*;

public class TestTTT {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(3);

        Integer[] arrays = list.toArray(new Integer[0]);

        System.out.println(getByMap(arrays));
        System.out.println(getBySort(arrays));
        System.out.println(getByMath(arrays));



    }

    private static Integer getBySort(Integer[] nums) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int index = 0; index < nums.length - 1; index += 2) {
            if (nums[index] != nums[index + 1]) {
                return nums[index];
            }
        }

        return null;
    }
    private static Integer getByMath(Integer[] nums) {
        int result = 0;
        for (Integer num : nums) {
            result ^= num;
        }

        return result;
    }

    private static Integer getByMap(Integer[] nums) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        for (Integer num : nums) {
            Integer count = 1;
            if (numsCount.containsKey(num)) {
                count = numsCount.get(num) - 1;
            }
            if (count == 0) {
                numsCount.remove(num);
            } else {
                numsCount.put(num, count);
            }
        }

        Iterator<Integer> iterator = numsCount.keySet().iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}
