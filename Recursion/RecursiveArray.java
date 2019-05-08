/*Phil Beechler
March 15, 2019
Module 5A Lab
Use recursion to add up all values of int array
Sources used: (1) Class Slides
*/
import java.util.Scanner;
public class RecursiveArray {
    int[] arr;
    int arraySize;

    //constructor method for Recursive Object
    public RecursiveArray(int[] arr){
        //creates initial array and use it to substantiate array size
        this.arr = arr;
        this.arraySize = arr.length;
    }

    //get-set methods for array & array size
    public void setArr(int[] arr){ this.arr = arr; }
    public int[] getArr() { return this.arr; }

    public void setArrSize(int arraySize){ this.arraySize = arraySize; }
    public int getArraySize(){ return this.arraySize; }

    public String getArrayValues(){
        //returns a String to the final toString method of the array values
        String tempString = "";
        for(int y = 0; y < this.arraySize; y++){
            tempString += " "+this.arr[y]+" ";
        }
        return tempString;
    }

    public String toString(){
        return "Array Values: "+getArrayValues()
                +" "
                +"\n"
                +"Sum: "+recursiveCalc(getArr(), getArraySize());
    }

    public int recursiveCalc(int[] arr, int arraySize){
        if(arraySize == 0){ return 0; } //base
        else { return recursiveCalc(arr, arraySize-1) + arr[arraySize-1]; } //sends values back to itself until 0
    }
}
class Test{
    public static void main(String[] args){
        //test class that makes sure object works
        Scanner input = new Scanner(System.in);
        int[] tempArr;
        int arrSize;
        System.out.println("How many elements do you want to enter?");
        arrSize = input.nextInt();
        tempArr = new int[arrSize];
        System.out.println("Alrighty let's fill this array.");
        for(int x = 0; x < arrSize; x++){
            System.out.println("Enter element number "+(x+1));
            tempArr[x] = input.nextInt();
        }
        RecursiveArray recurseObj = new RecursiveArray(tempArr);
        System.out.println(recurseObj.toString());
    }
}
