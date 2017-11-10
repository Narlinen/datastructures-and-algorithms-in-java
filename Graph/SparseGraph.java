import java.util.LinkedList;

public class SparseGraph implements Graph{
    private int n;
    private int m;
    private boolean directed;
    private LinkedList<Integer>[] g;

    @SuppressWarnings("unchecked")
    public SparseGraph(int n,boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (LinkedList<Integer>[])new LinkedList[n];
        for(int i=0; i<n; i++) {
            g[i] = new LinkedList<Integer>();
        }
    }

    public int V() { return n; }
    public int E() { return m; }

    public void addEdge(int v,int w) {
        g[v].add(w);
        if(!directed) {
            g[w].add(v);
        }    
    }

    public boolean hasEdge(int v,int w) {
        for(int i=0; i<g[v].size(); i++) {
            if(g[v].get(i) == w) {
                return true;
            }
        }

        return false;
    }

    public void removeEdge(int v,int w) {
        for(int i=0; i<g[v].size();) {
            if(g[v].get(i) == w) {
                g[v].remove(i);
            } else {
                i++;
            }
        }

        if(!directed) {
            for(int i=0; i<g[w].size();) {
                if(g[w].get(i) == v) {
                    g[w].remove(i);
                } else {
                    i++;
                }
            }
        }
    }

    public Iterable<Integer> adj(int v) {
        return g[v];
    }

    @Override
    public String toString() {
        String ret = "";

        for(int i=0; i<n; i++) {
            ret = ret + i + " : ";
            for(int j=0; j<g[i].size(); j++) {
                ret = ret + g[i].get(j) + " ";
            }
            ret = ret + "\n";
        }

        return ret;
    }
}
