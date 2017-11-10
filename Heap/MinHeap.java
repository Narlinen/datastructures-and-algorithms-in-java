public class MinHeap<Item extends Comparable<Item>> {
    private Item[] data;
	private int count;

	@SuppressWarnings("unchecked")
	public MinHeap(int count) {
	    this.count = count;
		data = (Item[])new Comparable[count+1];
	}

	@SuppressWarnings("unchecked")
	public MinHeap(Item[] arr) {
	    this.count = arr.length;
		data = (Item[])new Comparable[count + 1];

		for(int i=0; i<count; i++) {
		    data[i+1] = arr[i];
		}

		for(int i=count/2; i>=1; i--) {
		    shiftDown(i);
		}
	}

	public int size() {
	    return count;
	}

	public boolean empty() {
	    return count == 0;
	}

	public void insert(Item v) {
	    data[++count] = v;
		shiftUp(count);
	}

    public Item getMax() {
	    if(count == 0) {
		    return null;
		}
		return data[1];
	}

	public Item extractMin() {
	    Item ret = data[1];

        swap(data,1,count--);

		shiftDown(1);

		return ret;
	}

	private void swap(Item[] arr,int a,int b) {
	    Item temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private void shiftUp(int v) {
	    while(v > 1 && data[v].compareTo(data[v/2]) < 0) {
		    swap(data,v,v/2);
			v /= 2;
		}
	}

	private void shiftDown(int v) {
	    while(v*2 <= count) {
		    int k = v*2;
            if(k+1 <= count && data[k].compareTo(data[k+1]) > 0) {
			    k++;
			} 

			if(data[v].compareTo(data[k]) <=0 ) {
			    break;
			}

			swap(data,v,k);

			v = k;
		}
	}
}
