/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package fastfilter.utils;

/**
 *
 * @author tangyue
 * @version $Id: StringUtils.java, v 0.1 2019-12-31 13:08 tangyue Exp $$
 */
public final class StringUtils {

    private static final int[] HEX_DECODE = new int['f' + 1];

    static {
        for (int i = 0, len = HEX_DECODE.length; i < len; i++){
            HEX_DECODE[i] = -1;
        }
        for (int i = 0; i <= 9; i++){
            HEX_DECODE[i + '0'] = i;
        }
        for (int i = 0; i <= 5; i++){
            HEX_DECODE[i + 'a'] = HEX_DECODE[i + 'A'] = i + 10;
        }
    }

    public static int getHex(char c) {
        return HEX_DECODE[c];
    }
}
