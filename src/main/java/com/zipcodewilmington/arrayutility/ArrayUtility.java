package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
//    T[] array;
//
//    public ArrayUtility(T[] inputArray){
//        array = inputArray;
//    }
//
//    private T[] merge(T[] arrayToMerge){
//        Object[] newArr = new Object[arrayToMerge.length + array.length];
//        //Merge arrays to make a new merged array
//        System.arraycopy(arrayToMerge, 0, newArr, 0, arrayToMerge.length);
//        System.arraycopy(array, 0, newArr, 0, array.length);
//
//        return (T[]) newArr;
//    }
//    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
//        //Merge arrayToMerge with array created in field;
//        T[] newArr = merge(arrayToMerge);
//
//        return getNumberOfOccurrences(valueToEvaluate, newArr);
//    }
//
//    public T[] removeValue(T valueToRemove) {
//        int i = 0;
//        for(int j = 0; i < array.length; j++){
//            if(!array[j].equals(valueToRemove)){
//                array[i++] = array[j];
//            }
//        }
//        array = Arrays.copyOf(array, i);
//
//        return array;
//    }
//
//    private Integer getNumberOfOccurrences(T valueToEvaluate, T[] array) {
//        int count = 0;
//        for(T t : array){
//            if(t == valueToEvaluate){
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public Integer getNumberOfOccurrences(T valueToEvaluate){
//        return getNumberOfOccurrences(valueToEvaluate, array);
//    }
//
//    public T getMostCommonFromMerge(T[] arrayToMerge) {
//        T[] newArray = merge(arrayToMerge);  // Merges arrayToMerge with array initialized in the constructor
//        T mostCommon = newArray[0];
//        int maxNum = Integer.MIN_VALUE;
//
//        for(T t : newArray){
//            int currentNumOccurrences = getNumberOfOccurrences(t, newArray);
//            if(currentNumOccurrences > maxNum){
//                mostCommon = t;
//                maxNum = currentNumOccurrences;
//            }
//        }
//        return mostCommon;
//    }
T[] array;

    public ArrayUtility(T[] inputArray) {
        array = inputArray;
    }

    private T[] merge(T[] arrayToMerge){
        Object[] newArr = new Object[arrayToMerge.length + array.length];

        // Combine the two arrays into the newArr
        System.arraycopy(arrayToMerge,0,newArr,0,arrayToMerge.length);
        System.arraycopy(array, 0, newArr, arrayToMerge.length, array.length);

        return (T[]) newArr;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        // Merge arrayToMerge with array created in the constructor
        T[] newArr = merge(arrayToMerge);

        // Find number of times valueToEvaluate occurs
        return getNumberOfOccurrences(valueToEvaluate, newArr);
    }

    public T[] removeValue(T valueToRemove) {
        int i = 0;
        for(int j = 0; j < array.length; j++ ){
            if(!array[j].equals(valueToRemove)){
                array[i++] = array[j]; // Put array[j] at array[i] then increase i by 1
            }
        }
        array = Arrays.copyOf(array, i); // Shrink array to the size of array - number of times
        // Value to remove occurs
        return array;
    }

    private Integer getNumberOfOccurrences(T valueToEvaluate, T[] array){
        int total = 0;
        for(T t : array){
            if(t == valueToEvaluate){
                total += 1;
            }
        }
        return total;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return getNumberOfOccurrences(valueToEvaluate, array);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] newArray = merge(arrayToMerge);  // Merges arrayToMerge with array initialized in the constructor
        T mostCommon = newArray[0];
        int maxNum = Integer.MIN_VALUE;

        for(T t : newArray){
            int currentNumOccurrences = getNumberOfOccurrences(t, newArray);
            if(currentNumOccurrences > maxNum){
                mostCommon = t;
                maxNum = currentNumOccurrences;
            }
        }
        return mostCommon;
    }
}