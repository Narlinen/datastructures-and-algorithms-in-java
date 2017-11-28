import java.util.LinkedList;

public class SeparateChainingHashTable<Key extends Comparable<Key>,Value> {

	class Entry<Key,Value> {
		public Key key;
		public Value value;

		public Entry(Key k,Value v) {
			key = k;
			value = v;
		}
	}

	private LinkedList<Entry<Key,Value>>[] data;

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {
        data = (LinkedList<Entry<Key,Value>>[])new LinkedList[size];

        for(int i=0; i<data.length; i++) {
        	data[i] = new LinkedList<Entry<Key,Value>>();
        }
	}

	private int getHashCode(Key k) {
		String keystr = k.toString();

		int hashCode = 0;

		for(int i=0; i<keystr.length(); i++) {
            hashCode = hashCode * 37 + keystr.charAt(i);
		}

		hashCode %= data.length;

		return hashCode;
	}

	public void put(Key k,Value v) {
        LinkedList<Entry<Key,Value>> list = data[getHashCode(k)];

        for(Entry<Key,Value> e : list) {
        	if(e.key.compareTo(k) == 0) {
        		e.value = v;
        		return;
        	}
        }

        list.add(new Entry<Key,Value>(k,v));
	}

	public Value get(Key k) {
		LinkedList<Entry<Key,Value>> list = data[getHashCode(k)];

		for(Entry<Key,Value> e : list) {
			if(e.key.compareTo(k) == 0) {
				return e.value;
			}
		}

		return null;
	}

	public void remove(Key k) {
        LinkedList<Entry<Key,Value>> list = data[getHashCode(k)];

        for(Entry<Key,Value> e : list) {
        	if(e.key.compareTo(k) == 0) {
        		e.value = null;
        	}
        }
	}

	public boolean contains(Key k) {
		LinkedList<Entry<Key,Value>> list = data[getHashCode(k)];

		for(Entry<Key,Value> e : list) {
        	if(e.key.compareTo(k) == 0 && e.value != null) {
        		return true;
        	}
        }

        return false;
	}

	public void clear() {
		for(int i=0; i<data.length; i++) {
			data[i].clear();
		}
	}
}