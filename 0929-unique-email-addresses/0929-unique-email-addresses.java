class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            int splitIdx = email.indexOf('@');
            String local = email.substring(0, splitIdx);
            String domain = email.substring(splitIdx);
            
            int plusIdx = local.indexOf('+');
            if (plusIdx != -1) {
                local = local.substring(0, plusIdx);
            }
            local = local.replace(".", "");
            
            uniqueEmails.add(local + domain);
        }
        return uniqueEmails.size();
    }
}