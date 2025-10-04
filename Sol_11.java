class Sol_11 {
    public int maxArea(int[] height) {
        int left = 0;                   // start pointer
        int right = height.length - 1;  // end pointer
        int maxArea = 0;

        // Loop until both pointers meet
        while (left < right) {
            // Calculate area between the two lines
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            // Update max area if current one is larger
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
