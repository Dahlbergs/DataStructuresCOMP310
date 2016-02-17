package lab.six;

class BinaryNode<T extends Comparable<? super T>> implements IBinaryNode<T> {

    private T data;
    private IBinaryNode<T> left;
    private IBinaryNode<T> right;

    public BinaryNode() {
	this(null);
    }

    public BinaryNode(T dataPortion) {
    	this(dataPortion, null, null);
    }

    public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
	data = dataPortion;
	left = leftChild;
	right = rightChild;
    }

    public T getData() { return data; }
    public void setData(T newData) { data = newData; }

    public IBinaryNode<T> getLeftChild() { return left; }
    public IBinaryNode<T> getRightChild() { return right; }
   
    public void setLeftChild(IBinaryNode<T> leftChild)    { left = leftChild; }
    public void setRightChild(IBinaryNode<T> rightChild)  { right = rightChild; }

    public boolean hasLeftChild() { return left != null; }
    public boolean hasRightChild() { return right != null; }

    public IBinaryNode<T> copy() {
	return null;
    }

    public int getNumberOfNodes() {
	int leftNumber = 0;
	int rightNumber = 0;

	if(left != null){
	    leftNumber = left.getNumberOfNodes();
	}

	if(right != null){
	    rightNumber = right.getNumberOfNodes();
	}

	return 1 + leftNumber + rightNumber;
    }
    
    public int getHeight() {
	return getHeight(this);

    }

    private int getHeight(IBinaryNode<T> node){
    	int height = 0;
	if(node != null){
	    height = 1 + Math.max(getHeight(node.getLeftChild()),
				  getHeight(node.getRightChild()));
	}
	return height;
    }
    
    public boolean isLeaf() {
	return (left == null) && (right == null);
    }

}
