public class JlargestRectangleArea {

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
    public static int largestRectangleArea(int[] height) {

        int i = 0;
        int j = 0;
        int k = 0;
        int w = 0;
        int max = 0;
        //No.1
        //开始写代码，请在这里写入你的代码。
        for (i = 0; i < height.length; i++){
            if(height[i] > height[max]){
                max = i;
            }
        }
        return height[max];










        //end_code
    }
}