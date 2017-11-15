public class UnionFindQuickUnion {
	private int[] parent;
	private int n;

	public UnionFindQuickUnion(int n) {
		this.n = n;
		parent = new int[n];

		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
	}

	public int find(int v) {
		while(v != parent[v]) {
			v = parent[v];
		}

		return v;
	}

	public boolean isConnected(int v,int w) {
		return find(v) == find(w);
	}

	public void union(int v,int w) {
		int vRoot = find(v);
		int wRoot = find(w);

		parent[vRoot] = wRoot;
	}
}