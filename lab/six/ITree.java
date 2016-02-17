package lab.six;

public interface ITree<T> {
    public T getRootData();

    public int getHeight();

    public int getNumberOfNodes();
    
    public boolean isEmpty();

    public void clear();
}
