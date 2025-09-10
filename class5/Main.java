class QuickSort {
    // Partition function
    int partition(int arr[], int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Recursive quicksort
    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {100 , 23 , 43 , 44 , 22 , 11 , 56 , 52 , 36 , 44};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        System.out.println("Original array:");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        ob.quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int x : arr) System.out.print(x + " ");
    }
}
