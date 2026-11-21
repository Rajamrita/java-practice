public class RangeBitwiseAnd {

    public static int rangeBitwiseAnd(int left, int right) {

        int shift = 0;

        // Find the common binary prefix
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Restore the common prefix
        return left << shift;
    }

    public static void main(String[] args) {

        int left = 5;
        int right = 7;

        int result = rangeBitwiseAnd(left, right);

        System.out.println("Range Bitwise AND: " + result);
    }
}