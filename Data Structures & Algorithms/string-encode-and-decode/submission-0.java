class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();
        int i=0;
        while (i<str.length()){
            StringBuilder l= new StringBuilder();
            while (Character.isDigit(str.charAt(i))){
                l.append(str.charAt(i));
                i++;
            }
            i++;
            int skip=Integer.parseInt(l.toString());
            list.add(str.substring(i,i+skip));
            i+=skip;
        }
        return list;
    }
}
