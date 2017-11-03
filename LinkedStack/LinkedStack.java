package narlinen.dsa.linkedstack;

import narlinen.dsa.linkedlist.LinkedList;

public class LinkedStack<T> {
    private LinkedList<T> list;

	public LinkedStack() {
	    list = new LinkedList<T>();
	}

	public int size() {
	    return list.size();
	}

	public boolean empty() {
	    return list.empty();
	}

	public void push(T e) {
	    list.add(list.size(),e);
	}

	public void pop() {
	    list.remove(list.size()-1);
	}

	public T top() {
	    return list.get(list.size()-1);
	}

	public void clear() {
	    while(list.size() != 0) {
		    list.remove(0);
		}
	}

    @Override
	public String toString() {
	    return list.toString();
	}
}
