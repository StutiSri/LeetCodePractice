import static java.lang.Math.min;

public class PalindromePartitioningOptimizarion {
    static int[][] t;

    public static void main(String[] args) {
        String str = "nitik";
        int length = str.length();
        t = new int[length + 1][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(pp(str, 0, length - 1));
    }

    private static int pp(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if(isPalindrome(str, i, j)){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int ik = t[i][k];
            if(ik == -1){
                ik = pp(str, i, k);
            }
            int kj = t[k+1][j];
            if(kj == -1){
                kj = pp(str, k+1, j);
            }
            int temp = 1 + ik + kj;
            ans = min(temp, ans);
        }
        t[i][j] = ans;
        return ans;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        int midIndex = start + (end - start)/2;
        for (int i = start, j = end; i <= midIndex; i++, j--){
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
