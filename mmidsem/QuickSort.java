import java.util.Arrays;

public class QuickSort{
    public static void main(String args[]){
        int[]arr = new int[]{56,43,3,2,7,8};
        QuickSort ob = new QuickSort();
        ob.quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low+1;
        for(int j=low+1; j<=high; j++){
            if(arr[j]<pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[low];
        arr[low] = arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }

    void quicksort(int[] arr, int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi-1);
            quicksort(arr, pi+1, high);
        }
    }
}