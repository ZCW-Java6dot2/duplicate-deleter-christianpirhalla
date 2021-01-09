package com.zipcodewilmington.looplabs;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    public boolean findIfEligibleForDeletionExact(int value, int numberOfDuplications){
        int counter = 0;
        for (int i : array){
            if (value == i) { counter++; }
        }
        if (counter == numberOfDuplications) {return true;}
        return false;
    }

    public boolean findIfEligibleForDeletion(int value, int numberOfDuplications) {
        int counter = 0;
        for (int i : array) {
            if (value == i) { counter++; }
        }
        if (counter >= numberOfDuplications) { return true; }
        return false;
    }

    @Override
    public Integer[] removeDuplicates(int numberOfDuplications) {
        int[] duplicates = new int[0];

        for (int i = 0; i < array.length; i++){
            if (findIfEligibleForDeletion(array[i], numberOfDuplications)){
                int[] newDuplicates = new int[duplicates.length+1];
                for (int j = 0; j < duplicates.length; j++){
                    newDuplicates[j] = duplicates[j];
                }
                newDuplicates[newDuplicates.length-1] = array[i];
                duplicates = newDuplicates;
            }
        }

        Integer[] alteredArray = new Integer[0];
        for (int i = 0; i < array.length; i++){

            if (determineIfDuplicate(duplicates, array[i])) {continue;}

            Integer[] newArray = new Integer[alteredArray.length+1];
            for (int k = 0; k < alteredArray.length; k++){
                newArray[k] = alteredArray[k];
            }
            newArray[newArray.length-1] = array[i];
            alteredArray = newArray;
        }

        for (int i : duplicates) {
            System.out.print("["+i+"]");
        }
        return alteredArray;

    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int[] duplicates = new int[0];
        if (exactNumberOfDuplications == 0) return array;
        for (int i = 0; i < array.length - (exactNumberOfDuplications - 1); i++){
            if (findIfEligibleForDeletionExact(array[i], exactNumberOfDuplications)){
                int[] newDuplicates = new int[duplicates.length+1];
                for (int j = 0; j < duplicates.length; j++){
                    newDuplicates[j] = duplicates[j];
                }
                newDuplicates[newDuplicates.length-1] = array[i];
                duplicates = newDuplicates;
            }
        }

        Integer[] alteredArray = new Integer[0];
        for (int i = 0; i < array.length; i++){

            if (determineIfDuplicate(duplicates, array[i])) {continue;}

                Integer[] newArray = new Integer[alteredArray.length+1];
                for (int k = 0; k < alteredArray.length; k++){
                    newArray[k] = alteredArray[k];
                }
                newArray[newArray.length-1] = array[i];
                alteredArray = newArray;
            }

        for (int i : duplicates) {
            System.out.print("["+i+"]");
        }
        return alteredArray;

    }

    public boolean determineIfDuplicate(int[] duplicates, int number){
        for (int j = 0; j < duplicates.length; j++){
            if (duplicates[j] == number) { return true;}
        }
        return false;
    }
}
