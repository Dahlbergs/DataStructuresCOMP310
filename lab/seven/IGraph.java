package lab.seven;

public interface IGraph<T> extends IGraphAlgorithms<T> {
    
   public boolean addVertex(T vertex);

   public boolean addEdge(T begin, T end, double edgeWait);

   public boolean addEdge(T begin, T end);

   public boolean hasEdge(T begin, T edge);

   public boolean isEmpty();

   public int getNumberOfVertices();

   public int getNumberOfEdges();
   
   public void clear();

}
