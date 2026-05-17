public class FindMin {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1};

        int min = arr[0];

        for (int num : arr) {
            if (num < min)
                min = num;
        }

        System.out.println(min);
    }
}
