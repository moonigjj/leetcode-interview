/**
 * chenxitech.cn Inc. Copyright (c) 2017-2018 All Rights Reserved.
 */
package adobe;

/**
 *Given a non-negative integer num,
 * repeatedly add all its digits until the result has only one digit.
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {

    /**
     *每9个一循环，所有大于9的数的树根都是对9取余，那么对于等于9的数对9取余就是0了，
     * 为了得到其本身，而且同样也要对大于9的数适用，我们就用(n-1)%9+1这个表达式来包括所有的情况
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 解法2，循环取余数
     * @param num
     * @return
     */
    public static int addDigits1(int num) {
        while(num >= 10) {
            int temp = 0;
            while(num > 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }

        return num;
    }

    public static void main(String[] args) {

        System.out.println(addDigits(38));

        System.out.println(System.currentTimeMillis());
    }
}
