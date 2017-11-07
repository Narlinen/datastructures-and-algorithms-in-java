public class Path {
    private Graph G;
	private boolean[] visited;
	private int[] from;

	public Path(Graph graph,int s) {
	    G = graph;
		visited = new boolean[G.V()];
		from = new int[G.V()];

		for(int i=0; i<G.V(); i++) {
		    visited[i] = false;
			from[i] = -1;
		}

		dfs(s);
	}

	private void dfs(int v) {
	    visited[v] = true;

		for(int i : G.adj(v)) {
		    if(!visited[i]) {
			    from[i] = v;
				dfs(i);
			}
		}
	}

	public boolean hasPath(int w) {
	    return visited[w];
	}
        
    public LinkedList<Integer> getPath(int w) {
        Stack<Integer> st = new Stack<Integer>();

        int p = w;
		while(p != -1) {
			st.push(p);
		    p = from[p];
		}

		LinkedList<Integer> res = LinkedList<Integer>();
		while(!st.isEmpty()) {
		    res.add(st.pop());
		}

		return res;
	}

	public String showString(int w) {
	    LinkedList<Integer> path = getPath(w);

		String ret = "";

		for(int i=0; i<path.size()-1; i++) {
		    ret = ret + path.get(i) + "-->";
		}

		ret = ret + path.get(path.size()-1) + "\n";

		return ret;
	}
}
