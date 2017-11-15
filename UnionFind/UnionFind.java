public class UnionFind {
    private int[] rank;
    private int[] parent;

    public UnionFind(int count) {
        rank = new int[count];
        parent = new int[count];

        for(int i=0; i<count; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    private int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    public void union(int p,int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) {
            return;
        }

        if(pRoot > qRoot) {
            parent[qRoot] = pRoot;
        } else if(pRoot < qRoot) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
