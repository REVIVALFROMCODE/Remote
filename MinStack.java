class MinStack {
    private Node head;

    private class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        head = null;
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head == null) throw new IllegalStateException("Stack is empty");
        return head.value;
    }

    public int getMin() {
        if (head == null) throw new IllegalStateException("Stack is empty");
        return head.min;
    }
}
//Binary heap, can't implemengt pop()
class MinStack {
    int[] vals;
    int N;

    public MinStack() {
        vals=new int[4];
        N=1;
    }

    private boolean less(int i,int j){
        return vals[i]>vals[j];
    }
    
    private void exch(int i,int j){
        int temp=vals[i];
        vals[i]=vals[j];
        vals[j]=temp;
    }
    private void resize(int s){
        int[] dup = new int[s];
        for(int i=0;i<vals.length;i++){
            dup[i]=vals[i];
        }
        vals=dup;
    }
    public void push(int val) {
        if(N==vals.length) resize(2*vals.length);
        vals[N++] = val;
        swim(N-1);
    }
    private void swim(int k){
        while(k>1 && less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    public int pop() {
        int val = vals[--N]; 
        return val;
    }
    
    public int top() {
        return vals[N];
    }
    
    public int getMin() {
        int res = vals[1];
        exch(1,N-1);
        vals[N-1]=-1;
        sink(1);
        N--;
        return res;
    }
    private void sink(int k){
        int cIndex = 2*k;
        while(cIndex+1<N){
            if(less(k,cIndex) || less(k,cIndex+1)){
                if (less(cIndex,cIndex+1)) cIndex = cIndex+1;
                if (cIndex>N-1) break;
                exch(cIndex,k);
            }else break;
            k = cIndex;
            cIndex = 2*k;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
