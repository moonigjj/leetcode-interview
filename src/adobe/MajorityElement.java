/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package adobe;

import java.util.HashMap;

/**
 *Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @author tangyue
 * @version $Id: MajorityElement.java, v 0.1 2018-11-20 13:41 tangyue Exp $$
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // 计数
        int count = 0;
        // 临时变量，存储最多元素值，元素的个数大于数组长度一半
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            if (count == 0){
                // 如果计数为0，变换新元素重新计数
                tmp = nums[i];
                count++;
            } else if (tmp == nums[i]) {
                // 相等加一
                count++;
            } else {
                // 不等计数减一
                count--;
            }
        }
        return tmp;
    }

    /**
     * 解法2，利用map，存储元素以及元素统计计数
     * 如果有元素计数大于数组长度的一半就返回
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int current: nums) {
            if(map.containsKey(current) && map.get(current) + 1 > len / 2) {
                return current;
            } else if(map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        //no majority element exists
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{1, 2, 2, 3, 2}));
    }
}
