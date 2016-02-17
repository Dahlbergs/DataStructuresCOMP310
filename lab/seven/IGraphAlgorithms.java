package lab.seven;

import lab.*;

public interface IGraphAlgorithms<T> {
    
    public IQueue<T> getBreadthFirstTraversal(T origin);

    public IQueue<T> getDepthFirstTraversal(T origin);

    public IStack<T> getTopologicalOrder();

    public int getShortestPath(T begin, T end, IStack<T> path);

    public double getCheapestPath(T begin, T end, IStack<T> path);

    
}
