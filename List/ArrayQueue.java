package narlinen.dsa.arrayqueue;

import narlinen.dsa.arraylist.ArrayList;

public class ArrayQueue<T> {
    private ArrayList<T> list;

    public ArrayQueue() {
        list = new ArrayList<T>();
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
