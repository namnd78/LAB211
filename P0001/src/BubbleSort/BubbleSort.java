/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BubbleSort;

import java.util.Random;
import java.util.Scanner;

/**
 * G33
 *
 * @author 10 pro 64bit
 */
public class BubbleSort {

    public static void main(String[] args) {
        //1. Require user to enters a positive decimal number
        int arraySize = inputPositiveDecimal("Enter number of array:");
        //2. Create an array by generating random integers in number range
        int[] array = createArray(arraySize);
//        int[] array = {5, 1, 12, -5, 16};// test case
        //3. display array before sorting
        display("Unsorted array: ", array);
        //4. Sort array using bubble sort
        bubbleSort(array);
        //5. display array after sorting
        display("Sorted array: ", array);
    }

    private static int inputPositiveDecimal(String message) {
        Scanner sc = new Scanner(System.in);
        double arraySize;
        String input;
        // Require user to enter input until get a positive integer
        do {
            System.out.println(message);
            input = sc.nextLine();
            // Check input must not be empty
            if (input.isEmpty()) {
                System.out.println("Input could not be empty. Please try again!");
                continue;
            } else {
                try {
                    arraySize = Double.parseDouble(input);
                    // Check inputed array size must be integer
                    if ((int) arraySize != arraySize) {
                        System.out.println("Input could not be real number. Please try again!");
                        continue;
                    } // Check array size must be positive integer
                    if ((int) arraySize > 0) {
                        break;
                    } else {
                        System.out.println("Input could not be <= 0. Please try again!");
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Input could not be string. Please try again!");
                }
            }
        } while (true);
        return (int) arraySize;
    }

    private static int[] createArray(int arraySize) {
        int[] array = new int[arraySize];
        Random random = new Random();
        // Loop to genarate random integers in number range for each array element
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(arraySize);
        }
        return array;
    }

    private static void display(String message, int[] array) {
        System.out.print(message);
        System.out.print("[");
        // Loop to access and display each array element
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            // Check index of array element to display comma
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        // Check string to display
        if (message.equals("Unsorted array: ")) {
            System.out.println("]");
        } else {
            System.out.print("]");
        }
    }

    private static void bubbleSort(int[] array) {
        boolean swapped;
        /* Loop to access from the first to the element before the last 
        array element, one element is sorted after each loop*/
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            /* Loop to access from the first unsorted element to the element 
            before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                // display each step to test algorithm
//                display(array, "");
                // Compare each pair of adjacent elements
                if (array[j] > array[j + 1]) {
                    // test algorithm
//                    System.out.println("\t" + array[j] + " > " + array[j + 1] + ", swap");
                    // swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                } else {
                    // test algorithm
//                    System.out.println("\t" + array[j] + " < " + array[j + 1] + ", ok");
                }
            }
            // Check if any sorting is done to exit loop
            if (swapped == false) {
                break;
            }
        }
    }
}
