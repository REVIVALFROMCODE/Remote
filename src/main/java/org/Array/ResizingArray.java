package org.Array;

public class ResizingArray {
    String[] s;
    int N;

    public ResizingArray() {
        s = new String[1];
        N = s.length;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < s.length; i++) {
            copy[i] = s[i];
        }
        s = copy;
        N = s.length;
    }

    public void push(String item) {
        if (N == s.length) resize(2 * N);
        s[N++] = item;
    }

    public String pop() {
        if (N == s.length / 4) resize(N / 2);
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
