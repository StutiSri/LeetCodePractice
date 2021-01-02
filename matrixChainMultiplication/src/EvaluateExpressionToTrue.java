public class EvaluateExpressionToTrue {
    public static void main(String[] args) {
        String exp = "T&F|T";
        System.out.println(ways(exp.toCharArray(), 0, exp.length() - 1, true));
    }

    private static int ways(char[] exp, int i, int j, boolean isTrue) {
        int numOfWays = 0;
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
        for (int k = i + 1; k < j; k = k + 2) {
            int lf = ways(exp, i, k - 1, false);
            int lt = ways(exp, i, k - 1, true);
            int rf = ways(exp, k + 1, j, false);
            int rt = ways(exp, k + 1, j, true);
            numOfWays += evaluate(exp[k], lf, lt, rf, rt, isTrue);
        }
        return numOfWays;
    }

    private static int evaluate(char operator, int lf, int lt, int rf, int rt, boolean isTrue) {
        if(operator == '&'){
            if(isTrue){
                return 1 + lt*rt;
            }else {
                return 1 + lt*rf + lf*rt + lf*rf;
            }
        }
        if(operator == '|'){
            if(isTrue){
                return 1 + lt*rf + lf*rt + lt*rt;
            }else {
                return 1 + lf*rf;
            }
        }
        if(operator == '^'){
            if(isTrue){
                return 1 + lt*rf + lf*rt;
            }else {
                return 1 + lf*rf + lt*rt;
            }
        }
        return 0;
    }
}
