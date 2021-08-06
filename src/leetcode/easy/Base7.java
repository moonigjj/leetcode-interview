package leetcode.easy;

/**
 * 504. Base 7
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 */
public class Base7 {

    public static void main(String[] args) {
        System.out.println(Integer.toString(-7, 7));
        System.out.println(convertTo7(-7));
        System.out.println(convertTo7One(100));
    }

    public static String convertTo7One(int num) {

        StringBuffer sb = new StringBuffer("");
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = num * -1;
        }
        while (num != 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        if (flag) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
    /**
     * 递归
     * @param num
     * @return
     */
    public static String convertTo7(int num) {
        if (num < 0) {
            return '-' + convertTo7(-num);
        } else if (num < 7) {
            return num + "";
        }
        return convertTo7(num / 7) + num % 7;
    }
}
