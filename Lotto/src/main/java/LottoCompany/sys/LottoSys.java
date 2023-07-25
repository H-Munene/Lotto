package LottoCompany.sys;

import LottoCompany.player.LottoPlayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class LottoSys implements LottoSys_interface {
    public static final int WINNING = 6;
   //public boolean win = false;
    public ArrayList<Integer> winning_numbers;

    public boolean win = false;

    public LottoSys() {
        create_gameid();
        generate_winning_numbers();
    }

    public ArrayList<Integer> getWinning_numbers() {
        return winning_numbers;
    }

    public void setWinning_numbers(ArrayList<Integer> winning_numbers) {
        this.winning_numbers = winning_numbers;
    }

    @Override
    public void generate_winning_numbers() {
        HashSet<Integer> check = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(40);
            //add random numbers to check hash set
            check.add(randomNumber);
        }

        //if check hash set != WINNING (6)
        //implies there were repeating rand numbers
        if(check.size() == WINNING){
            setWinning_numbers(new ArrayList<>(check));
            System.out.println(getWinning_numbers());
        }else{
            //rand numbers are thus recreated till hash set
            //has size equal to WINNING
            generate_winning_numbers();
        }
    }

    /*
    this method takes in an instance of LottoPlayer
    and compares the selection numbers of the user and the
    winning numbers of the system
    displays a boolean depending on comparison result
     */
    @Override
    public void compare_selection_winNumbs(LottoPlayer player) {
        win = this.winning_numbers == player.getSelection();

        if (win){
            System.out.println("Congratulations. You have won");
        }else{
            System.out.println();
            System.out.println("Numbers do not match. Try again!");
        }
    }

    //generates gameid for an entry
    @Override
    public void create_gameid() {
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        String randomString = sb.toString();
        System.out.println(randomString);
    }
}

