import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PartitionLabels {

    //https://leetcode.com/problems/partition-labels/description/

    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        int[][] map = new int[26][2];
        for (int i = 0; i < map.length; i++) {
            map[i] = new int[]{-1, -1};
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map[c - 'a'][0] == -1){
                map[c - 'a'][0] = i;
                map[c - 'a'][1] = i;
            }else{
                map[c - 'a'][1] = i;
            }
        }

        Arrays.sort(map, Comparator.comparing(a -> a[0]));
        List<List<Integer>> partitions = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if(map[i][0] == -1){
                continue;
            }
            if(partitions.isEmpty()){
                partitions.add( new ArrayList<>(List.of(map[i][0], map[i][1])));
                continue;
            }
            List<Integer> lastPartition = partitions.get(partitions.size() - 1);
            if(map[i][0] <= lastPartition.get(1)){
                List<Integer> newPartition = new ArrayList<>(
                        List.of(
                                Math.min(map[i][0],lastPartition.get(0)),
                                Math.max(map[i][1],lastPartition.get(1))
                        ));
                partitions.set(partitions.size() - 1, newPartition);
            }else{
                List<Integer> newPartition = new ArrayList<>(List.of(map[i][0], map[i][1]));
                partitions.add( newPartition);
                result.add(lastPartition.get(1) - lastPartition.get(0) +1) ;
            }
        }
        List<Integer> lastPartition = partitions.get(partitions.size() - 1);
        result.add(lastPartition.get(1) - lastPartition.get(0) +1) ;
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        System.out.println(p.partitionLabels("ntswuqqbidunnixxpoxxuuupotaatwdainsotwvpxpsdvdbwvbtdiptwtxnnbtqbdvnbowqitudutpsxsbbsvtipibqpvpnivottsxvoqqaqdxiviidivndvdtbvadnxboiqivpusuxaaqnqaobutdbpiosuitdnopoboivopaapadvqwwnnwvxndpxbapixaspwxxxvppoptqxitsvaaawxwaxtbxuixsoxoqdtopqqivaitnpvutzchkygjjgjkcfzjzrkmyerhgkglcyffezmehjcllmlrjghhfkfylkgyhyjfmljkzglkklykrjgrmzjyeyzrrkymccefggczrjflykclfhrjjckjlmglrmgfzlkkhffkjrkyfhegyykrzgjzcgjhkzzmzyejycfrkkekmhzjgggrmchkeclljlyhjkchmhjlehhejjyccyegzrcrerfzczfelzrlfylzleefgefgmzzlggmejjjygehmrczmkrc"));
    }
}
