public class ArmstrongNumber {
    public static void main(String[] args) {

        int n = 153;
        int sum = 0, temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }

        if (sum == n)
            System.out.println("Armstrong");
        else
            System.out.println("Not Armstrong");
    }
}
