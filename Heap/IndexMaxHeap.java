public class IndexMaxHeap<Item extends Compare> {
	private Item[] data;
	private int[] indexes;
	private int[] reverse;

	private int count;
	private int capacity;

	public IndexMaxHeap(int capacity) {
		this.data = new Item[capacity+1];
		this.indexes = new int[capacity+1];
		this.reverse = new int[capacity+1];
        this.capacity = capacity;
        this.count = 0;
	}

	public int size() {
		return count;
	}

	public boolean empty() {
		return count == 0;
	}

	public void insert(int i,Item item) {

	}

	public Item extractMax() {

	}

	public int extractMaxIndex() {

	}

    public void setItem(int i,Item item) {
		
	}

	public Item getMax() {

	}

	public int getMaxIndex() {

	}

	public Item getItem(int i) {

	}
}