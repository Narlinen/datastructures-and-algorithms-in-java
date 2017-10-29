package narlinen.dsa.arrayList;

public class ArrayList<T> {
    
    private Object[] elements;
    private int size;
    private int capacity;

    private void expand() {
        if(size == capacity) {
            capacity *= 2;
            Object[] newArray = new Object[capacity];
     
            for(int i=0; i<size; i++) {
                newArray[i] = elements[i];
            }
        
            elements = newArray;
            }
        }

    private void shrink() {
        if(capacity > size *2) {
            capacity = size * 2;
            Object[] newArray = new Object[capacity];
           
            for(int i=0; i<size; i++) {
                newArray[i] = elements[i];
            }

            elements = newArray;
        }
	}

    public ArrayList() {
        capacity = 10;
        size = 0;
        elements = new Object[capacity];
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(int index,T e) {
        expand();

        for(int i=size-1; i>=index; i--) {
            elements[i+1] = elements[i];
        }

        elements[index] = e;

        size++;
    }

    public void remove(int index) {
        for(int i=index+1; i<size; i++) {
            elements[i-1] = elements[i];
        }

        size--;

        shrink();
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        try {
            return (T)elements[index];
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public int search(T e) {
        for(int i=0; i<size; i++) {
            if(elements[i] == e) {
            	return i;
            }
        }
        return -1;
    }

	@Override
	public String toString() {
	    String ret = "[";

		for(int i=0; i<size-1; i++) {
		    ret = ret + elements[i].toString() + ",";
		}

		ret = ret + elements[size-1].toString() + "]";

		return ret;
	}
}
