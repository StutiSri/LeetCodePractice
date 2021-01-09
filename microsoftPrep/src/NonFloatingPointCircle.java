public class NonFloatingPointCircle {
    public static void main(String[] args) {
        int r = 4;
        int rSquare = r * r;
        int N = 2 * r + 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = i - r;
                int y = j - r;
                if ((x * x + y * y) <= (rSquare + 1)) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
