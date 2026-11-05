class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList<>();
        int i = num.length - 1;
        int carry = 0;
        
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i--];
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            carry = sum / 10;
            res.add(0, sum % 10);
        }
        
        return res;
    }
}