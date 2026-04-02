public class PrintPaths {

    static void print(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        print(n - 1, path + "1");
        print(n - 1, path + "2");
    }

    public static void main(String[] args) {
        print(2, "");
    }
}
