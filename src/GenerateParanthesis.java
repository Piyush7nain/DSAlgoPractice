import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    List<String> ans;

    public static void main(String[] args) {
        GenerateParanthesis temp = new GenerateParanthesis();
        temp.generateParenthesis(2);
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        backTrack(1, 0,sb.append("(") , n);

        return ans;
    }

    void backTrack(int os, int es, StringBuilder sb, int n){
        if( os == n && es == n){
            ans.add(sb.toString());
            return;
        }
        if(os<es)
            return;

        if(os<n){
            backTrack(os+1,es, sb.append("("), n );
            sb.deleteCharAt(sb.length()-1);
        }
        if(es<n){
            backTrack(os,es+1, sb.append(")"), n );
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
