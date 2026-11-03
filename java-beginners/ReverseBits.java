public class ReverseBits {

    public static int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            // Shift result left by 1 and add last bit of n
            result = (result << 1) | (n & 1);

            // Move n right by 1 bit
            n >>>= 1;
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 43261596;

        int result = reverseBits(n);

        System.out.println("Reversed Bits: " +
                Integer.toUnsignedString(result));
    }
}