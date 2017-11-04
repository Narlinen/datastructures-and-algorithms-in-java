import java.util.LinkedList;

public class BST<K extends Comparable<K>,V> {
    private class Node {
	    K key;
		V value;
		Node left;
		Node right;

		public Node(K key,V value) {
		    this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public Node(Node node) {
		    key = node.key;
			value = node.value;
			left = node.left;
			right = node.right;
		}
	}

	private Node root;
	private int count;

	public BST() {
	    root = null;
		count = 0;
	}

	public int size() {
	    return count;
	}

	public boolean empty() {
	    return count == 0;
	}

	public void insert(K key,V value) {
	    root = insert(root,key,value);
	}

	public void remove(K key) {
	    root = remove(root,key);
	}

	public boolean contain(K key) {
	    return contain(root,key);
	}

	public V search(K key) {
	    Node node = search(root,key);
		return node == null ? null : node.value;
	}

	public void preOrder() {
	    preOrder(root);
	}

	public void inOrder() {
	    inOrder(root);
	}

	public void postOrder() {
	    postOrder(root);
	}

	public void levelOrder() {
	    LinkedList<Node> q = new LinkedList<Node>();

		q.add(root);

		while(!q.isEmpty()) {
		    Node node = q.remove();

			System.out.print(node.key);

			if(node.left != null)
				q.add(node.left);
		    if(node.right != null)
				q.add(node.right);
		}
	}

	public K minimum() {
	    Node minNode =  minimum(root);
		return minNode.key;
	}

	public K maximum() {
	    Node maxNode = maximum(root);
		return maxNode.key;
	}

	public void removeMin() {
		if(root != null)
	        root = removeMin(root);
	}

	public void removeMax() {
	    if(root != null)
		    root = removeMax(root);
	}

	public Node predecessor(K key) {
	    Node node = search(root,key);

		if(node == null) {
		    return null;
		}

		if(node.left != null) {
		    return maximum(node.left);
		}

		Node preNode = predecessorFromAncestor(root,key);
		return preNode == null ? null : preNode;
	}

	public Node successor(K key) {
	    Node node = search(root,key);

		if(node == null) {
		    return null;
		}

		if(node.right != null) {
		    return minimum(node.right);
		}

		Node sucNode = successorFromAncestor(root,key);
		return sucNode == null ? null : sucNode;
	}

	private Node insert(Node node,K key,V value) {
	    if(node == null) {
			count++;
		    return new Node(key,value);
		}

		if(key.compareTo(node.key) == 0) {
            node.value = value;
		} else if(key.compareTo(node.key) < 0) {
		    node.left = insert(node.left,key,value);
		} else {
		    node.right = insert(node.right,key,value);
		}

		return node;
	}

	private Node remove(Node node,K key) {
	    if(node == null) {
			return null;
		}

		if(key.compareTo(node.key) == 0) {

		    if(node.left == null) {
			    Node rightNode = node.right;
                node.right = null;
                count--;
				return rightNode;
			}

			if(node.right == null) {
			    Node leftNode = node.left;
				node.left = null;
				count--;
				return leftNode;
			}
            
			Node successor = new Node(minimum(node.right));

			successor.right = removeMin(node.right);
			successor.left = node.left;

			return successor;

		} else if(key.compareTo(node.key) < 0) {
		    node.left = remove(node.left,key);
			return node;
		} else {
		    node.right = remove(node.right,key);
			return node;
		}
	}

	private boolean contain(Node node,K key) {
	    if(node == null) {
		    return false;
		}

        if(key.compareTo(node.key) == 0) {
		    return true;
		} else if(key.compareTo(node.key) < 0) {
		    return contain(node.left,key);
		} else {
		    return contain(node.right,key);
		}
	}

	private Node search(Node node,K key) {
	    if(node == null) {
		    return null;
		}

		if(key.compareTo(node.key) == 0) {
		    return node;
		} else if(key.compareTo(node.key) < 0) {
		    return search(node.left,key);
		} else {
		    return search(node.right,key);
		}
	}

	private void preOrder(Node node) {
	    if(node == null) {
		    return;
		}

		System.out.println(node.value);
        preOrder(node.left);
		preOrder(node.right);
	}

	private void inOrder(Node node) {
	    if(node == null) {
		    return;
		}

		inOrder(node.left);
        System.out.println(node.value);
		inOrder(node.right);
	}

	private void postOrder(Node node) {
	    if(node == null) {
		    return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}

	private Node minimum(Node node) {
        if(node == null) {
		    return null;
		}

	    if(node.left == null) {
            return node;
		}

		return minimum(node.left);
	}

	private Node maximum(Node node) {
	    if(node == null) {
		    return null;
		}

		if(node.right == null) {
		    return node;
		}

		return maximum(node.right);
	}

	private Node removeMin(Node node) {
	    if(node.left == null) {
		    Node rightNode = node.right;
			node.right = null;
			count--;
			return rightNode;
		}

		node.left = removeMin(node.left);
		return node;
	}

	private Node removeMax(Node node) {
	    if(node.right == null) {
		    Node leftNode = node.left;
			node.left = null;
			count--;
			return leftNode;
		}

		node.right = removeMax(node.right);
		return node;
	}

	private Node predecessorFromAncestor(Node node,K key) {
	    if(key.compareTo(node.key) == 0) {
		    return null;
		}

		Node maxNode;

		if(key.compareTo(node.key) < 0) {
		    return predecessorFromAncestor(node.left,key);
		} else {
		    maxNode = predecessorFromAncestor(node.right,key);
			if(maxNode != null) {
			    return maxNode; 
			} else {
			    return node;
			}
		}
	}

	private Node successorFromAncestor(Node node,K key) {
	    if(key.compareTo(node.key) == 0) {
		    return null;
		}

		Node minNode;
		if(key.compareTo(node.key) > 0) {
		    return successorFromAncestor(node.right,key);
		} else {
		    minNode = successorFromAncestor(node.left,key);
			if(minNode != null) {
			    return minNode;
			} else {
			    return node;
			}
		}
	}
}
