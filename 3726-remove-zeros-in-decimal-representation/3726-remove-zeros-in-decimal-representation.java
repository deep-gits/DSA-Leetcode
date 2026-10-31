class Solution {
    public long removeZeros(long n) {
        if (n == 0) return 0;
        boolean isNeg = n < 0;
        String s = String.valueOf(Math.abs(n));
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '0') {
                sb.append(c);
            }
        }
        if (sb.length() == 0) return 0;
        long res = Long.parseLong(sb.toString());
        return isNeg ? -res : res;
    }
}