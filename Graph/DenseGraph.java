import java.util.LinkedList;

public class DenseGraph implements Graph {
    private int n;
	private int m;
	private boolean directed;
	private boolean[][] g;

	public DenseGraph(int n,boolean directed) {
	    this.n = n;
		this.directed = directed;
		this.m = 0;
		g = new boolean[n][n];
	}

	public int V() { return n; }
	public int E() { return m; }

	public void addEdge(int v,int w) {
	    g[v][w] = true;
		if(!directed) {
		    g[w][v] = true;
		}
	}

	public boolean hasEdge(int v,int w) {
	    return g[v][w];
	}

	public void removeEdge(int v,int w) {
	    g[v][w] = false;
		if(!directed) {
		    g[w][v] = false;
		}
	}

	public Iterable<Integer> adj(int v) {
	    LinkedList<Integer> adjList = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
		    if(g[v][i]) {
                adjList.add(i);
            }
		}
		return adjList;
	}

    @Override
    public String toString() {
	    String ret = "";

		for(int i=0; i<n; i++) {
		    for(int j=0; j<n-1;j++) {
			    ret = ret + g[i][j] + " ";
			}
			ret = ret + g[i][n-1] + "\n";
		}

		return ret;
	}
}
