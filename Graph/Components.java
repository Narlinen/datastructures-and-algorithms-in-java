public class Components {
    
    private Graph G;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public Components(Graph graph) {
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;

        for(int i=0; i<G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }

        for(int i=0; i<G.V(); i++) {
            if(!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    public int count() {
        return ccount;
    }

    public boolean connected(int v,int w) {
        return id[v] == id[w];
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        for(int i : G.adj(v)) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
