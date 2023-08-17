package leetcode.easy;

import java.util.*;

/**
 * 599
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 *
 * A common string is a string that appeared in both list1 and list2.
 *
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 *
 * Return all the common strings with the least index sum. Return the answer in any order.
 *
 * Example 1:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only common string is "Shogun".
 * Example 2:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
 * Example 3:
 *
 * Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
 * Output: ["sad","happy"]
 * Explanation: There are three common strings:
 * "happy" with index sum = (0 + 1) = 1.
 * "sad" with index sum = (1 + 0) = 1.
 * "good" with index sum = (2 + 2) = 4.
 * The strings with the least index sum are "sad" and "happy".
 *
 * @auTHOR TangYue
 * @date 2023/6/5
 */
public class MinimumIndexSumTwoLists {

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        // 最小值
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            String str = list2[j];
            if (map.containsKey(str)) {
                int sum = j + map.get(str);
                // if current sum is smaller than minSum
                if (sum < minSum) {
                    minSum = sum;
                    list.clear();
                    list.add(str);
                } else if (sum == minSum) { // if index sum is same then put this String in resultant list as well
                    list.add(str);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
