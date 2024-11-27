package org.ST;

import java.util.Comparator;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends ST<Key,Value>{
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
    }

    @Override
    void put(Key key, Value value) {

    }

    @Override
    Value get(Key key) {
        return null;
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    Iterable<Key> keys() {
        return null;
    }
}
