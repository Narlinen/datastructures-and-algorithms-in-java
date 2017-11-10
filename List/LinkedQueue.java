package narlinen.dsa.linkedqueue;

import narlinen.dsa.linkedlist.LinkedList;

public class LinkedQueue<T> {
    private LinkedList<T> list;

    public LinkedQueue() {
        list = new LinkedList<T>();
    }

    public int size() {
        return list.size();
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public void enQueue(T e) {
        list.add(list.size(),e);
    }

    public void deQueue() {
        list.remove(0);
    }

    public T top() {
        return list.get(0);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
