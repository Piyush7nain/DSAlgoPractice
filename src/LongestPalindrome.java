public class LongestPalindrome {


    String palin;
    int maxL;

    public String longestPalindrome(String s) {

        palin = "";
        maxL = 0;
        int l = s.length();
        if(l==1)
            return s;
        for(int i = 0 ;i<l;i++ )
            palindrome(s,l, i, i);

        for(int j = 1;j<l; j++)
            palindrome(s,l, j-1, j);

        return palin;
    }

    void palindrome(String str,int l, int s, int f){

        while( ( (s>=0) &&(f<l) ) && ( str.charAt(s) == str.charAt(f) ) ){
            if( maxL < ( f-s +1 ) ){
                palin = str.substring(s, f+1);
                maxL = f-s +1;
            }
            s--;
            f++;
        }

    }
}
