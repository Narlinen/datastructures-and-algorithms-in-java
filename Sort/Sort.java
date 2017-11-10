public class Sort {
    
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;

        for(int new_n=0; n>0; n=new_n) {
            new_n = 0;
            for(int i=1; i<n; i++) {
                if(arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr,i,i-1);
                    new_n = i;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for(int i=0; i<arr.length; i++) {
             int minIndex = i;
             for(int j=i+1; j<arr.length; j++) {
                 if(arr[minIndex].compareTo(arr[j]) > 0) {
                     minIndex = j;
                 }
             }
             swap(arr,minIndex,i);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for(int i=1; i<arr.length; i++) {
            T temp = arr[i];

            int j;
            for(j=i-1; j>=0 && arr[j].compareTo(temp) > 0; j--) {
                arr[j+1] = arr[j];
            }

            arr[j+1] = temp;
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int h = 1;
        while(h < arr.length/3) {
            h *= 3;
        }

        while(h>=1) {
            for(int i=h; i<arr.length; i+=h) {
                T temp = arr[i];

                int j;
                for(j=i-h; j>=0 && arr[j].compareTo(temp) > 0; j-=h) {
                    arr[j+h] = arr[j];
                }

                arr[j+h] = temp;
            }

            h /= 3;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr,int left,int right) {
        if(left >= right)
            return;
    
        int mid = (right-left)/2 + left;
    
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr,int left,int mid,int right) {
        T[] temp = (T[])new Comparable[right-left+1];

        for(int i=left; i<=right; i++) {
            temp[i-left] = arr[i];
        }
    
        int i=left,j=mid+1;
        for(int k=left; k<=right; k++) {
            if(i > mid) {
                arr[k] = temp[j-left];
                j++;
            } else if (j > right) {
                arr[k] = temp[i-left];
                i++;
            } else if (temp[i-left].compareTo(temp[j-left]) <= 0) {
                arr[k] = temp[i-left];
                i++;
            } else if (temp[i-left].compareTo(temp[j-left]) > 0) {
                arr[k] = temp[j-left];
                j++;
            }
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        MinHeap<T> heap = new MinHeap<T>(arr);

        for(int i=0; i<arr.length; i++) {
            arr[i] = heap.extractMin();
        }
    }

    private static void swap(Object[] arr,int a,int b) {
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
