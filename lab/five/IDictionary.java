package lab.five;

import java.util.Iterator;

public interface IDictionary<K, V> {

    public V add(K Key, V Value);

    public V remove(K key);

    public Iterator<K> getKeyIterator();

}
