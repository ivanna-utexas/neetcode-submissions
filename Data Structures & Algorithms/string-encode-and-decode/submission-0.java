class Solution {

    //my algorithm:
    //then include lengths of strings at the end to indicate word length
    //use '#' as a delimiter
    //include all characters of sting list[i] in a string
    //next string..

    public String encode(List<String> strs) {
        StringBuilder code = new StringBuilder("");
        for(String word : strs) {
            code.append(word.length());
            code.append("#");
            code.append(word);
        }
        return code.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> code = new ArrayList<>();
        for(int c = 0; c < str.length(); c++) {
            StringBuilder lengthStr = new StringBuilder("");
            while(str.charAt(c) != '#') {
                lengthStr.append(str.charAt(c));
                c++;
            }
            int length = Integer.parseInt(lengthStr.toString());

            code.add(str.substring(c + 1,  c + length + 1));

            c = c + length;
        }
        return code;
    }
}
