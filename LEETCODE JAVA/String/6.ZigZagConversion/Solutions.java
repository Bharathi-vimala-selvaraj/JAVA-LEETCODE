class Solution {
    public String convert(String s, int numRows) {
        String k[]=new String[numRows];
        for(int i=0;i<numRows;i++){
            k[i]="";
        }
        if(numRows==1){
            return s;
        }
        Boolean f=false;
        int i=0;
    for(int j=0;j<s.length();j++){
    k[i]+=s.charAt(j);
    if(i==0||i==numRows-1){
        f=!f;
    }
    i+=f?+1:-1;
    }
    String p="";
    for(String l:k){
        p+=l;
    }
    return p;
}}
