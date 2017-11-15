public class UnionFindQuickUnionSize {
	private int[] parent;
	private int[] size;
	private int n;

	public UnionFindQuickUnionSize(int n) {
		this.n = n;
		parent = new int[n];
		size = new int[n];

		for(int i=0; i<n; i++) {
			parent[i] = i;
			size[i] = 1;
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

		if(vRoot == wRoot) return;

		if(size[vRoot] > size[wRoot]) {
			parent[wRoot] = vRoot;
			size[vRoot] += size[wRoot];
		} else {
			parent[vRoot] = wRoot;
			size[wRoot] += size[vRoot];
		}
	}
}