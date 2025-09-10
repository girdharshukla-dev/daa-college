import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.printf("%-12s | %-20s | %-20s%n", "Size", "Brute Comparisons", "Optimal Comparisons");
        System.out.println("--------------------------------------------------------------");

        for (int i = 10; i < 10000000; i *= 10) {
            int[] arr = new int[i];
            for (int j = 0; j < arr.length; j++)
                arr[j] = random.nextInt(10000);

            int brute_count = brute(arr);
            int optimal_count = optimal(arr);

            System.out.printf("%-12d | %-20d | %-20d%n", i, brute_count, optimal_count);
        }

    }

    static int brute(int[] arr) {
        int count = 0;
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            count++;
            if (i < min) {
                min = i;
            }
            count++;
            if (i > max) {
                max = i;
            }
        }
        return count;
    }

    static int optimal(int[] arr) {
        int[] count = new int[] { 0 };
        int[] minMax = helper(arr, 0, arr.length - 1, count);
        return count[0];
    }

    static int[] helper(int[] arr, int left, int right, int[] count) {
        if (left == right) {
            return new int[] { arr[left], arr[left] };
        }
        if (right - left == 1) {
            count[0]++;
            if (arr[left] < arr[right]) {
                return new int[] { arr[left], arr[right] };
            } else {
                return new int[] { arr[right], arr[left] };
            }
        }
        int mid = (left + right) / 2;
        int[] leftMinMax = helper(arr, left, mid, count);
        int[] rightMinMax = helper(arr, mid + 1, right, count);

        count[0]++;
        int min = Math.min(leftMinMax[0], rightMinMax[0]);
        count[0]++;
        int max = Math.max(leftMinMax[1], rightMinMax[1]);

        return new int[] { min, max };
    }
}