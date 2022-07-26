// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

// Constraints:

// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
// Accepted
// 1,492,714
// Submissions
// 4,311,876
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1) return findMedianSortedArrays(nums2,nums1);//to make sure that binary search will happen on the smaller size array
        int l =0,r =n1;//pointers on the smaller array
        while(l<=r){
            int cut1 = (l+r)/2;//median for smaller array
            int cut2 =(n1+n2+1)/2 - cut1;//second cut will be according to the size of both araay this formula works for both even as well as odd size
            
            //l1 &l2 will be on 1 index behind the cut or if cut is on 0index then it will be MIN VELUE
            int l1 = cut1==0 ?Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = cut2==0 ?Integer.MIN_VALUE : nums2[cut2-1];
            
            //l1 &l2 will be on the index of the cut or if cut is on the last index then it will be MAX VELUE
            int r1 =cut1 ==n1 ?Integer.MAX_VALUE :nums1[cut1];
            int r2 =cut2 ==n2 ?Integer.MAX_VALUE :nums2[cut2];
            
            //If condition verifies
            if(l1<=r2&&l2<=r1){
                if((n1+n2)%2==0){//total is even 
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }//total is odd
                else return Math.max(l1,l2);
            }
            //for rest of invalid condition
            
            else if(l1>r2) r=cut1-1;//mid sifted to left
            else l=cut1+1;//mid sifted to right
        }
        return 0.0;
    }
}