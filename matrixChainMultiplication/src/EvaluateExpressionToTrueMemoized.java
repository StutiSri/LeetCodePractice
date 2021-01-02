import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrueMemoized {
    static Map<String, Integer> t;

    public static void main(String[] args) {
        String exp = "T&F|T";
        int length = exp.length();
        t = new HashMap<>();
        System.out.println(ways(exp.toCharArray(), 0, length - 1, true));
    }

    private static int ways(char[] exp, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue && exp[i] == 'T') {
                return 1;
            } else if (!isTrue && exp[i] == 'F') {
                return 1;
            } else {
                return 0;
            }
        }
        String key = i + " " + j + " " + isTrue;
        int numOfWays = t.getOrDefault(key, -1);
        if (numOfWays != -1) {
            return numOfWays;
        }
        numOfWays = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            int lf = ways(exp, i, k - 1, false);
            int lt = ways(exp, i, k - 1, true);
            int rf = ways(exp, k + 1, j, false);
            int rt = ways(exp, k + 1, j, true);
            numOfWays += 1 + evaluate(exp[k], lf, lt, rf, rt, isTrue);
        }
        t.put(key, numOfWays);
        return numOfWays;
    }

    private static int evaluate(char operator, int lf, int lt, int rf, int rt, boolean isTrue) {
        if (operator == '&') {
            if (isTrue) {
                return lt * rt;
            } else {
                return lf * rf + lf * rt + lt * rf;
            }
        }
        if (operator == '|') {
            if (isTrue) {
                return lt * rt + lf * rt + lt * rf;
            } else {
                return lf * rf;
            }
        }
        if (operator == '^') {
            if (isTrue) {
                return lf * rt + lt * rf;
            } else {
                return lt * rt + lf * rf;
            }
        }
        return 0;
    }
}
