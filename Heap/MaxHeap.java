public class MaxHeap<Item extends Comparable<Item>> {
    private Item[] data;
	private int count;

	@SuppressWarnings("unchecked")
	public MaxHeap(int n) {
	    data = (Item[])new Comparable[n+1];
		count = 0;
	}

	@SuppressWarnings("unchecked")
    public MaxHeap(Item[] arr) {
	    data = (Item[])new Comparable[arr.length+1];
		count = arr.length;

		for(int i=0; i<arr.length; i++) {
		    data[i+1] = arr[i];
		}

		for(int i=count/2; i>=1; i--) {
		    shiftDown(i);
		}
	}

	public void insert(Item v) {
	    data[++count] = v;
		shiftUp(count);
	}

	public Item getMax() {
	    if(empty()) {
		    return null;
		}

		return data[1];
	}

	public Item extractMax() {
	    Item ret = data[1];

		swap(data,1,count--);

		shiftDown(1);

		return ret;
	}

	public int size() {
	    return count;
	}

	public boolean empty() {
	    return count == 0;
	}

	private void shiftUp(int v) {
	    while(v > 1 && data[v].compareTo(data[v/2]) > 0) {
		    swap(data,v,v/2);
			v /= 2;
		}
	}

	private void shiftDown(int v) {
	    while(v*2 <= count) {
		    int k = v*2;
			if(k+1 <= count && data[k].compareTo(data[k+1]) < 0)
				k++;

			if(data[k].compareTo(data[v]) <= 0) {
			    return;
			}

			swap(data,k,v);

			v = k;
		}
	}

	private void swap(Item[] arr,int i,int j) {
	    Item temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} 
}
