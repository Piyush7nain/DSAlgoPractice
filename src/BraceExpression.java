import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExpression {
    public static void main(String[] args) {
        BraceExpression t = new BraceExpression();
        t.expand("{a,b}cde{f,g,h}ij{k}");
    }

    public String[] expand(String s) {
        List<List<String>> sets = new ArrayList<>();
        int i = 0;
        char[] carr = s.toCharArray();
        while (i < carr.length) {
            if (carr[i] == '{') {
                i++;
                List<String> list = new ArrayList<>();
                while (i < carr.length && carr[i] != '}') {
                    if(carr[i]!=',') {
                        list.add(String.valueOf(carr[i]));
                    }
                    i++;
                }
                sets.add(list);
                i++;
            } else {
                List<String> list2 = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                while (i < carr.length && carr[i] != '{') {
                    sb.append(carr[i]);
                    i++;
                }
                list2.add(sb.toString());
                sets.add(list2);
            }

        }

        List<String> ans = new ArrayList<>();
        join(sets,"", 0, ans );
        Collections.sort(ans);
        return ans.toArray(new String[0]);

    }

    void join(List<List<String>> sets, String sb, int curr, List<String> ans){

        if(curr ==sets.size()){
            ans.add(sb);
            return;
        }

        for(String str : sets.get(curr) ){
            join(sets,sb+str, curr +1, ans );
        }
    }
}
