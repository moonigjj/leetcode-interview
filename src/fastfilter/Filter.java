/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package fastfilter;

/**
 * An approximate membership filter.
 * @author tangyue
 * @version $Id: Filter.java, v 0.1 2019-12-31 11:20 tangyue Exp $$
 */
public interface Filter {

    /**
     * Whether the set may contain the key.
     * @param key the key
     * @return true if the set might contain the key, and false if not
     */
    boolean mayContain(long key);

    /**
     * Get the number of bits in the filter
     * @return the number of bits
     */
    long getBitCount();

    /**
     * Whether the add operation (after construction) is supported.
     * @return
     */
    default boolean supportsAdd(){
        return false;
    }

    /**
     * Add a key.
     * @param key the key
     */
    default void add(long key){
        throw new UnsupportedOperationException();
    }

    /**
     * Whether the remove operation is supported.
     * @return true if yes
     */
    default boolean supportsRemove() {
        return false;
    }

    /**
     * Remove a key.
     *
     * @param key the key
     */
    default void remove(long key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get the number of set bits. This should be 0 for an empty filter.
     *
     */
    default long cardinality() {
        return -1;
    }
}
