class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;          // bug 1
                if (!isPair(stack.pop(), c)) return false;
            }
        }
        return stack.isEmpty();                              // bug 2
    }

    public boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isPair(char open, char close) {
        if(open == '(' && close == ')') return true;
        if(open == '[' && close == ']') return true;
        if(open == '{' && close == '}') return true;
        return false;
    }
}
