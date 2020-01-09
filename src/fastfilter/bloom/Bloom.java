/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package fastfilter.bloom;

import fastfilter.Filter;
import fastfilter.utils.Hash;

/**
 * A standard Bloom filter
 * @author tangyue
 * @version $Id: Bloom.java, v 0.1 2019-12-31 13:17 tangyue Exp $$
 */
public class Bloom implements Filter {

    private final int k;
    private final long bits;
    private final long seed;
    private final int arraySize;
    private final long[] data;

    Bloom(int entryCount, double bitsPerKey, int k) {
        entryCount = Math.max(1, entryCount);
        this.k = k;
        this.seed = Hash.randomSeed();
        this.bits = (long) (entryCount * bitsPerKey);
        this.arraySize = (int) ((this.bits + 63) / 64);
        this.data = new long[this.arraySize];
    }

    private static int getBestK(double bitsPerKey) {
        return Math.max(1, (int) Math.round(bitsPerKey * Math.log(2)));
    }


    /**
     * Whether the set may contain the key.
     *
     * @param key the key
     * @return true if the set might contain the key, and false if not
     */
    @Override
    public boolean mayContain(long key) {
        long hash = Hash.hash64(key, this.seed);
        int a= (int) (hash >>> 32);
        int b = (int) hash;
        for (int i = 0; i < this.k; i++){
            if ((data[Hash.reduce(a, arraySize)] & 1L << a) == 0) {
                return false;
            }
            a += b;
        }
        return true;
    }

    /**
     * Get the number of bits in the filter
     *
     * @return the number of bits
     */
    @Override
    public long getBitCount() {
        return data.length * 64L;
    }

    @Override
    public boolean supportsAdd() {
        return true;
    }

    @Override
    public void add(long key) {
        long hash = Hash.hash64(key, this.seed);
        int a= (int) (hash >>> 32);
        int b = (int) hash;
        for (int i = 0; i < this.k; i++){
            this.data[Hash.reduce(a, this.arraySize)] |= 1L << a;
            a += b;
        }
    }
}
