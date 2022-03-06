import java.util.*;

public class UniqueEmail {


    public static void main(String[] args) {
        String[] arr = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        UniqueEmail ue = new UniqueEmail();
        System.out.println(ue.numUniqueEmails2(arr));

    }

    public int numUniqueEmails2(String[] emails){
        HashSet<String> set = new HashSet<String>();
        for(String email : emails){
            String[] temp = email.split("@");
            set.add(temp[0].split("\\+")[0].replace(".","")+ "@" + temp[1]);
        }
        return set.size();
    }
    public int numUniqueEmails1(String[] emails) {
        HashMap<String, HashSet<String>> uniqueDomains = new HashMap<String, HashSet<String>>();
        for(String email: emails){
            String[] temp = email.split("@");
            String alphas = getAlphas(temp[0]);
            if(uniqueDomains.containsKey(temp[1])){
                    uniqueDomains.get(temp[1]).add(temp[0]);
            }else
                uniqueDomains.put(temp[1], new HashSet(Arrays.asList( temp[0]) ));

        }

        int nUnique = 0;

        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : uniqueDomains.entrySet()) {
            nUnique += (((Map.Entry<String,HashSet<String>>) stringHashSetEntry).getValue()).size();
        }

        return nUnique;

    }

    String getAlphas(String local){
        String sEmail = local;
        if(local.contains("+"))
            sEmail = local.substring(0, local.indexOf("+"));
        return sEmail.replace(".", "");

    }
    int getUniqueEmails(List<String> emails){

        HashSet<String> uEmail = new HashSet<>();
        for(String email: emails){
            String sEmail = email;
            if(email.contains("+"))
                sEmail = email.substring(0, email.indexOf("+"));
            sEmail = sEmail.replace(".", "");
            uEmail.add(sEmail);
        }

        return uEmail.size();

    }


}
