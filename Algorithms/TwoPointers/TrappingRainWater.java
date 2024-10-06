package Algorithms.TwoPointers;

/**
 * <pre>
 * reed trapMyThoughts() documentation at below



    3                                              ********
    |                                              *      *  ❌    ❌    ❌     ❌
    |                                              *      * 
    2                  ********                    *      ********      ********
    |                  *      *                    *      *      *      *      *
    |                  *      *   💧    💧    💧  *      *      * 💧  *      *  ❌
    |                  *      *                    *      *      *      *      *
    1     ********      *      ********      ********      *      ********      ********
    | ❌ *      *  💧  *      *      * 💧  *      *      *      *      *      *      *
    |____ 0 ____ 1 ____ 0 ____ 2 ____ 1 ____ 0 ____ 1 ____ 3 ____ 2 ____ 1 ____ 2 ____ 1
    0i    1i     2i     3i     4i     5i     6i     7i     8i     9i     10i    11i    12i

</pre>
 * @author Srinvas Vadige
 * @since 02 Oct 2024
*/
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    // l at 0, r at length - 1
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) { // to avoid right most overflow ❌ in the diagram
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;        
    }

    public static int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += Math.min(leftMax, height[left]) - height[left];
                left++;
            } else {    
                rightMax = Math.max(rightMax, height[right]);
                total += Math.min(rightMax, height[right]) - height[right];
                right--;
            }
        }
        return total;
    }

    /**
     * <pre>
        water stagnates only if lh>rh upto lh<=rh
        need bigger heights 
        calculate hight diffs in each r loop with current l
        scenario is changing after r == height.length-1

        If we move both pointers to right side 
        And now let's the r pointer just passed the biggest of all heights 
        then we are keeping that biggest height as l
        Once we reached lh <= rh it makes us count the dummies even if we don't have lh <= rh height

        So, it's better to start with two pointers l == 0 and r == n-1
        And loop untill l index < r index by moving both pointers at once and
        have lMax height and rMax height.
        or l=0 and r=0 with lMax and rMax
    </pre>
    */
    public static int trapMyThoughts(int[] height) {
        
        int l = 0, r =1;

        int units = 0;
        
        int tempUnits = 0; // as we are not sure if we have bigger r in future
        //int tempHeight = 0; // my thoughts on this
        while(l < height.length){

            System.out.println("l:" +l + ", r:" + r);

            if(height[l]>height[r]){                
                tempUnits += height[l]-height[r];
                System.out.println("inside tempUnits: " + tempUnits);
            }

            if(height[l] <= height[r]){
                units += tempUnits;
                tempUnits=0;
                l = r;
                System.out.println("--------- inside Units: " + units);    
            }
            if (r < height.length-1)
                r++;
            else l++;
        }

        return units;
    }
}
