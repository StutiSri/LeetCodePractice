import java.util.HashMap;
import java.util.Map;

class ParenthesesValidator {

    /**
     * Basic Stack class implementation for char elements
     */
    class Stack {

        private final char[] elements;
        private int size;
        private int top;

        /**
         * @param size - The max expected elements in this stack
         */
        Stack(int size) {
            elements = new char[size];
            this.size = size;
            top = -1;
        }

        /**
         * @param data - If the stack is not full, push the elements to the top of the stack
         *             Throw RuntimeException if the stack is full
         */
        void push(char data) {
            if (top == size - 1) {
                throw new RuntimeException("Overflow!");
            }
            elements[++top] = data;
        }

        /**
         *
         * @return - If the stack is not empty return the top element of the stack
         */
        char pop() {
            if (top == -1) {
                throw new RuntimeException("Underflow!");
            }
            return elements[top--];
        }

        /**
         *
         * @return - The number of elements that are currently being managed in the stack.
         */
        int getCurrentNumberOfElementsInStack(){
            return top;
        }
    }

    /**
     *
     * @param expression - The expression string with parentheses that needs to be validated
     * @return - return true if the expression is valid, else false.
     */
    boolean isValid(String expression) {
        Stack exprStack = new Stack(expression.length());
        Map<Character, Character> openCloseParenthesesMap = getOpenCloseParenthesesMap();
        /*
         * Iterate through each of the characters in the expression.
         * For each character if its of type open parentheses, push it to the stack
         * If its not, pop the top element from the stack. In order for the expression to be valid the
         * popped element should be the opening parentheses for the new character which is a closing parentheses.
         * Utilizing the openCloseParenthesesMap created earlier to validate the open close parentheses to keep the validation in O(1) time.
         */
        for (char parentheses : expression.toCharArray()) {
            if (isOpeningParentheses(parentheses)) {
                exprStack.push(parentheses);
            } else {
                char openingParentheses = exprStack.pop();
                if (!isMatchingClosingParentheses(openCloseParenthesesMap, openingParentheses, parentheses)) {
                    return false;
                }
            }
        }
        /*
         * If the stack is not empty, that means there are certain open brackets left that had no corresponding closing brackets
         * Thereby invalidating the expression
         */
        return exprStack.getCurrentNumberOfElementsInStack() == -1;
    }

    public static void main(String[] args) {
        System.out.println(new ParenthesesValidator().isValid("[]"));

        System.out.println(new ParenthesesValidator().isValid("[}"));

        System.out.println(new ParenthesesValidator().isValid("[()(){}]"));

        System.out.println(new ParenthesesValidator().isValid("[{()}{()}]"));

        System.out.println(new ParenthesesValidator().isValid("[(({})]"));

        System.out.println(new ParenthesesValidator().isValid("[({)}]"));

        System.out.println(new ParenthesesValidator().isValid(""));

        System.out.println(new ParenthesesValidator().isValid("({({({({({({(["));

    }


    private boolean isMatchingClosingParentheses(Map<Character, Character> openCloseParenthesesMap, char openingParentheses, char parentheses) {
        char expectedClosingParentheses = openCloseParenthesesMap.get(openingParentheses);
        return expectedClosingParentheses == parentheses;
    }

    private boolean isOpeningParentheses(char parentheses) {
        return parentheses == '(' || parentheses == '{' || parentheses == '[';
    }

    /**
     * @return - A mapping of opening parentheses with its closing counterpart to
     * keep the search for expected closing parentheses in O(1) time
     */
    private Map<Character, Character> getOpenCloseParenthesesMap() {
        Map<Character, Character> openCloseParenthesesMap = new HashMap<>();
        openCloseParenthesesMap.put('{', '}');
        openCloseParenthesesMap.put('(', ')');
        openCloseParenthesesMap.put('[', ']');
        return openCloseParenthesesMap;
    }
}
