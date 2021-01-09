package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    public boolean findIfEligibleForDeletionExact(String value, int numberOfDuplications){
        int counter = 0;
        for (String i : array){
            if (value.equals(i)) { counter++; }
        }
        if (counter == numberOfDuplications) {return true;}
        return false;
    }

    public boolean findIfEligibleForDeletion(String value, int numberOfDuplications){
        int counter = 0;
        for (String i : array){
            if (value.equals(i)) { counter++; }
        }
        if (counter >= numberOfDuplications) {return true;}
        return false;
    }

    public boolean determineIfDuplicate(String[] duplicates, String value){
        for (int j = 0; j < duplicates.length; j++){
            if (duplicates[j].equals(value)) { return true;}
        }
        return false;
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] duplicates = new String[0];

        for (int i = 0; i < array.length; i++){
            if (findIfEligibleForDeletion(array[i], maxNumberOfDuplications)){
                String[] newDuplicates = new String[duplicates.length+1];
                for (int j = 0; j < duplicates.length; j++){
                    newDuplicates[j] = duplicates[j];
                }
                newDuplicates[newDuplicates.length-1] = array[i];
                duplicates = newDuplicates;
            }
        }

        String[] alteredArray = new String[0];
        for (int i = 0; i < array.length; i++){

            if (determineIfDuplicate(duplicates, array[i])) {continue;}

            String[] newArray = new String[alteredArray.length+1];
            for (int k = 0; k < alteredArray.length; k++){
                newArray[k] = alteredArray[k];
            }
            newArray[newArray.length-1] = array[i];
            alteredArray = newArray;
        }

        for (String i : duplicates) {
            System.out.print("["+i+"]");
        }
        return alteredArray;

    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] duplicates = new String[0];
        if (exactNumberOfDuplications == 0) return array;
        for (int i = 0; i < array.length - (exactNumberOfDuplications - 1); i++){
            if (findIfEligibleForDeletionExact(array[i], exactNumberOfDuplications)){
                String[] newDuplicates = new String[duplicates.length+1];
                for (int j = 0; j < duplicates.length; j++){
                    newDuplicates[j] = duplicates[j];
                }
                newDuplicates[newDuplicates.length-1] = array[i];
                duplicates = newDuplicates;
            }
        }

        String[] alteredArray = new String[0];
        for (int i = 0; i < array.length; i++){

            if (determineIfDuplicate(duplicates, array[i])) {continue;}

            String[] newArray = new String[alteredArray.length+1];
            for (int k = 0; k < alteredArray.length; k++){
                newArray[k] = alteredArray[k];
            }
            newArray[newArray.length-1] = array[i];
            alteredArray = newArray;
        }

        for (String i : duplicates) {
            System.out.print("["+i+"]");
        }
        return alteredArray;

    }
}
