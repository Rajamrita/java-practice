public class TransposeMatrix {
    public static void main(String[] args) {

        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] trans = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                trans[j][i] = arr[i][j];
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
