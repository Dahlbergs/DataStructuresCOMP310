package lab.six;

public interface IBinaryNode<T> {

    /** Retrieve data portion of node.
	@return The object in data portion of node */
    public T getData();

    /** Set data portion of node.
	@param newData The data object. */
    public void setData(T newData);

    /** Retrieve left child node.
	@return Left child node */
    public IBinaryNode<T> getLeftChild();

    /** Retrieve right child node.
	@return Right child node */
    public IBinaryNode<T> getRightChild();

    /** Set left child node 
	@param leftChild Node to be left child */
    public void setLeftChild(IBinaryNode<T> leftChild);

    /** Set right child node 
	@param rightChild Node to be right child */
    public void setRightChild(IBinaryNode<T> rightChild);

    /** Detect if node has left child node
	@return True if node as left child node */
    public boolean hasLeftChild();

    /** Detect if node has right child node
	@return True if node as right child node */
    public boolean hasRightChild();

    /** Detects if node is a leaf
	@return True if node is a leaf */
    public boolean isLeaf();

    /** Counts the nodes in subtree rooted at this node.
     @return Number of nodes in subtree rooted at this node */
    public int getNumberOfNodes();

    /** Computes height of subtree rooted at this node
     @return Height of subtree rooted at this node*/
    public int getHeight();

    /** Copies subtree rooted at this node
	@return the height of the subtree rooted at this node */
    public IBinaryNode<T> copy();

}
