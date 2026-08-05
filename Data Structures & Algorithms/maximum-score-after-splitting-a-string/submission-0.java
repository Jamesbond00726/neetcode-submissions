class Solution {
    public int maxScore(String s) {
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            int countZero=0, CountOne=0;
            String left=s.substring(0,i+1);
            String right=s.substring(i+1,s.length());
            for (char c : left.toCharArray()){
                if (c=='0') countZero++;
            }
            for (char c : right.toCharArray()){
                if (c=='1') CountOne++;
            }
            max=Math.max(max,countZero+CountOne);
        }
        return max;
    }
}