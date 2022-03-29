public class PairOfSongs {
    /**
     * a+b) % 60=0
     * ⇓
     * ((a % 60)+(b % 60)) % 60=0
     * ⇓
     * Therefore, either {
     * a % 60 && b % 60 ==0
     * or (a % 60)+(b % 60)=60
     *
     * */
    public int numPairsDivisibleBy60(int[] times) {
        int[] freq = new int[60];
        int time;
        int ans =0;
        int rem;
        for(int i =  0; i<times.length;i++){
            time = times[i];
            if(time%60 ==0){
                rem = 0;
            }else
                rem = (60 - time%60);
            ans = ans + freq[rem];
            freq[time%60]++;
        }
        return ans;
    }
}
