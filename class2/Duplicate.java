package class2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

public class Duplicate {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(10000)];
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(10);
        }
        check(arr);
    }

    static void check(int[] arr){
        long time1 = System.nanoTime();
        System.out.println(bruteForce(arr)?"Duplicacy found":"No duplicacy");
        long time2 = System.nanoTime();
        System.out.println("The time using Brute Force -------> " +(time2-time1));
        
        long time3 = System.nanoTime();
        System.out.println(optimised(arr)?"Duplicacy found":"No duplicacy");
        long time4 = System.nanoTime();
        System.out.println("The time using Optimised is -------> " +(time4-time3));
    }

    static boolean bruteForce(int[] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1]){
                return true;
            }
        }
        return false;
    }

    // static boolean optimised(int[] arr){
    //    return Arrays.stream(arr).boxed().collect(Collectors.toSet()).size()<arr.length;
    // }

    static boolean optimised(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
