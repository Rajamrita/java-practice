public class FindMax {
    public static void main(String[] args) {

        int[] arr = {10, 25, 7, 99, 3};

        int max = arr[0];

        for (int num : arr) {
            if (num > max)
                max = num;
        }

        System.out.println("Max = " + max);
    }
}