/*
 * Javolution - Java(TM) Solution for Real-Time and Embedded Systems
 * Copyright (C) 2012 - Javolution (http://javolution.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package javolution.util.service;

import javolution.lang.Predicate;
import javolution.util.FastBitSet;
import javolution.util.FastTable;
import javolution.util.Index;

/**
 * The set of related functionalities which can be used/reused to 
 * implement bit-sets collections.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 6.0.0, December 12, 2012
 * @see FastTable
 */
public interface BitSetService {
     
    //
    // Read Accessors.
    //

    /** See {@link FastBitSet#cardinality() } */
    int cardinality();

    /** See {@link FastBitSet#get(int) } */
    boolean get(int bitIndex);

    /** See {@link FastBitSet#get(int, int) } */
    BitSetService get(int fromIndex, int toIndex);

    /** See {@link FastBitSet#intersects(FastBitSet) } */
    boolean intersects(BitSetService that);

    /** See {@link FastBitSet#length() } */
    int length();

    //
    // Iterations
    //

    /** See {@link FastBitSet#nextClearBit(int) } */
    int nextClearBit(int fromIndex);
    
    /** See {@link FastBitSet#nextSetBit(int) } */
    int nextSetBit(int fromIndex);

    /** See {@link FastBitSet#doWhile(Predicate) } */
    void doWhile(Predicate<Index> predicate);

    /** See {@link FastBitSet#removeAll(Predicate) } */
    boolean removeAll(Predicate<Index> predicate);

    //
    // Clear/Set/Flip Operations
    //

    /** See {@link FastBitSet#clear() } */
    void clear();
    
    /** See {@link FastBitSet#clear(int) } */
    void clear(int bitIndex);

    /** See {@link FastBitSet#clear(int, int) } */
    void clear(int fromIndex, int toIndex);
    
    /** Clear or sets the specified bit, returns <code>true</code> 
     * if previously set; <code>false</code> otherwise. */
    boolean getAndSet(int bitIndex, boolean value);
    
    /** See {@link FastBitSet#set(int) } */
    void set(int bitIndex);

    /** See {@link FastBitSet#set(int, boolean) } */
    void set(int bitIndex, boolean value);

    /** See {@link FastBitSet#set(int, int) } */
    void set(int fromIndex, int toIndex);
    
    /** See {@link FastBitSet#set(int, int, boolean) } */
    void set(int fromIndex, int toIndex, boolean value);

    /** See {@link FastBitSet#flip(int) } */
    void flip(int bitIndex);

    /** See {@link FastBitSet#flip(int, int) } */
    void flip(int fromIndex, int toIndex);
    
    //
    // Logical Operations
    //

    /** See {@link FastBitSet#and(FastBitSet) } */
    void and(BitSetService that);

    /** See {@link FastBitSet#andNot(FastBitSet) } */
    void andNot(BitSetService that);

    /** See {@link FastBitSet#or(FastBitSet) } */
    void or(BitSetService that);

    /** See {@link FastBitSet#xor(FastBitSet) } */
    void xor(BitSetService that);
    
     //
     // Misc.
     //
    
    /** Returns the <code>long[]</code> representation of this bitset 
     * (new array) */
    long[] toLongArray();
                  
}
