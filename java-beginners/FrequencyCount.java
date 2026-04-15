public class FrequencyCount {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 1};

        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            boolean alreadyCounted = false;
            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                System.out.println(arr[i] + " → " + count);
            }
        }
    }
}