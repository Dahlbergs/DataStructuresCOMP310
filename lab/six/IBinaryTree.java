package lab.six;

public interface IBinaryTree<T> extends ITree<T>, ITreeIterator<T> {

    /** Creates a new root node with the data given. No left or right child data is provided
     @param rootData The root node data portion*/
    public void setTree(T rootData);

    /** Creates a new root node with data given, and provides a left and right child tree 
	@param rootData The root node data portion
	@param leftTree Left tree to be added to the root node
	@param righTree Right tree to be added to the root node */
    public void setTree(T rootData, IBinaryTree<T> leftTree, IBinaryTree<T> rightTree);

    
}
