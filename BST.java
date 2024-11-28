client(){
	new BST();
	Key floorKey = BST.floor(key);
	int size = BST.size();
}
public int size(){
	return size(root);
}
private int size(Node x){
	if(x==null) return 0;
	else return x.N;
}

public Key floor(Key key){
	Key res = floor(root, key);
	return res!=null?res:null;
}
private Node floor(Node x, Key key){
	if(x==null) return null;

	int compare = key.compareto(x.key);
	if(compare ==0) return x;
	if(compare < 0) return floor(x.left,key);
	//if compare>0, Node might in right tree(floor too), or x;
	Node t = floor(x.right,key);
	if(t!=null) return t;
	else return x;
}
/*select key of No.k*/
Key select(int k){
	return select(root,k).key;
}
private Node select(Node x, int k){
	if(x==null) return null;
	int n = size(x.left);
	if(n==k) return x;
	else if(k<n) return select(x.left,k);
	else if(k>n) return select(x.right,k-n-1);
}
/*return rank of k*/
int rank(Key k){
	return rank(root,k);
}
int rank(Node x, Key k){
	if(x==null) return 0;
	int cmp = k.compareto(x.key);
	if(cmp==0) return size(x.left);
	else if(cmp<0) return rank(x.left, k);
	else if(cmp>0) return size(x.left) + rank(x.right, k) + 1;
}


private void print(Node x){
	if(x==null) return;
	print(x.left);
	System.out.println(x.key);
	print(x.right);
}
/*return specified range of keys*/
public Iterable<Key> keys(){
	return keys(min(),max());
}
private Iterable<Key> keys(Key lo, Key hi){
	Queue<Key> q = new Queue<>();
	keys(root,queue,lo,hi);
	return queue;
}
private void keys(Node x, Queue<Key> q, Key lo, Key hi){
	comparelo = lo.compareto(x.key);
	comparehi = hi.compareto(x.key);
	if(comparelo<0) keys(x.left, q, lo, hi);
	if(comparelo<=0 && comparehi>=0) q.enqueue(x.key);
	if(comparehi>0) keys(x.right, q, lo, hi);
}