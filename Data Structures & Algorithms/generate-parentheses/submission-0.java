class Solution {
    public List<String> generateParenthesis(int n) {
        //Recursivly build list
        //base case n == 0
        //recursive case for each space you can choose
            //do i close this paraenthesis
            //do i keep adding one
        //helper -> 
            //n = number of target pairs
            //o = number of open parentheses
            //c = number of closed parentheses
            //string current
            //list<String> result
            //Add (: allowed if open < n. You can’t use more than n opens.
            //Add ): allowed if closed < open. You can only close something that’s already open.
            List<String> result = new ArrayList<>();
            helper(n, 0, 0, "", result);
            return result;
    }

    private void helper(int n, int o, int c, String current, List<String> result) {
        if(o == n && c == n) {
            result.add(current);
            return;
        }

        if(o < n) {
            helper(n, o+1, c, current + "(", result);
        }
        if(c < o) {
            helper(n, o, c+1, current + ")", result);
        }
    }
}
