package lab.six;

import java.util.Iterator;

public interface ITreeIterator<T> {

    public Iterator<T> getPreorderIterator();

    public Iterator<T> getPostorderIterator();

    public Iterator<T> getInorderIterator();

    public Iterator<T> getLevelOrderIterator();    

}
