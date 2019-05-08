/*Phil Beechler
April 11, 2019
Create Trivia class that extends Game
Create LinkedList
*/

import java.util.*;

public class Game {

    String description;

    //constructor for Game
    public Game(String description){
        this.description = description;
    }

    //get-set method for Game
    public void setDescription(String description){this.description = description;}
    public String getDescription(){ return this.description; }

    //toString method that will spit out
    //Description:
    public String toString(){
        return "Description: "+getDescription();
    }
}
class Trivia extends Game{
    int gameID, questionNum;
    double prizeMoney;

    //constructor for Trivia class
    public Trivia(int gameID, double prizeMoney, int questionNum, String description){
        super(description);
        this.gameID = gameID;
        this.prizeMoney = prizeMoney;
        this.questionNum = questionNum;
    }

    //get-set methods for Trivia class
    public void setGameID(int gameID){ this.gameID = gameID; }
    public int getGameID(){ return this.gameID; }

    public void setPrizeMoney(double prizeMoney){ this.prizeMoney = prizeMoney;}
    public double getPrizeMoney(){return this.prizeMoney; }

    public void setQuestionNum(int questionNum){ this.questionNum = questionNum;}
    public int getQuestionNum(){ return this.questionNum; }

    /* toString method spitting out info in the following format:
     Description:
     Game ID:
     Total Prize Money:
     Questions Needed to Win:
     */
    @Override
    public String toString(){
        return "Description: "+super.getDescription()
                +"\n"
                +"Game ID: "+getGameID()
                +"\n"
                +"Total Prize Money: $"+String.format("%.2f",(getPrizeMoney()))
                +"\n"
                +"Questions Needed to Win: "+getQuestionNum()
                +"\n";
    }
}
class TriviaLinkedList extends LinkedList{
    TriviaNode<Trivia> head, tail;
    int size = 0;

    //Constructor method for TriviaLinkedList
    public TriviaLinkedList(Trivia[] triviaObj){
        for(int x = 0; x < triviaObj.length; x++){
            addFirst(triviaObj[x]);
        }
    }

    //adds trivia object to linked list
    public void add(int index, Trivia triviaObj){
        if (index == 0) { addFirst(triviaObj); }
        else if (index >= size){ addLast(triviaObj);}
        else {
            TriviaNode<Trivia> currentNode = head;
            for (int x = 0; x < index; x++){
                currentNode = currentNode.next;
                TriviaNode<Trivia> temp = currentNode.next;
                currentNode.next = new TriviaNode<>(triviaObj);
                (currentNode.next).next = temp;
                size++;
            }
        }
    }

    //adds to the top of the linked list via the add() method
    public void addFirst(Trivia triviaObj){
        TriviaNode<Trivia> newObj = new TriviaNode<>(triviaObj);
        newObj.next = head;
        head = newObj;
        size++;

        if(tail == null){
            tail = head;
        }
    }

    //adds to the end of the linked list via the add() method
    public void addLast(Trivia triviaObj){
        if (tail == null){ head = tail = new TriviaNode<>(triviaObj); }

        else {
            tail.next = new TriviaNode<>(triviaObj);
            tail = tail.next;
        }
        size++;
    }

    //method to remove objects based on game ID
    /*public Trivia remove(int gameID){  THIS METHOD IS COMMENTED OUT BECAUSE I'M STUCK
        TriviaNode<Trivia> currentNode = head;
        System.out.println("Searching for Game ID: "+gameID+".");
        while(currentNode != null){
            if(currentNode.getGameID().)
        }
    }*/

    //removes trivia object based on index
    public Trivia remove(int index){
        if (index < 0 || index >=size) { return null;}
        else if (index == 0) {return removeFirst(); }
        else if (index == size-1) { return removeLast();}
        else{
            TriviaNode<Trivia> previous = head;
            for (int x = 1; x < index; x++){
                previous = previous.next;
            }
            TriviaNode<Trivia> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    //removes the first element in the linked list via remove()
    public Trivia removeFirst(){
        if (size == 0) { return null;}
        else{
            TriviaNode<Trivia> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
                size = 0;
            }
            return temp.element;
        }
    }

    //removes the last element in linked list via remove() method
    public Trivia removeLast(){
        if(size == 0) {
            System.out.println("There are no elements in the list.)");
            return null;
        }
        else if (size == 1){
            TriviaNode<Trivia> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else{
            TriviaNode<Trivia> current = head;
            for (int x = 0; x < size-2; x++){
                current = current.next;
            }
            TriviaNode<Trivia> temp = tail;
            tail = current;
            tail.next = tail;
            size--;
            return temp.element;
        }
    }

    @Override //overriding toSTring method to output elements in linked list
    public String toString(){
        StringBuilder output = new StringBuilder("\n");
        TriviaNode<Trivia> current = head;
        for (int x = 0; x < size; x++){
            output.append(current.element);
            current = current.next;
            if (current != null){
                output.append("\n");
            }
            else{
                output.append("\n");
            }
        }
        return output.toString();
    }

    class TriviaNode<Trivia>{
        Trivia element;
        TriviaNode<Trivia> next = null;

        public TriviaNode(Trivia element){
            this.element = element;
        }
    }
}
class Test{

    //test class to manipulate Trivia objects
    public static void main(String[] args){
        Random rand = new Random();
        int gameID, questionNum;
        double prizeMoney;
        String description;
        Trivia[] triviaObj = new Trivia[5];
        System.out.println("Let's create some Trivia objects and see what happens.");
        for(int x = 0; x < 5; x++){ //creates an array of the Trivia objects
            gameID = rand.nextInt(500);
            questionNum = rand.nextInt(20);
            prizeMoney = rand.nextInt(100000) / 1.0; //creates a random double for prize money
            description = "Trivia Object #"+(x+1);
            triviaObj[x] = new Trivia(gameID, prizeMoney, questionNum, description);
        }
        TriviaLinkedList testList = new TriviaLinkedList(triviaObj);
        System.out.println("Let's test this linkedlist real quick.");
        System.out.println();
        System.out.println(testList.toString());
        System.out.println();
        System.out.println("Now we're going to remove Trivia Game #2");
        System.out.println("Node removed: "+testList.remove(1));
        System.out.println();
        System.out.println("New linkedlist: ");
        System.out.println(testList.toString());
        System.out.println();
        System.out.println("Let's add a new element");
        gameID = rand.nextInt(500);
        questionNum = rand.nextInt(20);
        prizeMoney = rand.nextInt(100000) / 1.0;
        description = "Trivia Object #: NEW OBJECT";
        Trivia temp = new Trivia(gameID, prizeMoney, questionNum, description);
        testList.addFirst(temp);
        System.out.println("New linkedlist: ");
        System.out.println(testList.toString());


    }

}
