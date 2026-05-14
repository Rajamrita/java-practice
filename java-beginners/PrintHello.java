public class PrintHello {
    static void hello(int n) {
        if (n == 0) return;
        System.out.println("Hello");
        hello(n-1);
    }
    public static void main(String[] args) {
        hello(3);
    }
}
