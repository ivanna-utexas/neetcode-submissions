class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> expression = new ArrayDeque<Integer>();
        for(int c = 0; c < tokens.length; c++) {
            if(isOperator(tokens[c])) {
                int two = expression.pop();
                int one = expression.pop();
                expression.push(evaluate(one, two, tokens[c]));
            } else {
                expression.push(Integer.parseInt(tokens[c]));
            }
        }
        return expression.pop();
    }


    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }


    public int evaluate(int one, int two, String operation) {
        if(operation.equals("+")) return one + two;
        if(operation.equals("-")) return one - two;
        if(operation.equals("*")) return one * two;
        if(operation.equals("/")) return one / two;
        return 0;
    } 
}
