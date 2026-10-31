class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;
        for (String event : events) {
            char c = event.charAt(0);
            if (c >= '0' && c <= '9') {
                score += c - '0';
            } else if (event.equals("W")) {
                if (++counter == 10) {
                    break;
                }
            } else {
                score++;
            }
        }
        return new int[] {score, counter};
    }
}