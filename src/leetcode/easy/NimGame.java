/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package leetcode.easy;

/**
 * 292 Nim Game
 * @author tangyue
 * @version $Id: NimGame.java, v 0.1 2019-09-04 10:26 tangyue Exp $$
 */
public class NimGame {

    public static void main(String[] args) {

    }

    /**
     * 规律就是当有4,8,12,16....4n...时，我一定输；其他情况我一定赢。
     *
     * 因为当为4n时，我拿后剩下4n-1,4n-2,4n-3块，对方可以拿到4n-4=4(n-1)块。然后我再拿，对方再拿到4(n-2)块。。无论我怎么拿，对方总能拿到最后剩下4块。。。这样我就输了。
     *
     * 同理，不为4n时，我总能拿到4n，这样对方就输了
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
