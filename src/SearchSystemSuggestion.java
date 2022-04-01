import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSystemSuggestion {
    public static void main(String[] args) {
        SearchSystemSuggestion temp = new SearchSystemSuggestion();
        //temp.suggestedProducts(new String[]{"bat", "book","breath", "bomb","brag", "cat", "dat", "data", "datum", "math", "mouse","more" ,"mat", "mill"}, "book");
        temp.suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"},"bags");
    }
    int binaryStringSearchFirst(String [] products, int start,int end, char c, int ind){

        int i = start; int j = end;  int mid;
        while(i<j){

            mid = (i+j)/2;
            if(products[mid].charAt(ind)>=c)
                j= mid;
            else
                i=mid +1;
        }
        return i;

    }
    int binaryStringSearchLast(String [] products, int start,int end, char c, int ind){

        int i = start; int j = end;  int mid;
        while(i<j){

            mid = (i+j)/2;
            if(products[mid].charAt(ind)>c)
                j= mid-1;
            else
                i=mid+1;
        }
        return j;

    }
    /**
     * The solution is to sort the products array and do a binary search to find the first word
     * that matches the curr substring of the searchWord. And the taking the next 3 words into
     * consideration and adding the relevant once to the list.
     * This can be made even faster if for each binary search we find the first as well the
     * last index of matching words to reduce the time for the next binary search.
     *
     * */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        String prefix = "";
        char[] carr = searchWord.toCharArray();
        int start =0;
        int end = products.length;
        for(int i = 0;i<carr.length;i++){
            prefix = prefix + carr[i];
            start = binaryStringSearchFirst(products, start,end,carr[i], i);
            end = binaryStringSearchLast(products, start,end,carr[i], i);
            List<String> list = new ArrayList<>();
            for(int j = start; j < Math.min(start+3,end);j++){

                if(products[j].length()>=prefix.length() && products[j].substring(0, prefix.length()).compareTo(prefix)==0 )
                    list.add(products[j]);

            }
            ans.add(list);

        }
        return ans;
    }
}
