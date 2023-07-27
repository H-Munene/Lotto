package LottoCompany.player;

import LottoCompany.operations.DatabaseOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoPlayer implements LottoPlayer_interface {
    private DatabaseOperations databaseOperations;

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

    @Override
    public void make_selection() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your selection of numbers (1-39): ");
            for (int i = 0; i <= 5; i++) {
                selection.add(scanner.nextInt());
            }

            HashSet<Integer> check = new HashSet<>();
            for(int i: selection){
                if(i>0 || i <40){
                    check.add(i);
                }else {
                    System.out.println("Enter numbers within 1-39 range!!");
                    make_selection();
                }
            }
            if(selection.size()!= check.size()){
                System.out.println("Enter unique numbers only");
                System.out.println();

                make_selection();
            }else{
                System.out.println("Selection made successfully");
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
            if(name.matches("[a-zA-z ]+")){
                setName(name);

                try{
                    DatabaseOperations dbOperations = DatabaseOperations.getInstance();

                    // Set the lottoPlayer instance in dbOperations
                    dbOperations.setLottoPlayer(this);

                    // Now you can call the create method to insert data into the database
                    dbOperations.create();
                } catch (SQLException e){
                    e.printStackTrace();
                }

            }else{
                System.out.println("Enter a valid name");
                System.out.println();
                user_details();
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter a valid ID!!");

            user_details();
        }
    }

    @Override
    public void show_selection() {
        System.out.println();
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getID());
        System.out.println(getSelection());

    }
    //methods



}
