package leetcode.easy;

/**
 * 605. Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * @auTHOR TangYue
 * @date 2023/6/5
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,0};
        System.out.println(canPlaceFlowers(flowerbed, 2));
    }

    /**
     * 贪心问题 求解花坛的最大种花数量
     * 数学归纳
     * 1-2 0
     * 3-4 1
     * 5-6 2
     * count = (count - 1) / 2
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0){
            return n == 0;
        }
        int len = flowerbed.length;
        // 可种花数
        int num = 0;
        // 统计0的个数，默认1可以处理边界问题
        int countZero = 1;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                countZero++;
            } else {
                num += (countZero - 1) / 2;
                countZero = 0;
            }
        }
        // 最后补0
        countZero++;
        num += (countZero - 1) / 2;
        return num >= n;
    }
}
