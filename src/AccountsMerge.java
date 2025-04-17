import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
    /**
     * https://leetcode.com/problems/accounts-merge/description/
     * */

    //hashsets
    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        Map<String, List<Set<String>>> maps = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            if(maps.containsKey(name)) {
                List<Set<String>> sets = maps.get(name);
                HashSet<String> newSet = new HashSet<>(account.subList(1, account.size()));
                List<Set<String>> newSets = new LinkedList<>();
                newSets.add(newSet);
                List<Set<String>> oldSets = new LinkedList<>(sets);
                for (Set<String> set : oldSets) {
                    for(String e: account.subList(1, account.size())) {
                        if(set.contains(e)) {
                            sets.remove(set);
                            newSets.add(set);
                        }
                    }
                }
                Set<String> mergedSet = new HashSet<>();
                for(Set<String> set: newSets) {
                    mergedSet.addAll(set);
                }
                maps.get(name).add(mergedSet);
            }else{
                Set<String> set = new HashSet<>(account.subList(1, account.size()));
                List<Set<String>> sets = new LinkedList<>();
                sets.add(set);
                maps.put(name, sets);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<Set<String>>> entry : maps.entrySet()) {

            for(Set<String> set : entry.getValue()) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());

                list.addAll(set.stream().sorted().toList());
                result.add(list);
            }
        }

        return result;
    }

    class Node{
        String name;
        Set<String> emails;
        List<Node> children;
        public Node(String name, Set<String> emails) {
            this.name = name;
            this.emails = emails;
            children = new LinkedList<>();
        }
        public Node(String name) {
            this.name = name;
            this.emails = new HashSet<>();
            children = new LinkedList<>();
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Node> map = new HashMap<>();
        Deque<Node> nodes = new LinkedList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            Node node = new Node(name, new HashSet<>(account.subList(1, account.size())));
            boolean isRoot = true;
            for(String e: account.subList(1, account.size())){
                if(map.containsKey(e) && map.get(e).name.equals(name) && map.get(e)!=node) {
                    map.get(e).children.add(node);
                    node.children.add(map.get(e));
                    map.get(e).emails.remove(e);
                    isRoot = false;
                }
                map.put(e, node);
            }
            nodes.addLast(node);

        }
        List<List<String>> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        while(!nodes.isEmpty()) {
            Node node = nodes.removeFirst();
            if(!visited.contains(node)) {
                List<String> list = new ArrayList<>();
                list.add(node.name);
                dfs(node, visited, list);
                Collections.sort(list.subList(1, list.size()));
                result.add(list);
            }

        }
        return result;
    }

    void dfs(Node node, Set<Node> visited, List<String> list){
        if(node==null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        list.addAll(node.emails);

        for(Node child: node.children) {
            dfs(child, visited, list);
        }
    }
    private void mergeOldNodes(Set<Node> nodes, List<Node> oldNodes) {
        oldNodes.forEach(nodes::remove);
        Node newNode = new Node(oldNodes.get(0).name);
        for(Node node : oldNodes) {
            newNode.emails.addAll(node.emails);
        }
        nodes.add(newNode);
    }

    /*
    * [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],
    * ["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],
    * ["David","David1@m.co","David2@m.co"]]
    * */
    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts = List.of(
                List.of("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"),List.of("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"),List.of("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"),List.of("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"),List.of("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
//                List.of("David","David0@m.co","David1@m.co"),
//                List.of("David","David3@m.co","David4@m.co"),
//                List.of("David","David4@m.co","David5@m.co"),
//                List.of("David","David2@m.co","David3@m.co"),
//                List.of("David","David1@m.co","David2@m.co")
//                );
        System.out.println(accountsMerge.accountsMerge(accounts));
    }
}
