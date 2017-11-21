public class IndexMaxHeap<Item extends Comparable<Item>> {
    private Item[] data;
	private int[] indexes;
	private int[] indexofindex;
    private int count;
	private int capacity;

	public IndexMaxHeap(int capacity) {
	    data = (Item[])new Object[capacity+1];
		indexes = new int[capacity+1];
		indexofindex = new int[capacity+1];
		count = 0;
		this.capacity = capacity;
	}

	public int size() {
	    return count;
	}

	public boolean empty() {
	    return count == 0;
	}

	public void insert(int i,Item item) {
	    i++;
		data[i] = item;
		indexes[++count] = i;
		indexsindex[i] = count;
		shiftUp(count);
	}

	public Item extractMax() {
	    Item ret = data[indexes[1]];
        swapIndex(1,count);
		indexsindex[indexes[count--]] = 0;
		shiftDown(1);
		return ret;
	}

	public int extractMaxIndex() {
	    int ret = indexes[1];
		swapIndex(1,count);
		indexsindex[indexes[count--]] = 0;
		shiftDown(1);
		return ret;
	}

	public Item getMax() {
	    return data[indexes[1]];
	}

	public int getMaxIndex() {
	    return indexesp[1] - 1;
	}

	public Item getItem(int i) {
	    i++;
		return data[i];
	}

	public void change(int i,Item item) {
	
	}

	private void swapIndex(int i,int j) {
	    int temp = indexes[i];
		indexes[i] = indexes[j];
		indexes[j] = temp;
	}

	private void shiftUp(int k) {
	    while(k>1 && data[indexes[k]].compareTo(data[indexes[k/2]]) > 0) {
		    swapIndex(k,k/2);
			k /= 2;
		}
	}

	private void shiftDown(int k) {
	    while(k*2 <= count) {
		    int i = k*2;
			if(i+1 <= count && data[indexes[i+1]].compareTo(data[indexes[i]]) > 0) {
			    i++;
			}

			if(data[indexes[k]].compareTo(data[indexes[i]]) > 0) {
			    break;
			}

			swapIndex(i,k);
			k = i;
		}
	}
}
