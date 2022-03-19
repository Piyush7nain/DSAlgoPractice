public class ReverseInt {
//    Given a signed 32-bit integer x, return x with its digits reversed.
//    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
        public int reverse(int n) {

            int rev = 0;
            while(n!=0){

                int pop = n%10;
                n = n/10;

                if(rev>0 && (rev> (Integer.MAX_VALUE/10) || (rev== Integer.MAX_VALUE/10 && pop >Integer.MAX_VALUE%10 ) ) )
                    return 0;
                if(rev<0 && (rev< (Integer.MIN_VALUE/10) || (rev== Integer.MIN_VALUE/10 && pop <Integer.MIN_VALUE%10) ) )
                    return 0;

                rev =rev*10 + pop;


            }

            return rev;
        }
}
