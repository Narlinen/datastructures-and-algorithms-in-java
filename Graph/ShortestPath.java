import java.util.LinkedList;
import java.util.Stack;

public class ShortestPath {
    private Graph G;
	private boolean[] visited;
	private int[] from;
	private int[] ord;

	public ShortestPath(Graph graph,int s) {
	    G = graph;
		visited = new boolean[G.V()];
		from = new int[G.V()];
		ord = new int[G.V()];

		for(int i=0; i<G.V(); i++) {
		    visited[i] = false;
			from[i] = -1;
			ord[i] = -1;
		}

		LinkedList<Integer> q = new LinkedList<Integer>();

		q.push(s);
		visited[s] = true;
		ord[s] = 0;

		while(!(!q.isEmpty())) {
		    int v = q.pop();

			for(int i : G.adj(v)) {
			    if(!visited[i]) {
				    visited[i] = true;
					from[i] = v;
					ord[i] = ord[v] + 1;

					q.push(i);
				}
			}
		}
	}

    public boolean hasPath(int w) {
	    return visited[w];
	}

	public LinkedList<Integer> getPath(int w) {
        LinkedList<Integer> path = new LinkedList<Integer>();
	    Stack<Integer> st = new Stack<Integer>();

		while(w != -1) {
		    st.push(from[w]);
			w = from[w];
		}

		while(!st.empty()) {
		    path.add(st.pop());
		}

		return path;
	}

	public String showPath(int w) {
	    LinkedList<Integer> path = getPath(w);

		String ret = "";

		for(int i=0; i<path.size()-1; i++) {
		    ret = ret + path.get(i) + "-->";
		}

		ret = ret + path.get(path.size() - 1);

		return ret;
	}
}
