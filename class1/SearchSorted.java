package class1;

import java.util.Arrays;
import java.util.Random;

public class SearchSorted {
    public static void main(String[] args) {
        for(int i = 10 ; i<=1000000 ; i*=10){
            test(i);
        }
    }

    static void test(int size){
        int[] arr = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++){
            arr[i] = random.nextInt(1000);
        }
        int target = random.nextInt(1000);
        
        //we are sorting before the benchmark
        Arrays.sort(arr);

        System.out.println("-----------------------------------------------------------");
        System.out.println("Testing for sorted array with size : " + size);
        
        long linearTime1 = System.nanoTime();
        boolean linearAns = linearSearch(arr , target);
        System.out.println("The result of linear search is " + linearAns);
        long linearTime2 = System.nanoTime();
        System.out.println("The time for LINEAR search is -------> " + (linearTime2 - linearTime1)); 
        
        long binaryTime1 = System.nanoTime();
        boolean binaryAns = binarySearch(arr , target);
        System.out.println("The result of linear search is " + binaryAns);
        long binaryTime2 = System.nanoTime();
        System.out.println("The time for BINARY search is -------> " + (binaryTime2 - binaryTime1)); 
        
        System.out.println("-----------------------------------------------------------");
    }

    static boolean linearSearch(int[] arr , int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }

    static boolean binarySearch(int[] arr , int target){
        // Arrays.sort(arr);
        int middle;
        int end = arr.length-1;
        int start = 0;
        while(start<=end){
            middle = (start+end)/2;
            if(arr[middle] == target){
                return true;
            } else if(arr[middle] > target){
                end = middle - 1;
            } else if(arr[middle] < target){
                start = middle + 1;
            }
        }
        return false;
    }
}

