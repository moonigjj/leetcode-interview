/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 299. Bulls and Cows
 *You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * @author tangyue
 * @version $Id: BullsAndCows.java, v 0.1 2019-09-06 14:33 tangyue Exp $$
 */
public class BullsAndCows {

    public static void main(String[] args) {

        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    /**
     * 如果secret出现一次某个数字，该位置就自增1，
     * 如果此时该位置小于0，就说明这个数字在guess出现过，因此cows就自增1
     * ；guess的处理和secret类似，区别就是index对应元素需要自减。
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) {

        int bull = 0;
        int cow = 0;

        int[] temp = new int[10];

        int len = secret.length();
        for (int i = 0; i < len; i++) {

            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bull++;
            } else {

                if (temp[s] < 0) {
                    cow++;
                }
                if (temp[g] > 0) {
                    cow++;
                }
                temp[s]++;
                temp[g]--;
            }
        }
        return bull + "A" + cow + "B";
    }
}
