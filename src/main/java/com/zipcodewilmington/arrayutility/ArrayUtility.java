package com.zipcodewilmington.arrayutility;

import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;

    public ArrayUtility(T[] inputArray){
        array = inputArray;
    }

    private T[] merge(T[] arrayToMerge){
        Object[] newArr = new Object[arrayToMerge.length + array.length];
        //Merge arrays to make a new merged array
        System.arraycopy(array, 0, newArr, 0, array.length);
        System.arraycopy(arrayToMerge, 0, newArr, 0, arrayToMerge.length);

        return (T[]) newArr;
    }
    public Integer countDuplicatesInMerge(Integer[] arrayToMerge, Integer valueToEvaluate) {
        //Merge arrayToMerge with array created in field;
        T[] newArr = merge((T[]) arrayToMerge);

        return getNumberOfOccurrences(valueToEvaluate, newArr);
    }

    public T[] removeValue(Integer valueToRemove) {
        int i = 0;
        for(int j = 0; i < array.length; j++){
            if(!array[j].equals(valueToRemove)){
                array[i++] = array[j];
            }
        }
        array = Arrays.copyOf(array, i);

        return array;
    }

    private Integer getNumberOfOccurrences(Integer valueToEvaluate, T[] array) {
        int count = 0;
        for(T t : array){
            if(t == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        return getNumberOfOccurrences((Integer) valueToEvaluate, array);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] newArray = merge(arrayToMerge);  // Merges arrayToMerge with array initialized in the constructor
        T mostCommon = newArray[0];
        int maxNum = Integer.MIN_VALUE;

        for(T t : newArray){
            int currentNumOccurrences = getNumberOfOccurrences((Integer) t, newArray);
            if(currentNumOccurrences > maxNum){
                mostCommon = t;
                maxNum = currentNumOccurrences;
            }
        }
        return mostCommon;
    }
}