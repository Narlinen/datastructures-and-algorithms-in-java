import java.util.Comparator;

public class Sort {

    public static <T> void selectionSort(T[] arr,Comparator<T> cmp) {
	    for(int i=0; i<arr.length; i++) {
		     int minIndex = i;
             for(int j=i+1; j<arr.length; j++) {
			     if(cmp.compare(arr[minIndex],arr[j]) > 0) {
				     minIndex = j;
				 }
			 }
			 swap(arr,minIndex,i);
		}
	}

	public static <T> void insertionSort(T[] arr,Comparator<T> cmp) {
	    for(int i=1; i<arr.length; i++) {
		    T temp = arr[i];

			int j;
			for(j=i-1; j>=0 && cmp.compare(arr[j],temp) > 0; j--) {
			    arr[j+1] = arr[j];
			}

            arr[j+1] = temp;
		}
	}

	public static <T> void shellSort(T[] arr,Comparator<T> cmp) {
	    int h = 1;
		while(h < arr.length/3) {
		    h *= 3;
		}

		while(h>=1) {
		    for(int i=h; i<arr.length; i+=h) {
			    T temp = arr[i];

				int j;
				for(j=i-h; j>=0 && cmp.compare(arr[j],temp) > 0; j-=h) {
				    arr[j+h] = arr[j];
				}

				arr[j+h] = temp;
			}

	        h /= 3;
		}
	}

	public static <T> void mergeSort(T[] arr,int left,int right,Comparator<T> cmp) {
	    if(left >= right)
			return;
	
	    int mid = (right-left)/2 + left;
	
	    mergeSort(arr,left,mid,cmp);
	    mergeSort(arr,mid+1,right,cmp);
        merge(arr,left,mid,right,cmp);
	}
    
	@SuppressWarnings("unchecked")
    private static <T> void merge(T[] arr,int left,int mid,int right,Comparator<T> cmp) {
	    Object[] temp = new Object[right-left+1];

		for(int i=left; i<=right; i++) {
		    temp[i-left] = arr[i];
		}

        int i=left,j=mid+1;
		for(int k=left; k<=right; k++) {
		    if(i > mid) {
			    arr[k] = (T)temp[j-left];
				j++;
			} else if (j > right) {
			    arr[k] = (T)temp[i-left];
				i++;
			} else if (cmp.compare((T)temp[i-left],(T)temp[j-left]) <= 0) {
			    arr[k] = (T)temp[i-left];
				i++;
			} else if (cmp.compare((T)temp[i-left],(T)temp[j-left]) > 0) {
			    arr[k] = (T)temp[j-left];
				j++;
			}
		}
	}

	private static void swap(Object[] arr,int a,int b) {
	    Object temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
