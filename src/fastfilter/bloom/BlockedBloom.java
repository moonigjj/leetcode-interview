/**
 * chenxitech.cn Inc. Copyright (c) 2017-2020 All Rights Reserved.
 */
package fastfilter.bloom;

import fastfilter.Filter;
import fastfilter.utils.Hash;

/**
 * A special kind of blocked Bloom filter. It sets 2 to 4 (usually 4) bits in
 * two 64-bit words; 1 or 2 (usually 2) per word. It is faster than a regular
 * Bloom filter, but needs slightly more space / has a slightly worse false
 * positive rate.
 */
public class BlockedBloom implements Filter {

    private final int buckets;
    private final long seed;
    private final long[] data;

    BlockedBloom(int entryCount, int bitsPerKey) {
        // bitsPerKey = 11;
        entryCount = Math.max(1, entryCount);
        this.seed = Hash.randomSeed();
        long bits = (long) entryCount * bitsPerKey;
        this.buckets = (int) bits / 64;
        this.data = new long[buckets + 16 + 1];
    }

    public static BlockedBloom construct(long[] keys, int bitsPerKey) {
        int n = keys.length;
        BlockedBloom f = new BlockedBloom(n, bitsPerKey);
        for (long x : keys){
            f.add(x);
        }
        return f;
    }

    /**
     * Whether the set may contain the key.
     *
     * @param key the key
     * @return true if the set might contain the key, and false if not
     */
    @Override
    public boolean mayContain(long key) {
        long hash = Hash.hash64(key, seed);
        int start = Hash.reduce((int) hash, buckets);
        hash = hash ^ Long.rotateLeft(hash, 32);
        long a = data[start];
        long b = data[start + 1 + (int) (hash >>> 60)];
        long m1 = (1L << hash) | (1L << (hash >> 6));
        long m2 = (1L << (hash >> 12)) | (1L << (hash >> 18));
        return ((m1 & a) == m1) && ((m2 & b) == m2);
    }

    /**
     * Get the number of bits in the filter
     *
     * @return the number of bits
     */
    @Override
    public long getBitCount() {
        return this.data.length * 64L;
    }

    @Override
    public boolean supportsAdd() {
        return true;
    }

    @Override
    public void add(long key) {
        long hash = Hash.hash64(key, this.seed);
        int start = Hash.reduce((int) hash, this.buckets);
        hash = hash ^ Long.rotateLeft(hash, 32);
        long m1 = (1L << hash) | (1L << (hash >> 6));
        long m2 = (1L << (hash >> 12)) | (1L << (hash >> 18));
        data[start] |= m1;
        data[start + 1 + (int) (hash >>> 60)] |= m2;
    }
}
