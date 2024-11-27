package org.Stack;

public class ResizingArrayStack {
    private String[] s;
    private int N = 0;

    public ResizingArrayStack(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }
}



