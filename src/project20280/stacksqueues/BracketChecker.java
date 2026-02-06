package project20280.stacksqueues;
import project20280.interfaces.Stack;

class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public boolean check() {
        // TODO
        //open brackets put onto the stack,
        //ignore anything that isn't a bracket
        //when seeing open bracket, pop the stack and compare elements.

        Stack<Character> characterStack = new LinkedStack<>();


        for (char c: input.toCharArray()) {

            if (c == '[' || c == '(' || c == '{') {
                characterStack.push(c);
                continue;
            }

            if (c != ']' && c != ')' && c != '}'){
                continue;
            }

            if (characterStack.isEmpty()){
                return false;
            }

            char top = characterStack.pop();

            switch (c) {
                case ']':
                    if (top != '[') {
                        return false;
                    }
                        break;
                case '}':
                    if (top != '{'){
                        return false;
                    }
                    break;
                case ')':
                    if (top != '('){
                        return false;
                    }
                    break;

                default:
                    break;
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        String[] inputs = {
                "[]]()()", // not correct
                "c[d]", // correct\n" +
                "a{b[c]d}e", // correct\n" +
                "a{b(c]d}e", // not correct; ] doesn't match (\n" +
                "a[b{c}d]e}", // not correct; nothing matches final }\n" +
                "a{b(c) ", // // not correct; Nothing matches opening {
        };

        for (String input : inputs) {
            BracketChecker checker = new BracketChecker(input);
            System.out.println("checking: " + input);
            System.out.println(checker.check());
        }
    }
}