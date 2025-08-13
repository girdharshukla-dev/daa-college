package class2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Duplicate {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(10000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10); // restrict values to increase chance of duplicates
        }
        check(arr);
    }

    static void check(int[] arr) {
        long time1 = System.nanoTime();
        System.out.println(bruteForce(arr) ? "Duplicacy found" : "No duplicacy");
        long time2 = System.nanoTime();
        System.out.println("Time using Brute Force -------> " + (time2 - time1) + " ns");

        long time3 = System.nanoTime();
        System.out.println(sortAndCheck(arr) ? "Duplicacy found" : "No duplicacy");
        long time4 = System.nanoTime();
        System.out.println("Time using O(n log n) approach -------> " + (time4 - time3) + " ns");

        long time5 = System.nanoTime();
        System.out.println(usingSet(arr) ? "Duplicacy found" : "No duplicacy");
        long time6 = System.nanoTime();
        System.out.println("Time using HashSet (O(n)) -------> " + (time6 - time5) + " ns");
    }

    // O(n^2) brute-force
    static boolean bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(n log n) approach
    static boolean sortAndCheck(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == copy[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // O(n) approach using HashSet
    static boolean usingSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
