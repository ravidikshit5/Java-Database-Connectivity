public class BinarySearch {
    static int binarySearch(int[] arr,int start,int end,int target){

        while(start<=end){
            int mid = (start+end)/2;
           if(arr[mid]==target) {
               return mid;
           } else if (arr[mid]>target) {
               end=mid-1;
               return end;
           }else{
               start = mid+1;
               return start;
           }
        }

        return -1;
    }
    public static void main(String args[]){
       int[] arr = {1,2,3,4,5,6,7,8};
       int start = arr[0];
       int end = arr[arr.length-1];
       int target = 8;
       int n1 = binarySearch(arr,start,end,target);
        System.out.println("Index of the target element is "+n1);
    }
}
