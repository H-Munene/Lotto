package LottoCompany.player;

import LottoCompany.operations.DatabaseOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoPlayer implements LottoPlayer_interface {

    //data members
    public String name; // name of the player
    public int ID; // player's ID
    public ArrayList<Integer> selection= new ArrayList<>(); // player's choice numbers

    //constructor
    private LottoPlayer(){
        user_details();
        make_selection();
    }

    private static LottoPlayer lottoPlayer = null;

    //ensures there is only once instance of LottoPlayer
    public static LottoPlayer getInstance() {
        if(lottoPlayer == null){
            lottoPlayer = new LottoPlayer();
        }
        return lottoPlayer;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int  getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Integer> getSelection() {
        return selection;
    }

    public void setSelection(ArrayList<Integer> selection) {
        this.selection = selection;
    }

    //gets 6 unique numbers from user
    @Override
    public void make_selection() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your selection of numbers (1-39): ");
            //loop to take in 6 numbers
            for (int i = 0; i <= 5; i++) {
                selection.add(scanner.nextInt());
            }

            HashSet<Integer> check = new HashSet<>();
            //takes numbers in selection(arraylist)
            for(int i: selection){
                //validates if the numbers fall within range
                if(i>0 || i <40){
                    //adds them to the hash set
                    check.add(i);
                }else {
                    //re-enter numbers if out of range
                    System.out.println("Enter numbers within 1-39 range!!");
                    make_selection();
                }
            }

            //compares selection(arraylist) and check(hashset)
            /*
            if there are e.g 3 redundant numbers,7, in selection, only a single number
            7,will be retained. This results in different sizes of the collections
             */
            if(selection.size()!= check.size()){
                System.out.println("Enter unique numbers only");
                System.out.println();
                //re-enter numbers
                make_selection();
            }else{
                //no redundant numbers
                System.out.println("Selection made successfully");
                //displays the chosen numbers
                show_selection();
            }
        }catch(InputMismatchException e){
            System.out.println("Enter numbers only");
        }
    }
    @Override
    public void user_details() {
        Scanner scanner = new Scanner(System.in);
        try {
            //enter player id
            System.out.print("Enter your id: ");
            ID = scanner.nextInt();
            scanner.nextLine();
            setID(ID);

            //enter player name
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            //limits to alphabet characters only
            if(name.matches("[a-zA-z ]+")){
                setName(name);

                try{
                    DatabaseOperations dbOperations = DatabaseOperations.getInstance();

                    /*
                    represents a reference to a LottoPlayer object.
                    By calling the setLottoPlayer method with 'this' as an argument,
                    the current instance of the LottoPlayer class
                    is passed to the setLottoPlayer method
                     */
                    dbOperations.setLottoPlayer(this);

                    //call the create method to insert data into the database
                    dbOperations.create();
                } catch (SQLException e){
                    e.printStackTrace();
                }

            }else{
                // name != alphabet letters
                System.out.println("Enter a valid name");
                System.out.println();
                user_details();
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter a valid ID!!");

            user_details();
        }
    }


    //displays the numbers selected
    @Override
    public void show_selection() {
        System.out.println();
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getID());
        System.out.println(getSelection());

    }
    //methods



}
