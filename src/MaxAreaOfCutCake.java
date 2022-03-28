import java.util.Arrays;

public class MaxAreaOfCutCake {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        int ph = 0;
        int ch = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHeight =0;
        for(int i =0;i<=horizontalCuts.length;i++){
            ch = (i== horizontalCuts.length)?h:horizontalCuts[i];
            maxHeight = Math.max(maxHeight, ch -ph);
            ph = ch;
        }
        long maxWidth =0;
        ph =0;
        for(int i =0;i<=verticalCuts.length;i++){
            ch = (i== verticalCuts.length)?w:verticalCuts[i];
            maxWidth = Math.max(maxWidth, ch -ph);
            ph = ch;
        }

        return (int) ((maxHeight*maxWidth )%(1000000007));
    }

}
