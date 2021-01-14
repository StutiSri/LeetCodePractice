import java.util.*;

class Result {

    /*
     * Complete the 'vanity' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codes
     *  2. STRING_ARRAY numbers
     */

    public static List<String> vanity(List<String> codes, List<String> numbers) {
        long startTime = System.currentTimeMillis();
        Map<Character, Character> phoneMap = getPhoneMap();
        ArrayList<String> phoneNumbersWithCodes = new ArrayList<>();
        Map<String, Boolean> isAddded = new HashMap<>();
        for (String code : codes) {
            for (int indexOfNumber = 0; indexOfNumber < numbers.size(); indexOfNumber++) {
                String number = numbers.get(indexOfNumber);
                if (isAddded.getOrDefault(number, false)) {
                    continue;
                }
                int indexInCode = 0;
                int indexInNumber = 1;
                boolean isMatching = false;
                while (indexInCode < code.length() && indexInNumber < number.length()) {
                    char charInCode = code.charAt(indexInCode);
                    char correspondingNumber = phoneMap.get(charInCode);
                    char numberInPhoneNumber = number.charAt(indexInNumber);
                    if (correspondingNumber == numberInPhoneNumber) {
                        indexInCode++;
                        isMatching = true;
                    } else if (indexInCode != 0) {
                        indexInCode = 0;
                        isMatching = false;
                        charInCode = code.charAt(indexInCode);
                        correspondingNumber = phoneMap.get(charInCode);
                        if (correspondingNumber == numberInPhoneNumber) {
                            indexInCode++;
                            isMatching = true;
                        }
                    }
                    indexInNumber++;
                }
                if (isMatching && indexInCode == code.length()) {
                    phoneNumbersWithCodes.add(number);
                    isAddded.put(number, true);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);

        Collections.sort(phoneNumbersWithCodes);

        return phoneNumbersWithCodes;
    }

    private static Map<Character, Character> getPhoneMap() {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');

        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');

        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');

        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');

        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');

        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');

        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');

        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');
        return map;
    }

}