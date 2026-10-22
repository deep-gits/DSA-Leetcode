class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int maxTime = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;
                    int l = 6 - i - j - k;

                    int hours = arr[i] * 10 + arr[j];
                    int minutes = arr[k] * 10 + arr[l];

                    if (hours < 24 && minutes < 60) {
                        maxTime = Math.max(maxTime, hours * 60 + minutes);
                    }
                }
            }
        }

        if (maxTime == -1) {
            return "";
        }

        return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }
}