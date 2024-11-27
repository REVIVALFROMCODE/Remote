package org.ST;

public abstract class ST<Key,Value> {
    /*
    put k-v
     */
    abstract void put(Key key, Value value);
    /*
    return value of key
     */
    abstract Value get(Key key);
    /*
    delete k-v record
     */
    void delete(Key key){
        put(key,null);
    }
    /*
    does k-v exist
     */
    boolean contains(Key key){
        return get(key)!=null;
    }
    /*
    is table empty
     */
    boolean isEmpty(){
        return size()==0;
    }
    /*
    size of k-v records
     */
    abstract int size();
    /*
    Iterate via key
     */
    abstract Iterable<Key> keys();
}
