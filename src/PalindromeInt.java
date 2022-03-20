public class PalindromeInt {

    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int rem = 0;
        int org = x;
        while(x>0){
            rem = rem*10 + x%10;
            x = x/10;
        }
        return (org == rem);
    }

    public boolean isPalindrome2(int x) {
        if(x<0)
            return false;
        boolean ans = true;
        char[] s = Integer.toString(x).toCharArray();
        int l = s.length;
        int f = 0;
        int e = l-1;
        while( e>=f){
            if(s[e]!=s[f])
                return false;
            e--;
            f++;
        }
        return ans;
    }
}
