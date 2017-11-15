public class UnionFindQuickFind {
	private int[] id;
	private int n;

	public UnionFindQuickFind(int n) {
		this.n = n;
        this.id = new int[n];

        for(int i=0; i<n; i++) {
        	id[i] = i;
        }
	}

	public int find(int v) {
		return id[v];
	}

	public boolean isConnected(int v,int w) {
		return find(v) == find(w);
	}

	public void union(int v,int w) {
		int vRoot =find(v);
		int wRoot = find(w);

		if(vRoot == wRoot) return;

		for(int i=0; i<n; i++) {
			if(id[i] == vRoot) {
				id[i] = wRoot;
			}
		}
	}
}