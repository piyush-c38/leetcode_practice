class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        
        for (int ele : nums) {
            numFreq.put(ele, numFreq.getOrDefault(ele, 0) + 1);
        }
        
        int maxFreq = 0;
        for (int freq : numFreq.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        
        int maxSum = 0;
        for (int freq : numFreq.values()) {
            if (freq == maxFreq) {
                maxSum += freq;
            }
        }
        
        return maxSum;
    }
}