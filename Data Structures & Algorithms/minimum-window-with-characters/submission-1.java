class Solution {
    public String minWindow(String s, String t) {

        if (s.length()<t.length()) return "";
        int[] freq=new int[128];

        for (char c:t.toCharArray()){
            freq[c]++;
        }

        int l=0, start=0;
        int count=t.length();
        int minLen=Integer.MAX_VALUE;

        for (int r=0; r<s.length(); r++){
            char rc=s.charAt(r);
            if (freq[rc]>0) count--;
            freq[rc]--;
            while (count==0){
                char lc=s.charAt(l);
                if (r-l+1<minLen){
                    minLen=r-l+1;
                    start=l;
                } 
                freq[lc]++;
                if (freq[lc]>0) count++;
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE? "" : s.substring(start, minLen+start);
    }
}
