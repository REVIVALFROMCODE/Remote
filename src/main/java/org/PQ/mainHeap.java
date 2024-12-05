class Solution {
    public int kthSmallest(TreeNode root, int k) {
        /*solution 1 :
            Kth smallest element 

            max heap with size k, implement heap with array, 2*k and 2*k+1 is childrens, k/2 is father.

        */
        heap h = new heap(k);
        pushTree(root,h);
        return h.delMax();
    }
    private void pushTree(TreeNode root, heap h){
        if(root==null) return;
        h.push(root.val);
        pushTree(root.left,h);
        pushTree(root.right,h);
    }

    private class heap{
        int val[];
        int N;//insert N++, remove --N;
        heap(int capacity){
            val = new int[capacity+1];
            N=1;
        }
        void exch(int i, int j){
            int temp = val[j];
            val[j] = val[i];
            val[i] = temp;
        }
        boolean less(int i, int j){
            return val[i]<val[j];
        }
        void swim(int n){
            int fIndex = n/2;

            while(fIndex>=1){
                if(less(fIndex,n)){ //root is the biggest, if father less than current, exchange.
                    exch(fIndex,n);
                }else break;
                n=fIndex;
                fIndex=n/2;
            }
        }
        void push(int x){
            if(N==val.length) {
                delMax();
            }

            val[N] = x;
            
            swim(N);

            N++;
        }
        void sink(int n){
            int cIndex = 2*n;
            while(cIndex<=N){
                if(less(n,cIndex)){ //violate max heap order
                    if(less(cIndex,cIndex+1)) cIndex=cIndex+1;
                    if(val[cIndex]==-1) break; //loiter
                    exch(cIndex,n);
                }else break;
                n = cIndex;
                cIndex = 2*n;
            }
        }
        int delMax(){
            int res = val[1];
            exch(1,N-1);//N points to out of bound when heap is full
            val[N-1] = -1;//loiter
            sink(1);
            N--;
            //val[N] = null;
            return res;
        }
    }
}
