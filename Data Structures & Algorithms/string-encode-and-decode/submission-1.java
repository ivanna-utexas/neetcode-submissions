class Solution {

    //my algorithm:
    //encode
    //Length#string
    //decode
    //length -> string

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder("");
        for(String word : strs) {
            s.append(word.length());
            s.append("#");
            s.append(word);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> ans = new ArrayList<>();
        int right = 0;
        while(right < str.length()) {
            int left = right;
            while(str.charAt(left) != '#') {
                left++;
            }
            int length = Integer.parseInt(str.substring(right, left));
            right = left + 1;
            left = right + length;
            ans.add(str.substring(right, left));
            right = left;
        }
        return ans;
    }
}
