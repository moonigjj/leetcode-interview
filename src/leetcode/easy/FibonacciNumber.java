package leetcode.easy;

public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(fib(2));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int temp1 = 0;
        int temp2 = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++){
            sum = temp1 + temp2;
            temp1 = temp2;
            temp2 = sum;
        }
        return sum;
    }
}
