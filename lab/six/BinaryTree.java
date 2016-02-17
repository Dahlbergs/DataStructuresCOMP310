package lab.six;

import java.util.*;

public class BinaryTree<T extends Comparable<? super T>> implements IBinaryTree<T> {
    
    private IBinaryNode<T> root;
    
    //Default constructor
    public BinaryTree() {
	root = null;
    }

    // Ctor assigns given data to root member variable 
    public BinaryTree(T rootData) {
	root = new BinaryNode<T>(rootData);
    }

    //Ctor assigns given data to root member variable, as well as left and right subtrees.
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
	setTree(rootData, leftTree, rightTree);
    }

    public T getRootData() {
	T rootData = null;
	
	if(root != null) { rootData = root.getData(); }

	return rootData;
    }

    public IBinaryNode<T> getRootNode() { return root; }

    public int getHeight() { return root.getHeight(); }    
    public int getNumberOfNodes() { return root.getNumberOfNodes(); }

    protected void setRootData(T rootData) { root.setData(rootData); } // end setRootData
    protected void setRootNode(BinaryNode<T> rootNode) { root = rootNode; } // end setRootNode

    // Taken from book, calls private addEntry if root node is not null
    public T add(T newEntry) {
	
	T result = null;

	if(isEmpty()) {
	    System.out.println("Adding root node");
	    setRootNode(new BinaryNode<T>(newEntry));
	} else {
	    System.out.println("Adding child node");
	    result = addEntry(getRootNode(), newEntry);
	}
	return result;
    }

    // Add null by checking individual nodes for left and right child. If left child is null,
    // set that nodes data to the given entry. if right node is null and left node is not null, set
    // right node's data to given. Else move down left node'd tree and repeat.
    private T addEntry(IBinaryNode<T> rootNode, T newEntry) {
	System.out.println("Add entry");
	assert rootNode != null;
	T result = null;
	int comparison = newEntry.compareTo(rootNode.getData());

	if (comparison == 0) {
	    System.out.println("Comparison for 0");
	    result = rootNode.getData();
	    rootNode.setData(newEntry);
	} else if (comparison < 0) {
	    System.out.println("Comparison for < 0");
	    if(rootNode.hasLeftChild()) {
		System.out.println("Root has left child");
		result = addEntry((BinaryNode<T>)rootNode.getLeftChild(), newEntry);
	    } else {
		rootNode.setLeftChild(new BinaryNode<T>(newEntry));
	    }
	} else {
	    System.out.println("Comparison > 0");
	    assert comparison > 0;

	    if(rootNode.hasRightChild()) {
		result = addEntry((BinaryNode<T>)rootNode.getRightChild(), newEntry);
	    } else {
		rootNode.setRightChild(new BinaryNode<T>(newEntry));
	    }
	}
	return result;
    }

    //If root is null, the tree is empty
    public boolean isEmpty() {
	return root == null;
    }

    // Set root to null to clear tree. Java garbage collection handles cleanup
    public void clear() {
	root = null;
		
    }

    //Only InorderIterator has been implemented, the rest will throw a null pointer exception
    public Iterator<T> getPreorderIterator()   { return null; } 
    public Iterator<T> getPostorderIterator()  { return null; } 
    public Iterator<T> getInorderIterator()    { return new InorderIterator(); }
    public Iterator<T> getLevelOrderIterator() { return null; } 

    //Set the tree using the more general implementation of a setTree
    public void setTree(T rootData) {
	root = new BinaryNode<T>(rootData);
    }

    //Set the new tree with the data, left and right trees.
    public void setTree(T rootData, IBinaryTree<T> leftTree, IBinaryTree<T> rightTree) {
	privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
    }

    
    private void privateSetTree(T rootData, IBinaryTree<T> leftTree, IBinaryTree<T> rightTree) {
	if(leftTree != null) {
	    BinaryTree<T> left = (BinaryTree<T>)leftTree;
	    root.setLeftChild(left.getRootNode());
	}

	if(rightTree != null) {
	    BinaryTree<T> right = (BinaryTree<T>)rightTree;
	    root.setRightChild(right.getRootNode());
	}
    }

    // Not tested yet
    public IBinaryNode<T> copy() {
	BinaryNode<T> newRoot = new BinaryNode<T>(getRootData());
	if (root.getLeftChild() != null)
	    newRoot.setLeftChild(root.getLeftChild().copy());
	if (root.getRightChild() != null)
	    newRoot.setRightChild(root.getRightChild().copy());
	return newRoot;
    }

    //Private iterator allows direct access to the trees elements
    private class InorderIterator implements Iterator<T> {
	private Stack<IBinaryNode<T>> nodeStack;
	private IBinaryNode<T> currentNode;

	//Default ctor
	public InorderIterator() {
	    nodeStack = new Stack<IBinaryNode<T>>();
	    currentNode = root;
	}

	//checks if iterator has next node by checking existance of left and right nodes.
	public boolean hasNext() {
	    return !nodeStack.isEmpty() || (currentNode != null);
	}

	// Return the next node in the traversal
	public T next() {
	    IBinaryNode<T> nextNode = null;

	    while(currentNode != null) {
		nodeStack.push(currentNode);
		currentNode = currentNode.getLeftChild();
	    }

	    if(!nodeStack.isEmpty()) {
		nextNode = nodeStack.pop();
		assert nextNode != null;

		currentNode = nextNode.getRightChild();
	    } else {
		throw new NoSuchElementException();
	    }

	    return nextNode.getData();
	}

	// In this implementation, the tree does not allow for removal of
	// nodes. Therefor throw exception if called.
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    public static void main(String[] args) {
	BinaryTree<Character> characters = new BinaryTree<Character>();


	// Characters are being initialized
	Character newChar1 = new Character('A');
	Character newChar2 = new Character('B');
	Character newChar3 = new Character('C');
	Character newChar4 = new Character('D');
	Character newChar5 = new Character('E');
	Character newChar6 = new Character('F');
	Character newChar7 = new Character('G');
	Character newChar8 = new Character('H');
	Character newChar9 = new Character('I');
	Character newChar10 = new Character('K');
	Character newChar11 = new Character('J');
	Character newChar12 = new Character('L');
	Character newChar13 = new Character('M');
	Character newChar14 = new Character('N');
	
	//Characters are added at random to the tree
	characters.add(newChar1);
	characters.add(newChar4);
	characters.add(newChar2);	
	characters.add(newChar6);
	characters.add(newChar7);
	characters.add(newChar8);
	characters.add(newChar3);
	characters.add(newChar9);
	characters.add(newChar5);
	characters.add(newChar10);
	characters.add(newChar14);
	characters.add(newChar12);
	characters.add(newChar11);
	characters.add(newChar13);


	//Create copy of tree
	IBinaryTree<Character> copyCharacters = characters.copy();

	//Create a new inorder iterator, which iterates from lowest to highest value
	Iterator<Character> inorder = characters.getInorderIterator();	



	System.out.println("Traversing in inorder");
	
	//Loop prints the next value in the traversal so long as there is a next value
	while(inorder.hasNext()) {
	    System.out.println("Node: " + inorder.next());
	}
	
	//Print the height and number of nodes, to show the tree is working
	System.out.println("Tree Height: " + characters.getHeight());
	System.out.println("Num of Nodes: " + characters.getNumberOfNodes());
	
	
    }


}
