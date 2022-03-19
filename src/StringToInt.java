public class StringToInt {
    //Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
    //
    //The algorithm for myAtoi(string s) is as follows:
    //
    //Read in and ignore any leading whitespace.
    //Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    //Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
    //Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    //If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    //Return the integer as the final result.
    public int myAtoi(String s) {

        int l = s.length();
        if(l==0 )return 0;
        int sign = 1;
        int cur=0;
        while( cur < l && s.charAt(cur)==' '){
            cur++;
        }
        if(cur >=l) return 0;
        if(s.charAt(cur)=='-') {
            sign = -1;
            cur = cur +1;
        }else if(s.charAt(cur)=='+') {
            cur = cur +1;
        }

        int num = 0;
        for(int i = cur;i<l;i++){
            char c = s.charAt(i);
            if( c<=57&& c>=48){
                int j = (c-48);
                if( (num> (Integer.MAX_VALUE/10) || (num== Integer.MAX_VALUE/10 && j >7) ) )
                    return Integer.MAX_VALUE;
                if( (num< (Integer.MIN_VALUE/10) || (num== Integer.MIN_VALUE/10 && j >8) ) )
                    return Integer.MIN_VALUE;
                num = num*10 + sign*j;
            }else break;

        }
        return num;
    }
}
