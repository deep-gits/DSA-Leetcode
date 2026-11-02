class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int count = 0;
        boolean inComponent = false;
        ListNode curr = head;
        
        while (curr != null) {
            if (set.contains(curr.val)) {
                if (!inComponent) {
                    count++;
                    inComponent = true;
                }
            } else {
                inComponent = false;
            }
            curr = curr.next;
        }
        
        return count;
    }
}