package com.zipcodewilmington.arrayutility;

import javax.naming.event.ObjectChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] returnedArray;


    public ArrayUtility(T[] incomingArray){
        returnedArray = incomingArray;
    }

    public T[] removeValue(T valueToRemove){
        List removedValues = Arrays.stream(returnedArray).filter(z -> z != valueToRemove).collect(Collectors.toList());
        return (T[]) removedValues.toArray(Arrays.copyOf(returnedArray, removedValues.size()));

//        T[] newArray;
//        Integer counter = 0;
//        for (T e : returnedArray){
//            if (e.equals(valueToRemove)){
//                counter++;
//            }
//        }
//
//    for(T e : newArray)
//       ArrayList<T> newList = new ArrayList<>();
//
//       for (T e : returnedArray){
//           if (!e.equals(valueToRemove)){
//                newList.add(e);
//            }
//        }
//       T[] newArray = newList.toArray();
//        return  newList.toArray(newArray) ;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
       for (T e : returnedArray){
            if (e.equals(valueToEvaluate)){
                counter++;
            }
       }
        return counter;
    }


    public T getMostCommonFromMerge(T[] arrayToMerge) {
        List<T> newList = (List<T>) Arrays.stream(arrayToMerge).collect(Collectors.toList());
        List<T> newList2 = (List<T>) Arrays.stream(returnedArray).collect(Collectors.toList());
        newList.addAll(newList2);

        Integer[] counter = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int index = 0;
        for (int i = 0; i < newList.size() -1; i++){
            for (int j =0; j < newList.size();j++){
                if(newList.get(i).equals(newList.get(j))){
                    counter[index]++;
                }
            }
            index++;
        }
        T max = null;
        Integer maximum = 0;
        for (int i= 0; i < counter.length -1; i++){
            if(counter[i] > maximum){
                max = newList.get(i);
                maximum = counter[i];
            }
        }


      return max;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer counter = 0;
        for (T e : returnedArray) {
            if (e.equals(valueToEvaluate)) {
                counter++;
            }
        }
            for (T t : arrayToMerge) {
                if (t.equals(valueToEvaluate)) {
                    counter++;
                }

            }
        return counter;
        }
}





