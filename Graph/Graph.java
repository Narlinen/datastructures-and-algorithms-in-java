public interface Graph {
    public void addEdge(int v,int w);
    public boolean hasEdge(int v,int w);
    public void removeEdge(int v,int w);
    public int V();
    public int E();
    public Iterable<Integer> adj(int v);
}
