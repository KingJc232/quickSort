/** 
 * File: Main.java
 * Goal: To Implement the Quick Sort Algorithm 
 * */

public class Main
{
    public static void main(String[] args)
    {
        
        int[] arr = {5,3,1,-2,4};

        print(arr, "Before");
        
        quickSort(arr, 0, arr.length-1); //Sorting the Array Using Quick Sort 

        print(arr, "\n\nAfter Quick Sort");

    }
    /**
     * Sorts an integer array using the quickSort Algorithm and Recursion 
     * @param arr
     * @param start 
     * @param end
     * @return void 
     * */
    public static void quickSort(int[] arr, int start, int end)
    {
        //Base Case If Array of 1 element or less then return because already SORTED 
        if(start >= end)
            return ; 
        
        //ELSE array bigger then 1 element 
        int pivotIndex = partition(arr, start, end); //Partition the ARRAY 
        
        //Quick Sorting from the start to then pivot-1 ("Left Side")
        quickSort(arr, start, pivotIndex -1);
        //Quick Sorting from the pivot+1 to the end ("Right Side")
        quickSort(arr, pivotIndex+1, end); 

    }

    private static int partition(int[] arr, int start, int end)
    {
        //Selecting a Pivot Point typically the last element in the array 
        int pivot = arr[end]; 
        int pIndex = start; //This is the partition Index the index we are going to swap the pivot with at the end of sort 

        //Going to partition all elements except the last one because thats our pivot 
        for(int i = start; i < end; i++)
        {
            if(arr[i] < pivot)
            {
                //Swapping the arr[i] and arr[pIndex] since arr[i] less than pivot 
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp; 
                pIndex++; //Increasing the Partition Index 
            }
        }
        //Swapping the Pivot with arr[pIndex]
        arr[end] = arr[pIndex]; //Updating the last element  
        arr[pIndex] = pivot; //Placing the pivot in its approiate location 

        return pIndex; 
    }

    public static void print(int[] arr, String beforeMsg)
    {
        String answer = "[ ";  
        String comma = "";
        for(int element : arr)
        {
            answer += comma + element;
            comma = " , ";
        }
        answer += " ]";
        System.out.println(beforeMsg + " : \n" + answer);
    }


}


