public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(floorSqrt(9));
    }

    static long floorSqrt(long x)
    {
        if(x==1) return 1;
        if(x ==2) return 1;
        if(x==3) return 1;
        //return binarySearchUpwards(x, 2, 4);
        return  binarySearchDownward(x, 1, x);
    }

    static long binarySearchUpwards(long x, long start, long end){

        if(start+1 == end)
            if(end*end<=x) return end;
            else return start;

        long start2 = start*start;
        long end2 = end*end;

        if(start2==x) return start;
        if(end2==x) return end;
        long mid = (start2+end2)/2;
        if(x<=mid)
            return binarySearchUpwards(x, start, (start+end)/2);
        else if(mid<x && x<end2 )
            return binarySearchUpwards(x, (start+end)/2, end);
        else
            return binarySearchUpwards(x, end, end*2);

    }

    static long binarySearchDownward(long x, long start, long end){
        if(start>end)
            return end;
        long mid = (start+end)/2;
        if(mid*mid == x) return mid;
        else if(x>mid*mid)
            return binarySearchDownward(x, mid+1, end);
        else
            return binarySearchDownward(x, start, mid-1);


    }
}

