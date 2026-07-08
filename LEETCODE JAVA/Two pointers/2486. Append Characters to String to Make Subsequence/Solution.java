class Solution {
    public int appendCharacters(String s, String t) {
    int l=0;
    int r=l;
     while(r<s.length()&&l<t.length()){
    if(t.charAt(l)==s.charAt(r)){
        l++;r++;
    }
    else{r++;}
    }
   
    return t.substring(l,t.length()).length();
    }
}
