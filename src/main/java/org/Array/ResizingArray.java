package org.Array;

public class ResizingArray {
    private String[] s;
    private int N = 0;

    public ResizingArray() {
        s = new String[1];
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < s.length; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public void push(String item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public String pop() {
        if (N>0 && N == s.length / 4) resize(s.length / 2);
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
