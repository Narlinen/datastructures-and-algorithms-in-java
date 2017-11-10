package narlinen.dsa.linkedlist;

public class LinkedList<T> {
    private class Node {
	    public T value;
		public Node prev;
		public Node next;
		public Node(T value,Node prev,Node next) {
		    this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}

	private int size;
	private Node head;
	private Node tail;

	public LinkedList() {
	    size = 0;
		head = new Node(null,null,null);
	    tail = new Node(null,null,null);
		head.next = tail;
		tail.prev = head;
	}

    public int size() {
	    return size;
	}

    public boolean empty() {
	    return size == 0;
	}

	public void add(int index,T e) {
	    Node pointer = head.next;

		for(int i=0; i<index; i++,pointer=pointer.next) {}

		Node newNode = new Node(e,pointer.prev,pointer);
		pointer.prev.next = newNode;
		pointer.prev = newNode;
		size++;
	}

	public void remove(int index) {
	    Node pointer = head.next;

		for(int i=0; i <index; i++,pointer=pointer.next) {}

        pointer.prev.next = pointer.next;
		pointer.next.prev = pointer.prev;
		size--;
	}

	public T get(int index) {
	    Node pointer = head.next;

		for(int i=0; i<index; i++,pointer=pointer.next) {}

		return pointer.value;
	}

	public int search(T e) {
	    Node pointer = head.next;

		for(int i=0; pointer != tail; i++,pointer=pointer.next) {
		    if(pointer.value == e) {
			    return i;
			}
		}

        return -1;
	}

	@Override
    public String toString() {
	    if(size == 0)
			return "empty list";

        String ret = "";

		Node pointer = head.next;

     

		while(pointer.next != tail) {
		    ret = ret + pointer.value.toString() + "-->";
			pointer = pointer.next;
		}

		ret = ret + pointer.value.toString();

		return ret;
	}
}
