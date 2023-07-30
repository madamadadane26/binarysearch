import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {

    public static void main(String[] args) {


        String[] asWords = new String[10];
        String sTarget = "Maria";

        asWords[0] = "Frank";
        asWords[1] = "Dave";
        asWords[2] = "Bonnie";
        asWords[3] = "Jessica";
        asWords[4] = "Clyde";
        asWords[5] = "Sebastian";
        asWords[6] = "Annie";
        asWords[7] = "Maria";
        asWords[8] = "Jack";
        asWords[9] = "Mo";


        // sort the array using the Arrays object
        Arrays.sort(asWords);

        // check if binary search works
 //        int iIndexFound = findNumberBinarySearch(aiNums, iTargetNum, 0, aiNums.length - 1);
 //        System.out.println("Target num index: " + iIndexFound);
 //       System.out.println("Number in array at this index: " + aiNums[iIndexFound]);
 //       System.out.println("Target number that should equal above: " + iTargetNum);


        int iIndexFound;
        long startTime;
        long elapsedTime;

        // ***** BEGIN Binary Search timing
        // *************************************************************

        startTime = System.nanoTime();

        iIndexFound = findStringBinarySearch(asWords, sTarget, 0, asWords.length - 1);

        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Binary Search Time: " + elapsedTime);

        // *************************************************************
        // ***** END Binary Search timing



        // ***** BEGIN Linear Search timing
        // *************************************************************

        startTime = System.nanoTime();

        iIndexFound = findStringLinearSearch(asWords, sTarget);

        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Linear Search Time: " + elapsedTime);


        // *************************************************************
        // ***** END Linear Search timing



    }


    //return the number of index you give in. Refines the number it sits at. Return an int
    // recursive binary search of target number and returns that number index in the array.
    private static int findStringBinarySearch(String [] sArray, String sTarget, int iLow, int iHigh){

        // find the middle index of the range
        int iMiddleIndex = (iHigh + iLow) / 2;

        // check if number at middle index is the target number
        if(sTarget.equals(sArray[iMiddleIndex])) {
            return iMiddleIndex;
            // returns middle index
        }

        // Else if target number is greater than number at middle index
        else if(sTarget.compareTo(sArray[iMiddleIndex]) > 0){
            // Call this method recursively
            return findStringBinarySearch(sArray, sTarget, iMiddleIndex + 1, iHigh);

        }

        // Else the target number is less than number at middle index
        else {
            return findStringBinarySearch(sArray, sTarget, iLow, iMiddleIndex - 1);
        }

    }
    // perform linear search to find index of target number
    private static int findStringLinearSearch(String [] sArray, String sTarget){

        // create a for loop and look for target num in arry
        for (int i = 0; i < sArray.length; i++){
            if (sTarget.equals(sArray[i]))
            {
                return i;
            }

        }

        return -1;


    }


}
