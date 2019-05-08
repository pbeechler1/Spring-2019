/*
Phil Beechler
IT 1323L Final
May 4th, 2019
 */

import java.util.*;
import java.io.*;
public class FinalExam {

    public static int maximum(int[] arr){
        //maximum method
        int tempMax = 0;
        int len = arr.length;
        for(int x = 0; x < len; x++){
            if(arr[x] > tempMax)       {
                tempMax = arr[x];
            }
        }
        return tempMax;
    }

    public static double average(int[] arr){
        //average method
        int total=0;
        double tempAvg = 0.0;
        int len = arr.length;
        for(int x = 0; x < len; x++){
            total += arr[x];
        }
        tempAvg = total/10;
        return tempAvg;
    }

    public static int[] sort(int[] arr){
        int len = arr.length;
        for(int x = 0; x < len; x++){ //sort method
            for(int y = 0; y < len-x-1; y++){
                if(arr[y] > arr[y+1]){
                    int temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args)throws IOException{
        int[] array = new int[10];
        int[] sortedArray = new int[10];
        int len = array.length;
        double average;
        int temp, maximum;
        String line;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Phil\\Desktop\\IT 1323L Final\\input.txt"));
        FileWriter wr = new FileWriter("C:\\Users\\Phil\\Desktop\\IT 1323L Final\\output.txt");

        try{
            for(int x = 0; x < len; x++){ //read in
                line = br.readLine();
                array[x] = Integer.parseInt(line);
            }

            //call selection sort, max, and average here
            sortedArray = FinalExam.sort(array);
            maximum = FinalExam.maximum(array);
            average = FinalExam.average(array);

            for(int y = 0; y < len; y++){ //write out
                String tempString = " "+sortedArray[y];
                wr.write(tempString);
            }
            wr.write(System.lineSeparator());
            wr.write("Maximum: "+ maximum);
            wr.write(System.lineSeparator());
            wr.write("Average: "+average);
            wr.close();
        }catch(IOException e){e.printStackTrace();}

    }
}
