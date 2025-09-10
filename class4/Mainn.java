import java.util.Random;

public class Mainn {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 10; i < 10000000; i *= 10) {
            System.out.println("---------------------------------------");
            System.out.println("This is for size --> " + i);
            int[] arr = new int[i];
            for (int j = 0; j < arr.length; j++)
                arr[j] = random.nextInt(10000);

            long start = System.nanoTime();
            brute(arr);
            long end = System.nanoTime();
            System.out.println("The time for brute is =======================> " + (end - start) + " ns");

            long start2 = System.nanoTime();
            optimal(arr);
            long end2 = System.nanoTime();
            System.out.println("The time for optimal is =====================> " + (end2 - start2) + " ns");
        }
    }

    static void brute(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        System.out.println("The min through brute is : " + min + " and the max is : " + max);
    }

    static void optimal(int[] arr) {
        int[] minMax = helper(arr, 0, arr.length - 1);
        System.out.println("The min through optimal is : " + minMax[0] + " and the max is : " + minMax[1]);
    }

    static int[] helper(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] { arr[left], arr[left] };
        }
        if (right - left == 1) {
            if (arr[left] < arr[right]) {
                return new int[] { arr[left], arr[right] };
            } else {
                return new int[] { arr[right], arr[left] };
            }
        }
        int mid = (left + right) / 2;
        int[] leftMinMax = helper(arr, left, mid);
        int[] rightMinMax = helper(arr, mid + 1, right);

        int min = Math.min(leftMinMax[0], rightMinMax[0]);
        int max = Math.max(leftMinMax[1], rightMinMax[1]);

        return new int[] { min, max };
    }
}