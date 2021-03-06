//Phil Beechler
//April 19, 2019
//Module 7A Lab Assignment
//2D Array sort of high and low values
//Sources used: (1) Class Slides
import java.util.*;
public class HiLoTemp {
    //sorts the temperatures from highest to lowest
    public static int[] sortHighTemps(int[][] array){
        int[] temp = new int[12];
        boolean needNextPass = true;
        int arrayLength = array.length;
        for(int a = 0; a < temp.length; a++){ //create singular array to be sorted
            temp[a] = array[a][1];
        }
        for (int x = 1; x < arrayLength && needNextPass; x++){ //row
            needNextPass = false;
            for (int y = 0; y < temp.length-x; y++){ //column
                if(temp[y] < temp[y+1]) { //moves the largest values to the top
                    int swapValue = temp[y];
                    temp[y] = temp[y+1];
                    temp[y+1] = swapValue;
                    needNextPass = true;
                }
            }
        }
        return temp;
    }

    //sorts the temperatures by lowest to highest
    public static int[] sortLowTemps(int[][] array){
        int[] temp = new int[12];
        boolean needNextPass = true;
        int arrayLength = array.length;
        for(int a = 0; a < temp.length; a++){ //create singular array to be sorted
            temp[a] = array[a][1];
        }
        for (int x = 1; x < arrayLength && needNextPass; x++){ //row
            needNextPass = false;
            for (int y = 0; y < temp.length-x; y++){ //column
                if(temp[y] > temp[y+1]) { //moves the largest values to the bottom of the array
                    int swapValue = temp[y];
                    temp[y] = temp[y+1];
                    temp[y+1] = swapValue;
                    needNextPass = true;
                }
            }
        }
        /*for(int a = 0; a < temp.length; a++){ //testing
            System.out.println(temp[a]);
        }*/
        return temp;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int[][] tempValues = new int[12][2]; //substantiate array for temperature values
        int[][] sortedTemperatures = new int[12][2]; //int array to hold sorted values
        int[] high, low = new int[12];
        for (int i=0; i<tempValues.length; i++){ //use for loop to add high/low temp values
            /*System.out.println("Please enter month "+(i+1)+"'s high temperature.");
            tempValues[i][0]=input.nextint();
            System.out.println("Please enter month "+(i+1)+"'s low temperature.");
            tempValues[i][1]=input.nextint();*/ //commenting out to test
            tempValues[i][0] = rand.nextInt(105);
            tempValues[i][1] = rand.nextInt(70);
        }
        System.out.println();
        System.out.println("Let's see those values.");
        System.out.println("High Temps        Low Temps"); //format outputs
        for (int j=0; j<tempValues.length; j++){
            System.out.println("   "+tempValues[j][0]+"            "+tempValues[j][1]);
        }
        System.out.println();
        high = sortHighTemps(tempValues);
        low = sortLowTemps(tempValues);
        /*for(int y = 0; y<sortedTemperatures.length; y++){
            sortedTemperatures[y][0] = high[y][0];
            sortedTemperatures[y][1] = low[y][1];
        }*/
        System.out.println("Sorted Values:");
        System.out.println("High Temps      Low Temps"); //format outputs
        for (int x=0; x<tempValues.length; x++){
            System.out.println("   "+high[x]+"            "+low[x]);
        }
    }
}
