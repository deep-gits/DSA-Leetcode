class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long totalShift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26;
            chars[i] = (char) ('a' + (chars[i] - 'a' + totalShift) % 26);
        }
        return new String(chars);
    }
}