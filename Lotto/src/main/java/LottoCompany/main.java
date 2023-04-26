package LottoCompany;

public class main {
    public static void main(String[] args){
        LottoPlayer instance1 = new LottoPlayer();
        instance1.user_details();
        instance1.make_selection();

        LottoSys instance2 = new LottoSys();
        instance2.generate_winning_numbers();
//        instance2.compare_selection_winNumbs(instance1);
        }
    }

