package LottoCompany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class LottoSys implements LottoSys_interface{
    public static final int WINNING = 6;
   //public boolean win = false;
    public ArrayList<Integer> winning_numbers;

    public LottoSys() {
        /*create_gameid();
        generate_winning_numbers();*/
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
            check.add(randomNumber);
            //System.out.println(randomNumber);
        }

        if(check.size() == WINNING){
            setWinning_numbers(new ArrayList<>(check));
            System.out.println(getWinning_numbers());
        }else{
            generate_winning_numbers(); // regenerate numbers
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
        System.out.println(this.winning_numbers == player.getSelection());
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

