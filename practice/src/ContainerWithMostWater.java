public class ContainerWithMostWater {
    int maxVol = 0;

    public int maxArea(int[] height) {
        int i = 0;
        int n = height.length;
        int j = n - 1;
        while (j > i) {
            int heightOfContainer = Math.min(height[i], height[j]);
            int breadthOfContainer = Math.abs(j - i);
            int currentVol = heightOfContainer * breadthOfContainer;
            maxVol = Math.max(maxVol, currentVol);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxVol;
    }
}
