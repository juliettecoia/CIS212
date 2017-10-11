/*
    I used https://www.tutorialspoint.com/java/lang/system_nanotime.htm to learn more about System.nanoTime()
    I used https://www.tutorialspoint.com/java/util/java_util_arraylist.htm to learn more about the methods in the ArrayList class
    I also referenced the textbook while writing this program.

 */

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;

public class JulietteCoiaAssignment2 {

    public static void main(String[] args) {
        long[] startTime = new long[8];
        long[] realTime = new long[8];

        System.out.println("Please enter an array length: ");
        Scanner input = new Scanner(System.in);
        int arrayLength = input.nextInt();

        System.out.println("Please enter an array density between 0 and 1.0");
        Scanner in = new Scanner(System.in);
        double arrayDensity = in.nextDouble();

        if (arrayDensity < 0){
            System.out.println("Please enter an array density between 0 and 1.0");
            in = new Scanner(System.in);
            arrayDensity = in.nextDouble();
        }
        if (arrayDensity >= 1) {
            System.out.println("Please enter an array density between 0 and 1.0");
            in = new Scanner(System.in);
            arrayDensity = in.nextDouble();
        }

        startTime[0] = System.nanoTime();
        //System.out.println("System start time: " + time[0]);
        startTime[1] = System.nanoTime();
        int[] denseArray = MakeDenseArray (arrayLength, arrayDensity);
        startTime[2] = System.nanoTime();
        ArrayList<int[]> sparseArray = MakeSparseArray (arrayLength, arrayDensity);
        startTime[3] = System.nanoTime();
        ArrayList<int[]> convertedSparse = ConvertToSparse(denseArray);
        startTime[4] = System.nanoTime();
        int[] convertedDense = ConvertToDense(arrayLength, sparseArray);
        startTime[5] = System.nanoTime();
        int[] denseMax = FindDenseMax(denseArray);
        startTime[6] = System.nanoTime();
        int[] sparseMax = FindSparseMax(sparseArray);
        startTime[7] = System.nanoTime();

        for (int i = 0; i < 6; i++)
        {
            realTime[i] = startTime[i+1] - startTime[i];
            realTime[i] = realTime[i] / 1000000;
        }

        System.out.println("Make dense array\tTime: " + realTime[0] +
        "\nMake sparse array\tTime: " + realTime[1] +
        "\nSize of converted sparse array: " + convertedSparse.size() + "\tTime: " + realTime[2] +
        "\nSize of converted dense array: " + convertedDense.length + "\tTime: " + realTime[3] +
        "\nMaximum value in dense array is: " + denseMax[1] + " at spot " + denseMax[0] + "\tTime: " + realTime[4] +
        "\nMaximum value in sparse array is: " + sparseMax[1] + " at spot " + sparseMax[0] + "\tTime: " + realTime[5]);

    }

    public static int[] MakeDenseArray(int arrayLength, double arrayDensity)
    {
        int[] denseArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++)
        {
            double randomDensity = (Math.random()*1.0);

            if (arrayDensity < randomDensity)
            {
                denseArray[i] = 0;
            }
            else
            {
                denseArray[i] = (int) (Math.random()*1000000 + 1);
            }
        }

        return denseArray;
    }

    public static ArrayList<int[]> MakeSparseArray(int arrayLength, double arrayDensity)
    {
        ArrayList<int[]> sparseArray = new ArrayList <int[]>();

        for (int i = 0; i < arrayLength; i++)
        {
            double randomDensity = (Math.random() * 1.0);

            if (randomDensity < arrayDensity) {
                int[] orderedPair = new int[2];

                orderedPair[0] = i;
                orderedPair[1] = (int)(Math.random() * 1000000 + 1);
                sparseArray.add(orderedPair);

                System.out.println("Ordered pair (sparse array) " + orderedPair[0] + ", " + orderedPair[1]);
            }
        }

        System.out.println("Sparse array: " + sparseArray.toString());

        return sparseArray;
    }

    public static ArrayList<int[]> ConvertToSparse (int[] denseArray)
    {
        ArrayList<int[]> sparseArray = new ArrayList <int[]>();

        for (int i = 0; i < denseArray.length; i++)
        {
            int[] orderedPair = new int[2];

            if (denseArray[i] != 0)
            {
                orderedPair[0] = i;
                orderedPair[1] = denseArray[i];
                sparseArray.add(orderedPair);
            }
        }

        return sparseArray;
    }

    public static int[] ConvertToDense (int arrayLength, ArrayList<int[]> sparseArray)
    {
        int[] denseArray = new int[arrayLength];
        int checkSize;

        for (int i = 0; i < sparseArray.size(); i++)
        {
            int[] orderedPair = new int[2];

            orderedPair = sparseArray.get(i);

            while (orderedPair[0] != i)
            {
                denseArray[i] = 0;
                i++;
            }

            if (orderedPair[0] == i)
            {
                denseArray[i] = orderedPair[1];
            }


            System.out.println("Ordered pair to convert: " + orderedPair[0] + ", " + orderedPair[1]);
        }
        checkSize = denseArray.length;
        if (arrayLength != denseArray.length)
        {
            for (int i = checkSize; i < arrayLength; i++)
            {
                denseArray[i] = 0;
            }
        }

        for (int k = 0; k < arrayLength; k++)
        {
            System.out.println("Sparse to dense array: " + denseArray[k]);
        }

        return denseArray;

    }

    public static int[] FindDenseMax(int[] denseArray)
    {
	    int max = denseArray[0];
    	int index = 0;

	    for (int i = 1; i < denseArray.length; i++)
    	{
    	    if (max <= denseArray[i])
    	    {
    	        max = denseArray[i];
    	        index = i;
    	    }
    	    System.out.println("Dense array: " + denseArray[i]);
    	}

        System.out.println("Maximum in dense array is " + max + " at " + index);

        int[] maxValue = {index, max};
        return maxValue;
    }

    public static int[] FindSparseMax(ArrayList<int[]> sparseArray)
    {
        int[] orderedPair = new int[2];
        int max = 0;
        int index = 0;

        orderedPair = sparseArray.get(0);
        index = orderedPair[0];
        max = orderedPair[1];

        for (int i = 0; i < sparseArray.size(); i++)
        {
            orderedPair = sparseArray.get(i);

            if (max <= orderedPair[1])
            {
                max = orderedPair[1];
                index = orderedPair[0];
            }
        }

        System.out.println("Maximum in sparse array is " + max + " at " + index);

        int[] maxValue = {index, max};
        return maxValue;
    }
}
